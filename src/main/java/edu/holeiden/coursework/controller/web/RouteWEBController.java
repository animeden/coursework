package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.model.Route;
import edu.holeiden.coursework.service.route.impls.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/web/route")
public class RouteWEBController {
    @Autowired
    RouteServiceImpl service;

    @RequestMapping("/get/list")
    String getall(Model model){
        model.addAttribute("routes", service.getall());
        return "routeList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("routes", service.getall());
        return "routeList";
    }
}
