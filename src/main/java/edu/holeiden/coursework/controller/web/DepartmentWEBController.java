package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.model.Department;
import edu.holeiden.coursework.service.department.impls.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return "departmentList";
    }
}
