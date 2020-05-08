package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Route;
import edu.holeiden.coursework.service.route.impls.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/route")
public class RouteAPIController {
    @Autowired
    RouteServiceImpl service;

    @RequestMapping("/get/list")
    List<Route> getall(){
        return service.getall();
    }

    @RequestMapping("/get/{id}")
    Route get(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping("/delete/{id}")
    Route delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Route create(@RequestBody Route route){
        return service.save(route);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    Route edit(@RequestBody Route route){
        return service.edit(route);
    }
}
