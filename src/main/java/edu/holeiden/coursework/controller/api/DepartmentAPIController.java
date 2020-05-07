package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Department;
import edu.holeiden.coursework.service.department.impls.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentAPIController {
    @Autowired
    DepartmentServiceImpl service;

    @RequestMapping("/list")
    List<Department> getall(){
        return service.getall();
    }
}
