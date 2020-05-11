package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.AdministrationForm;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.service.administration.impls.AdministrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/create")
    String create(Model model){
        AdministrationForm administrationForm = new AdministrationForm();
        model.addAttribute("administrationForm", administrationForm);
        return "administrationAdd";
    }

    @PostMapping("/create")
    String create(Model model, @ModelAttribute("administrationForm") AdministrationForm administrationForm){
        Administration administration = new Administration();
        administration.setName(administrationForm.getName());
        administration.setBirth(administrationForm.getBirth());
        administration.setPhoneNumber(administrationForm.getPhoneNumber());
        administration.setAdress(administrationForm.getAdress());
        administration.setDescriction(administrationForm.getDescriction());
        service.save(administration);
        model.addAttribute("administrations", service.getall());
        return "administrationList";
    }
}
