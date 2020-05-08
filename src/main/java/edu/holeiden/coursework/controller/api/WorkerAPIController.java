package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Worker;
import edu.holeiden.coursework.service.worker.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/worker")
public class WorkerAPIController {
    @Autowired
    WorkerServiceImpl service;

    @RequestMapping("/get/list")
    List<Worker> getall(){
        return service.getall();
    }

    @RequestMapping("/get/{id}")
    Worker get(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping("/delete/{id}")
    Worker delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Worker create(@RequestBody Worker worker){
        return service.save(worker);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    Worker edit(@RequestBody Worker worker){
        return service.edit(worker);
    }
}
