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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/department")
public class DepartmentWEBController {
    @Autowired
    DepartmentServiceImpl service;

    @Autowired
    AdministrationServiceImpl administrationService;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("departments", service.getall());
        return "departmentList";
    }

    @RequestMapping(value = "/get/list", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<Department> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("departments", list);
        return "departmentList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("departments", service.getall());
        return "redirect:/web/department/get/list";
    }

    @RequestMapping("/create")
    String create(Model model){
        DepartmentForm departmentForm = new DepartmentForm();
        Map<String, String> mavs = administrationService.getall().stream()
                .collect(Collectors.toMap(Administration::getId, Administration::getName));
        model.addAttribute("mavs", mavs);
        model.addAttribute("departmentForm", departmentForm);
        return "departmentAdd";
    }

    @PostMapping("/create")
    String create(Model model, @ModelAttribute("departmentForm") DepartmentForm departmentForm){
        Department department = new Department();
        Administration administration = administrationService.get(departmentForm.getAdministrationID());
        department.setName(departmentForm.getName());
        department.setAdress(departmentForm.getAdress());
        department.setAdministrationID(administration);
        department.setNumberOfBrigates(departmentForm.getNumberOfBrigates());
        department.setDescriction(departmentForm.getDescriction());
        service.save(department);
        model.addAttribute("departments", service.getall());
        return "redirect:/web/department/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Department department = service.get(id);
        DepartmentForm departmentForm = new DepartmentForm();
        Map<String, String > mavs = administrationService.getall().stream()
                .collect(Collectors.toMap(Administration::getId, Administration::getName));
        departmentForm.setName(department.getName());
        departmentForm.setAdress(department.getAdress());
        departmentForm.setAdministrationID(department.getAdministrationID().getName());
        departmentForm.setNumberOfBrigates(department.getNumberOfBrigates());
        departmentForm.setDescriction(department.getDescriction());
        model.addAttribute("mavs", mavs);
        model.addAttribute("departmentForm", departmentForm);
        return "departmentAdd";
    }

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

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Department> departments = service.getall();
        List<Department> sorted = service.sortByName(departments);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("departments", sorted);
        return "departmentList";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Department> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("departments", list);
        return "departmentList";
    }
}
