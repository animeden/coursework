package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.BrigadeForm;
import edu.holeiden.coursework.form.DepartmentForm;
import edu.holeiden.coursework.form.SearchForm;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.model.Brigade;
import edu.holeiden.coursework.model.Department;
import edu.holeiden.coursework.service.administration.impls.AdministrationServiceImpl;
import edu.holeiden.coursework.service.department.impls.DepartmentServiceImpl;
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
@RequestMapping("/web/department")
public class DepartmentWEBController {
    @Autowired
    DepartmentServiceImpl service;

    @Autowired
    AdministrationServiceImpl administrationService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("departments", service.getall());
        return "departmentList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<Department> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("departments", list);
        return "departmentList";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("departments", service.getall());
        return "redirect:/web/department/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/create")
    String create(Model model){
        DepartmentForm departmentForm = new DepartmentForm();
        Map<String, String> mavs = administrationService.getall().stream()
                .collect(Collectors.toMap(Administration::getId, Administration::getName));
        model.addAttribute("mavs", mavs);
        model.addAttribute("departmentForm", departmentForm);
        return "departmentAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    String create(Model model, @ModelAttribute("departmentForm") DepartmentForm departmentForm){
        Department department = new Department();
        Administration administration = administrationService.get(departmentForm.getAdministrationID());
        department.setName(departmentForm.getName());

            String name = departmentForm.getName();
            Pattern pattern1 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s][a-zа-яіїєґ]{3,12}[\\s]{0,1}[№][1-9][0-9]{0,1}$");
            Matcher matcher1 = pattern1.matcher(name);

            if(!matcher1.matches()){
                return "redirect:/web/department/error7";
            }

        department.setAdress(departmentForm.getAdress());

            String adress = departmentForm.getAdress();
            Pattern pattern4 = Pattern.compile(".{10,100}");
            Matcher matcher4 = pattern4.matcher(adress);

            if(!matcher4.matches()){
                return "redirect:/web/department/error9";
            }

        department.setAdministrationID(administration);

        department.setNumberOfBrigates(departmentForm.getNumberOfBrigates());

            String numberOfBrigates = departmentForm.getNumberOfBrigates();
            Pattern pattern2 = Pattern.compile("^[1-9][0-9]{0,1}$");
            Matcher matcher2 = pattern2.matcher(numberOfBrigates);

            if(!matcher2.matches()){
                return "redirect:/web/department/error8";
            }

        department.setDescriction(departmentForm.getDescriction());

            String description = departmentForm.getDescriction();
            Pattern pattern3 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher3 = pattern3.matcher(description);

            if(!matcher3.matches()){
                return "redirect:/web/department/error5";
            }

        service.save(department);
        model.addAttribute("departments", service.getall());
        return "redirect:/web/department/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Department department = service.get(id);
        DepartmentForm departmentForm = new DepartmentForm();
        Map<String, String > mavs = administrationService.getall().stream()
                .collect(Collectors.toMap(Administration::getId, Administration::getName));
        departmentForm.setName(department.getName());

            String name = departmentForm.getName();
            Pattern pattern1 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s][a-zа-яіїєґ]{3,12}[\\s]{0,1}[№][1-9][0-9]{0,1}$");
            Matcher matcher1 = pattern1.matcher(name);

            if(!matcher1.matches()){
                return "redirect:/web/department/error7";
            }


        departmentForm.setAdress(department.getAdress());

            String adress = departmentForm.getAdress();
            Pattern pattern4 = Pattern.compile(".{10,100}");
            Matcher matcher4 = pattern4.matcher(adress);

            if(!matcher4.matches()){
                return "redirect:/web/department/error9";
            }

        departmentForm.setAdministrationID(department.getAdministrationID().getName());

        departmentForm.setNumberOfBrigates(department.getNumberOfBrigates());

            String numberOfBrigates = departmentForm.getNumberOfBrigates();
            Pattern pattern2 = Pattern.compile("^[1-9][0-9]{0,1}$");
            Matcher matcher2 = pattern2.matcher(numberOfBrigates);

            if(!matcher2.matches()){
                return "redirect:/web/department/error8";
            }

        departmentForm.setDescriction(department.getDescriction());

            String description = departmentForm.getDescriction();
            Pattern pattern3 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher3 = pattern3.matcher(description);

            if(!matcher3.matches()){
                return "redirect:/web/department/error5";
            }

        model.addAttribute("mavs", mavs);
        model.addAttribute("departmentForm", departmentForm);
        return "departmentAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("departmentForm") DepartmentForm departmentForm){
        Department department = new Department();
        Administration administration = administrationService.get(departmentForm.getAdministrationID());
        department.setId(id);
        department.setName(departmentForm.getName());
        department.setAdress(departmentForm.getAdress());
        department.setAdministrationID(administration);
        department.setNumberOfBrigates(departmentForm.getNumberOfBrigates());
        department.setDescriction(departmentForm.getDescriction());
        service.save(department);
        model.addAttribute("departments", service.getall());
        return "redirect:/web/department/get/list";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Department> departments = service.getall();
        List<Department> sorted = service.sortByName(departments);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("departments", sorted);
        return "departmentList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Department> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("departments", list);
        return "departmentList";
    }

    @PostMapping("/error7")
    public String errorfinder7(){
        return "error";
    }

    @PostMapping("/error8")
    public String errorfinder8(){
        return "error";
    }

    @PostMapping("/error5")
    public String errorfinder5(){
        return "error";
    }

    @PostMapping("/error9")
    public String errorfinder9(){
        return "error";
    }
}
