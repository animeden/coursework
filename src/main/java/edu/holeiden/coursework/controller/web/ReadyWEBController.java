package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.DepartmentForm;
import edu.holeiden.coursework.form.ReadyForm;
import edu.holeiden.coursework.model.Department;
import edu.holeiden.coursework.model.Ready;
import edu.holeiden.coursework.service.ready.impls.ReadyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/ready")
public class ReadyWEBController {
    @Autowired
    ReadyServiceImpl service;

    @RequestMapping("/get/list")
    String getall(Model model){
        model.addAttribute("readies", service.getall());
        return "readyList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("readies", service.getall());
        return "redirect:/web/ready/get/list";
    }

    @RequestMapping("/create")
    String create(Model model){
        ReadyForm readyForm = new ReadyForm();
        model.addAttribute("readyForm", readyForm);
        return "readyAdd";
    }

    @PostMapping("/create")
    String create(Model model, @ModelAttribute("readyForm") ReadyForm readyForm){
        Ready ready = new Ready();
        ready.setTrainID(readyForm.getTrainID());
        ready.setReview(readyForm.getReview());
        ready.setClear(readyForm.getClear());
        ready.setFood(readyForm.getFood());
        ready.setDescriction(readyForm.getDescriction());
        service.save(ready);
        model.addAttribute("readies", service.getall());
        return "redirect:/web/ready/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Ready ready = service.get(id);
        ReadyForm readyForm = new ReadyForm();
        readyForm.setTrainID(ready.getTrainID());
        readyForm.setReview(ready.getReview());
        readyForm.setClear(ready.getClear());
        readyForm.setFood(ready.getFood());
        readyForm.setDescriction(ready.getDescriction());
        model.addAttribute("readyForm", readyForm);
        return "readyAdd";
    }

    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("readyForm") ReadyForm readyForm){
        Ready ready = new Ready();
        ready.setId(id);
        ready.setTrainID(readyForm.getTrainID());
        ready.setReview(readyForm.getReview());
        ready.setClear(readyForm.getClear());
        ready.setFood(readyForm.getFood());
        ready.setDescriction(readyForm.getDescriction());
        service.save(ready);
        model.addAttribute("readies", service.getall());
        return "redirect:/web/ready/get/list";
    }
}
