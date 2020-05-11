package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.model.Passenger;
import edu.holeiden.coursework.service.passanger.impls.PassengerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/web/passenger")
public class PassengerWEBController {
    @Autowired
    PassengerServiceImpl service;

    @RequestMapping("/get/list")
    String getall(Model model){
        model.addAttribute("passengers", service.getall());
        return "passengerList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("passengers", service.getall());
        return "passengerList";
    }
}

