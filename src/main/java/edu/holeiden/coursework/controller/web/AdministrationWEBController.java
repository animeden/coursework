package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.service.administration.impls.AdministrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/web/administration")
public class AdministrationWEBController {
    @Autowired
    AdministrationServiceImpl service;

    @RequestMapping("/get/list")
    String getall(Model model){
        model.addAttribute("administrations", service.getall());
        return "administrationList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("administrations", service.getall());
        return "administrationList";
    }

   // @RequestMapping("/create")
    //String create(){
        //return administrationAdd;
    //}
}
