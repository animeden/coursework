package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.model.Worker;
import edu.holeiden.coursework.service.worker.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/web/worker")
public class WorkerWEBController {
    @Autowired
    WorkerServiceImpl service;

    @RequestMapping("/list")
    String getall(Model model){
        model.addAttribute("workers", service.getall());
        return "workerList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("workers", service.getall());
        return "workerList";
    }
}
