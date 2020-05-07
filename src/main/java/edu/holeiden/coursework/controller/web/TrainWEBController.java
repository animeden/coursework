package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.model.Train;
import edu.holeiden.coursework.service.train.impls.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/web/train")
public class TrainWEBController {
    @Autowired
    TrainServiceImpl service;

    @RequestMapping("/list")
    String getall(Model model){
        model.addAttribute("trains", service.getall());
        return "trainList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("trains", service.getall());
        return "trainList";
    }
}
