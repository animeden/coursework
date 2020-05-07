package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.model.Ready;
import edu.holeiden.coursework.service.ready.impls.ReadyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/web/ready")
public class ReadyWEBController {
    @Autowired
    ReadyServiceImpl service;

    @RequestMapping("/list")
    String getall(Model model){
        model.addAttribute("readies", service.getall());
        return "readyList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("readies", service.getall());
        return "readyList";
    }
}
