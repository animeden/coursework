package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Train;
import edu.holeiden.coursework.service.train.impls.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/train")
public class TrainAPIController {
    @Autowired
    TrainServiceImpl service;

    @RequestMapping("/list")
    List<Train> getall(){
        return service.getall();
    }
}
