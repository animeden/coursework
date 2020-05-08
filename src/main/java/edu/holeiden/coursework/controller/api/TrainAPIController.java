package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.model.Train;
import edu.holeiden.coursework.service.train.impls.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/train")
public class TrainAPIController {
    @Autowired
    TrainServiceImpl service;

    @RequestMapping("/get/list")
    List<Train> getall(){
        return service.getall();
    }

    @RequestMapping("/get/{id}")
    Train get(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping("/delete/{id}")
    Train delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Train create(@RequestBody Train train){
        return service.save(train);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    Train edit(@RequestBody Train train){
        return service.edit(train);
    }
}
