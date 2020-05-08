package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.service.administration.impls.AdministrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/administration")
public class AdministrationAPIController {
    @Autowired
    AdministrationServiceImpl service;

    @RequestMapping("/get/list")
    List<Administration> getall(){
        return service.getall();
    }

    @RequestMapping("/delete/{id}")
    Administration delete(@PathVariable("id") String id){
        return service.delete(id);
    }

   @RequestMapping(value = "/create", method = RequestMethod.POST)
    Administration create(@RequestBody Administration administration){
        return service.save(administration);
    }
}
