package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.AdministrationForm;
import edu.holeiden.coursework.form.BrigadeForm;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.model.Brigade;
import edu.holeiden.coursework.service.brigade.impls.BrigadeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/brigade")
public class BrigadeWEBController {
    @Autowired
    BrigadeServiceImpl service;

    @RequestMapping("/get/list")
    String getall(Model model){
        model.addAttribute("brigades", service.getall());
        return "brigadeList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("brigades", service.getall());
        return "brigadeList";
    }

    @RequestMapping("/create")
    String create(Model model){
        BrigadeForm brigadeForm = new BrigadeForm();
        model.addAttribute("brigadeForm", brigadeForm);
        return "brigadeAdd";
    }

    @PostMapping("/create")
    String create(Model model, @ModelAttribute("brigadeForm") BrigadeForm brigadeForm){
        Brigade brigade = new Brigade();
        brigade.setMission(brigadeForm.getMission());
        brigade.setNumberOfWorkers(brigadeForm.getNumberOfWorkers());
        brigade.setDepartmentId(brigadeForm.getDepartmentId());
        brigade.setDescriction(brigadeForm.getDescriction());
        service.save(brigade);
        model.addAttribute("brigades", service.getall());
        return "redirect:/web/brigade/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Brigade brigade = service.get(id);
        BrigadeForm brigadeForm = new BrigadeForm();
        brigadeForm.setMission(brigade.getMission());
        brigadeForm.setNumberOfWorkers(brigade.getNumberOfWorkers());
        brigadeForm.setDepartmentId(brigade.getDepartmentId());
        brigadeForm.setDescriction(brigade.getDescriction());
        model.addAttribute("brigadeForm", brigadeForm);
        return "brigadeAdd";
    }

    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("brigadeForm") BrigadeForm brigadeForm){
        Brigade brigade = new Brigade();
        brigade.setId(id);
        brigade.setMission(brigadeForm.getMission());
        brigade.setNumberOfWorkers(brigadeForm.getNumberOfWorkers());
        brigade.setDepartmentId(brigadeForm.getDepartmentId());
        brigade.setDescriction(brigadeForm.getDescriction());
        service.save(brigade);
        model.addAttribute("brigades", service.getall());
        return "redirect:/web/brigade/get/list";
    }
}
