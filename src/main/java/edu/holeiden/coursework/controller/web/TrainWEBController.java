package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.AdministrationForm;
import edu.holeiden.coursework.form.SearchForm;
import edu.holeiden.coursework.form.TrainForm;
import edu.holeiden.coursework.model.*;
import edu.holeiden.coursework.service.brigade.impls.BrigadeServiceImpl;
import edu.holeiden.coursework.service.train.impls.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/ptrain")
public class TrainWEBController {
    @Autowired
    TrainServiceImpl service;

    @Autowired
    BrigadeServiceImpl brigadeService;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("trains", service.getall());
        return "trainList";
    }

    @RequestMapping(value = "/get/list", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<Train> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("trains", list);
        return "trainList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("trains", service.getall());
        return "redirect:/web/ptrain/get/list";
    }

    @RequestMapping("/create")
    String create(Model model){
        TrainForm trainForm = new TrainForm();
        Map<String, String> mavs = brigadeService.getall().stream()
                .collect(Collectors.toMap(Brigade::getId, Brigade::getNumber));
        model.addAttribute("mavs", mavs);
        model.addAttribute("trainForm", trainForm);
        return "trainAdd";
    }

    @PostMapping("/create")
    String create(Model model, @ModelAttribute("trainForm") TrainForm trainForm){
        Train train = new Train();
        Brigade brigade = brigadeService.get(trainForm.getTrainBrigade());
        Brigade brigadee = brigadeService.get(trainForm.getRecoveryBrigade());

        train.setModel(trainForm.getModel());

            String model1 = trainForm.getModel();
            Pattern pattern1 = Pattern.compile(".{3,30}");
            Matcher matcher1 = pattern1.matcher(model1);

            if(!matcher1.matches()){
                return "redirect:/web/ptrain/error14";
            }

        train.setTrainBrigade(brigade);

        train.setRecoveryBrigade(brigadee);

        train.setYearOfManufacture(trainForm.getYearOfManufacture());

            String yearOfManufacture = trainForm.getYearOfManufacture();
            Pattern pattern3 = Pattern.compile("^[1][9][0-9][0-9]$|^[2][0][0-9][0-9]$");
            Matcher matcher3 = pattern3.matcher(yearOfManufacture);

            if(!matcher3.matches()){
                return "redirect:/web/ptrain/error17";
            }

        train.setNumberOfPassengers(trainForm.getNumberOfPassengers());

            String numberOfPassengers = trainForm.getNumberOfPassengers();
            Pattern pattern4 = Pattern.compile("^[1-9][0-9]{0,1}[0-9]{0,1}");
            Matcher matcher4 = pattern4.matcher(numberOfPassengers);

            if(!matcher4.matches()){
                return "redirect:/web/ptrain/error6";
            }

        train.setDescriction(trainForm.getDescriction());

            String description = trainForm.getDescriction();
            Pattern pattern2 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher2 = pattern2.matcher(description);

            if(!matcher2.matches()){
                return "redirect:/web/ptrain/error5";
            }

        service.save(train);
        model.addAttribute("trains", service.getall());
        return "redirect:/web/ptrain/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Train train = service.get(id);
        TrainForm trainForm = new TrainForm();
        Map<String, String> mavs = brigadeService.getall().stream()
                .collect(Collectors.toMap(Brigade::getId, Brigade::getNumber));
        trainForm.setModel(train.getModel());
        trainForm.setTrainBrigade(train.getTrainBrigade().getNumber());
        trainForm.setRecoveryBrigade(train.getRecoveryBrigade().getNumber());
        trainForm.setYearOfManufacture(train.getYearOfManufacture());
        trainForm.setNumberOfPassengers(train.getNumberOfPassengers());
        trainForm.setDescriction(train.getDescriction());
        model.addAttribute("mavs", mavs);
        model.addAttribute("trainForm", trainForm);
        return "trainAdd";
    }

    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("trainForm") TrainForm trainForm){
        Train train = new Train();
        Brigade brigade = brigadeService.get(trainForm.getTrainBrigade());
        Brigade brigadee = brigadeService.get(trainForm.getRecoveryBrigade());
        train.setId(id);
        train.setModel(trainForm.getModel());

            String model1 = trainForm.getModel();
            Pattern pattern1 = Pattern.compile(".{3,30}");
            Matcher matcher1 = pattern1.matcher(model1);

            if(!matcher1.matches()){
                return "redirect:/web/ptrain/error14";
            }

        train.setTrainBrigade(brigade);

        train.setRecoveryBrigade(brigadee);

        train.setYearOfManufacture(trainForm.getYearOfManufacture());

            String yearOfManufacture = trainForm.getYearOfManufacture();
            Pattern pattern3 = Pattern.compile("^[1][9][0-9][0-9]$|^[2][0][0-9][0-9]$");
            Matcher matcher3 = pattern3.matcher(yearOfManufacture);

            if(!matcher3.matches()){
                return "redirect:/web/ptrain/error17";
            }

        train.setNumberOfPassengers(trainForm.getNumberOfPassengers());

            String numberOfPassengers = trainForm.getNumberOfPassengers();
            Pattern pattern4 = Pattern.compile("^[1-9][0-9]{0,1}[0-9]{0,1}");
            Matcher matcher4 = pattern4.matcher(numberOfPassengers);

            if(!matcher4.matches()){
                return "redirect:/web/ptrain/error6";
            }

        train.setDescriction(trainForm.getDescriction());

            String description = trainForm.getDescriction();
            Pattern pattern2 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher2 = pattern2.matcher(description);

            if(!matcher2.matches()){
                return "redirect:/web/ptrain/error5";
            }

        service.save(train);
        model.addAttribute("trains", service.getall());
        return "redirect:/web/ptrain/get/list";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Train> trains = service.getall();
        List<Train> sorted = service.sortByName(trains);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("trains", sorted);
        return "trainList";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Train> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("trains", list);
        return "trainList";
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
