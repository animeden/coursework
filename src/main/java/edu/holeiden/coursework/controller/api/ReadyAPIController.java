package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.model.Ready;
import edu.holeiden.coursework.service.ready.impls.ReadyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ready")
public class ReadyAPIController {
    @Autowired
    ReadyServiceImpl service;

    @RequestMapping("/get/list")
    List<Ready> getall(){
        return service.getall();
    }

    @RequestMapping("/get/{id}")
    Ready get(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping("/delete/{id}")
    Ready delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Ready create(@RequestBody Ready ready){
        return service.save(ready);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    Ready edit(@RequestBody Ready ready){
        return service.edit(ready);
    }
}
