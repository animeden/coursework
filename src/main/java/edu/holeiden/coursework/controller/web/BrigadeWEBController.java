package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.AdministrationForm;
import edu.holeiden.coursework.form.BrigadeForm;
import edu.holeiden.coursework.form.SearchForm;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.model.Brigade;
import edu.holeiden.coursework.model.Department;
import edu.holeiden.coursework.service.brigade.impls.BrigadeServiceImpl;
import edu.holeiden.coursework.service.department.impls.DepartmentServiceImpl;
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
@RequestMapping("/web/brigade")
public class BrigadeWEBController {
    @Autowired
    BrigadeServiceImpl service;

    @Autowired
    DepartmentServiceImpl departmentService;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("brigades", service.getall());
        return "brigadeList";
    }

    @RequestMapping(value = "/get/list", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<Brigade> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("brigades", list);
        return "brigadeList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("brigades", service.getall());
        return "redirect:/web/brigade/get/list";
    }

    @RequestMapping("/create")
    String create(Model model){
        BrigadeForm brigadeForm = new BrigadeForm();
        Map<String, String> mavs = departmentService.getall().stream()
                .collect(Collectors.toMap(Department::getId, Department::getName));
        model.addAttribute("mavs", mavs);
        model.addAttribute("brigadeForm", brigadeForm);
        return "brigadeAdd";
    }

    @PostMapping("/create")
    String create(Model model, @ModelAttribute("brigadeForm") BrigadeForm brigadeForm){
        Brigade brigade = new Brigade();
        Department department = departmentService.get(brigadeForm.getDepartmentId());

        brigade.setMission(brigadeForm.getMission());

            String mission = brigadeForm.getMission();
            Pattern pattern1 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher1 = pattern1.matcher(mission);

            if(!matcher1.matches()){
                return "redirect:/web/brigade/error4";
            }

        brigade.setNumberOfWorkers(brigadeForm.getNumberOfWorkers());

            String numberOfWorkers = brigadeForm.getNumberOfWorkers();
            Pattern pattern2 = Pattern.compile("^[1-9][0-9]{0,2}$");
            Matcher matcher2 = pattern2.matcher(numberOfWorkers);

            if(!matcher2.matches()){
                return "redirect:/web/brigade/error7";
            }

        brigade.setDepartmentId(department);

        brigade.setDescriction(brigadeForm.getDescriction());

            String description = brigadeForm.getDescriction();
            Pattern pattern3 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher3 = pattern3.matcher(description);

            if(!matcher3.matches()){
                return "redirect:/web/brigade/error5";
            }

        service.save(brigade);
        model.addAttribute("brigades", service.getall());
        return "redirect:/web/brigade/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Brigade brigade = service.get(id);
        BrigadeForm brigadeForm = new BrigadeForm();
        Map<String, String> mavs = departmentService.getall().stream()
                .collect(Collectors.toMap(Department::getId, Department::getName));
        brigadeForm.setMission(brigade.getMission());
        brigadeForm.setNumberOfWorkers(brigade.getNumberOfWorkers());
        brigadeForm.setDepartmentId(brigade.getDepartmentId().getName());
        brigadeForm.setDescriction(brigade.getDescriction());
        model.addAttribute("mavs", mavs);
        model.addAttribute("brigadeForm", brigadeForm);
        return "brigadeAdd";
    }

    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("brigadeForm") BrigadeForm brigadeForm){
        Brigade brigade = new Brigade();
        Department department = departmentService.get(brigadeForm.getDepartmentId());
        brigade.setId(id);
        brigade.setMission(brigadeForm.getMission());
        brigade.setNumberOfWorkers(brigadeForm.getNumberOfWorkers());
        brigade.setDepartmentId(department);
        brigade.setDescriction(brigadeForm.getDescriction());
        service.save(brigade);
        model.addAttribute("brigades", service.getall());
        return "redirect:/web/brigade/get/list";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Brigade> brigades = service.getall();
        List<Brigade> sorted = service.sortByName(brigades);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("brigades", sorted);
        return "brigadeList";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Brigade> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("brigades", list);
        return "brigadeList";
    }

    @PostMapping("/error4")
    public String errorfinder4(){
        return "error";
    }

    @PostMapping("/error7")
    public String errorfinder7(){
        return "error";
    }

    @PostMapping("/error5")
    public String errorfinder5(){
        return "error";
    }
}
