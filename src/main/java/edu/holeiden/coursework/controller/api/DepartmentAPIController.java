package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.model.Department;
import edu.holeiden.coursework.service.department.impls.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentAPIController {
    @Autowired
    DepartmentServiceImpl service;

    @RequestMapping("/get/list")
    List<Department> getall(){
        return service.getall();
    }

    @RequestMapping("/get/{id}")
    Department get(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping("/delete/{id}")
    Department delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Department create(@RequestBody Department department){
        return service.save(department);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    Department edit(@RequestBody Department department){
        return service.edit(department);
    }
}
