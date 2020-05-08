package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Worker;
import edu.holeiden.coursework.service.worker.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
