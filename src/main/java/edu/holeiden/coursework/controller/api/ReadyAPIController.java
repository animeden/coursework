package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Ready;
import edu.holeiden.coursework.service.ready.impls.ReadyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
