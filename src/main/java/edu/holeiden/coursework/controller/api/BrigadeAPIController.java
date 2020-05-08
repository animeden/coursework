package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.model.Brigade;
import edu.holeiden.coursework.service.brigade.impls.BrigadeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brigade")
public class BrigadeAPIController {
    @Autowired
    BrigadeServiceImpl service;

    @RequestMapping("/get/list")
    List<Brigade> getall(){
        return service.getall();
    }

    @RequestMapping("/get/{id}")
    Brigade get(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping("/delete/{id}")
    Brigade delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Brigade create(@RequestBody Brigade brigade){
        return service.save(brigade);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    Brigade edit(@RequestBody Brigade brigade){
        return service.edit(brigade);
    }
}
