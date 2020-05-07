package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.model.Brigade;
import edu.holeiden.coursework.service.brigade.impls.BrigadeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/web/brigade")
public class BrigadeWEBController {
    @Autowired
    BrigadeServiceImpl service;

    @RequestMapping("/list")
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
}
