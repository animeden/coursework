package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.BrigadeForm;
import edu.holeiden.coursework.form.DepartmentForm;
import edu.holeiden.coursework.model.Brigade;
import edu.holeiden.coursework.model.Department;
import edu.holeiden.coursework.service.department.impls.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/department")
public class DepartmentWEBController {
    @Autowired
    DepartmentServiceImpl service;

    @RequestMapping("/get/list")
    String getall(Model model){
        model.addAttribute("departments", service.getall());
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
        model.addAttribute("departmentForm", departmentForm);
        return "departmentAdd";
    }

    @PostMapping("/create")
    String create(Model model, @ModelAttribute("brigadeForm") DepartmentForm departmentForm){
        Department department = new Department();
        department.setName(departmentForm.getName());
        department.setAdress(departmentForm.getAdress());
        department.setAdministrationID(departmentForm.getAdministrationID());
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
        departmentForm.setName(department.getName());
        departmentForm.setAdress(department.getAdress());
        departmentForm.setAdministrationID(department.getAdministrationID());
        departmentForm.setNumberOfBrigates(department.getNumberOfBrigates());
        departmentForm.setDescriction(department.getDescriction());
        model.addAttribute("departmentForm", departmentForm);
        return "departmentAdd";
    }

    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("departmentForm") DepartmentForm departmentForm){
        Department department = new Department();
        department.setId(id);
        department.setName(departmentForm.getName());
        department.setAdress(departmentForm.getAdress());
        department.setAdministrationID(departmentForm.getAdministrationID());
        department.setNumberOfBrigates(departmentForm.getNumberOfBrigates());
        department.setDescriction(departmentForm.getDescriction());
        service.save(department);
        model.addAttribute("departments", service.getall());
        return "redirect:/web/department/get/list";
    }
}
