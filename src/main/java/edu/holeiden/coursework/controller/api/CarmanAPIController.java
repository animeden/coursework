package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Carman;
import edu.holeiden.coursework.service.carman.impls.CarmanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carman")
public class CarmanAPIController {
    @Autowired
    CarmanServiceImpl service;

    @RequestMapping("/get/list")
    List<Carman> getall(){
        return service.getall();
    }

    @RequestMapping("/get/{id}")
    Carman get(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping("/delete/{id}")
    Carman delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Carman create(@RequestBody Carman carman){
        return service.save(carman);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    Carman edit(@RequestBody Carman carman){
        return service.edit(carman);
    }
}
