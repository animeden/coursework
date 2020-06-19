package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.FtrainsForm;
import edu.holeiden.coursework.form.SearchForm;
import edu.holeiden.coursework.form.TrainForm;
import edu.holeiden.coursework.model.Brigade;
import edu.holeiden.coursework.model.Ftrains;
import edu.holeiden.coursework.model.Train;
import edu.holeiden.coursework.service.brigade.impls.BrigadeServiceImpl;
import edu.holeiden.coursework.service.ftarin.impls.FtrainsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Controller
@RequestMapping("web/ftrain")
public class FtrainsWEBController {
    @Autowired
    FtrainsServiceImpl service;

    @Autowired
    BrigadeServiceImpl brigadeService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("ftrains", service.getall());
        return "ftrainList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<Ftrains> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("ftrains", list);
        return "ftrainList";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("ftrains", service.getall());
        return "redirect:/web/ftrain/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/create")
    String create(Model model){
        FtrainsForm ftrainsForm = new FtrainsForm();
        Map<String, String> mavs = brigadeService.getall().stream()
                .collect(Collectors.toMap(Brigade::getId, Brigade::getNumber));
        model.addAttribute("mavs", mavs);
        model.addAttribute("ftrainsForm", ftrainsForm);
        return "ftrainAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    String create(Model model, @ModelAttribute("ftrainsForm") FtrainsForm ftrainsForm){
        Ftrains ftrains = new Ftrains();
        Brigade brigade = brigadeService.get(ftrainsForm.getRecoveryBrigade());
        Brigade brigadee = brigadeService.get(ftrainsForm.getRecoveryBrigade());

        ftrains.setModel(ftrainsForm.getModel());

            String model1 = ftrainsForm.getModel();
            Pattern pattern1 = Pattern.compile(".{3,30}");
            Matcher matcher1 = pattern1.matcher(model1);

            if(!matcher1.matches()){
                return "redirect:/web/ftrain/error14";
            }

        ftrains.setTrainBrigade(brigade);

        ftrains.setRecoveryBrigade(brigadee);

        ftrains.setYearOfManufacture(ftrainsForm.getYearOfManufacture());

            String yearOfManufacture = ftrainsForm.getYearOfManufacture();
            Pattern pattern3 = Pattern.compile("^[1][9][0-9][0-9]$|^[2][0][0-9][0-9]$");
            Matcher matcher3 = pattern3.matcher(yearOfManufacture);

            if(!matcher3.matches()){
                return "redirect:/web/ftrain/error17";
            }

        ftrains.setLoadCapasity(ftrainsForm.getLoadCapasity());

            String loadCapasity = ftrainsForm.getLoadCapasity();
            Pattern pattern4 = Pattern.compile("^[1-9][0-9]{0,1}[0-9]{0,1}");
            Matcher matcher4 = pattern4.matcher(loadCapasity);

            if(!matcher4.matches()){
                return "redirect:/web/ftrain/error6";
            }

        ftrains.setDescriction(ftrainsForm.getDescriction());

            String description = ftrainsForm.getDescriction();
            Pattern pattern2 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher2 = pattern2.matcher(description);

            if(!matcher2.matches()){
                return "redirect:/web/ftrain/error5";
            }

        service.save(ftrains);
        model.addAttribute("ftrains", service.getall());
        return "redirect:/web/ftrain/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Ftrains ftrains = service.get(id);
        FtrainsForm ftrainsForm = new FtrainsForm();
        Map<String, String> mavs = brigadeService.getall().stream()
                .collect(Collectors.toMap(Brigade::getId, Brigade::getNumber));
        ftrainsForm.setModel(ftrains.getModel());
        ftrainsForm.setTrainBrigade(ftrains.getTrainBrigade().getNumber());
        ftrainsForm.setRecoveryBrigade(ftrains.getRecoveryBrigade().getNumber());
        ftrainsForm.setYearOfManufacture(ftrains.getYearOfManufacture());
        ftrainsForm.setLoadCapasity(ftrains.getLoadCapasity());
        ftrainsForm.setDescriction(ftrains.getDescriction());
        model.addAttribute("mavs", mavs);
        model.addAttribute("ftrainsForm", ftrainsForm);
        return "ftrainAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("ftrainsForm") FtrainsForm ftrainsForm){
        Ftrains ftrains = new Ftrains();
        Brigade brigade = brigadeService.get(ftrainsForm.getTrainBrigade());
        Brigade brigadee = brigadeService.get(ftrainsForm.getRecoveryBrigade());
        ftrains.setId(id);
        ftrains.setModel(ftrainsForm.getModel());

            String model1 = ftrainsForm.getModel();
            Pattern pattern1 = Pattern.compile(".{3,30}");
            Matcher matcher1 = pattern1.matcher(model1);

            if(!matcher1.matches()){
                return "redirect:/web/ftrain/error14";
            }

        ftrains.setTrainBrigade(brigade);

        ftrains.setRecoveryBrigade(brigadee);

        ftrains.setYearOfManufacture(ftrainsForm.getYearOfManufacture());

            String yearOfManufacture = ftrainsForm.getYearOfManufacture();
            Pattern pattern3 = Pattern.compile("^[1][9][0-9][0-9]$|^[2][0][0-9][0-9]$");
            Matcher matcher3 = pattern3.matcher(yearOfManufacture);

            if(!matcher3.matches()){
                return "redirect:/web/ftrain/error17";
            }

        ftrains.setLoadCapasity(ftrainsForm.getLoadCapasity());

            String loadCapasity = ftrainsForm.getLoadCapasity();
            Pattern pattern4 = Pattern.compile("^[1-9][0-9]{0,1}[0-9]{0,1}");
            Matcher matcher4 = pattern4.matcher(loadCapasity);

            if(!matcher4.matches()){
                return "redirect:/web/ftrain/error6";
            }

        ftrains.setDescriction(ftrainsForm.getDescriction());

            String description = ftrainsForm.getDescriction();
            Pattern pattern2 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher2 = pattern2.matcher(description);

            if(!matcher2.matches()){
                return "redirect:/web/ftrain/error5";
            }

        service.save(ftrains);
        model.addAttribute("ftrains", service.getall());
        return "redirect:/web/ftrain/get/list";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Ftrains> ftrains = service.getall();
        List<Ftrains> sorted = service.sortByName(ftrains);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("ftrains", sorted);
        return "ftrainList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Ftrains> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("ftrains", list);
        return "ftrainList";
    }

    @PostMapping("/error5")
    public String errorfinder5(){
        return "error";
    }

    @PostMapping("/error14")
    public String errorfinder14(){
        return "error";
    }

    @PostMapping("/error17")
    public String errorfinder17(){
        return "error";
    }

    @PostMapping("/error6")
    public String errorfinder6(){
        return "error";
    }
}
