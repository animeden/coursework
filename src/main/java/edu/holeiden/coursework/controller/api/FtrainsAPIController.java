package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Ftrains;
import edu.holeiden.coursework.service.ftarin.impls.FtrainsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ftrain")
public class FtrainsAPIController {

    @Autowired
    FtrainsServiceImpl service;

    @RequestMapping("/get/list")
    List<Ftrains> getall(){
        return service.getall();
    }

    @RequestMapping("/get/{id}")
    Ftrains get(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping("/delete/{id}")
    Ftrains delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Ftrains create(@RequestBody Ftrains ftrains){
        return service.save(ftrains);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    Ftrains edit(@RequestBody Ftrains ftrains){
        return service.edit(ftrains);
    }
}
