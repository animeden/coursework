package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Route;
import edu.holeiden.coursework.service.route.impls.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/route")
public class RouteAPIController {
    @Autowired
    RouteServiceImpl service;

    @RequestMapping("/list")
    List<Route> getall(){
        return service.getall();
    }
}
