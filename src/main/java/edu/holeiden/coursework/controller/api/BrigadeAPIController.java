package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Brigade;
import edu.holeiden.coursework.service.brigade.impls.BrigadeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/brigade")
public class BrigadeAPIController {
    @Autowired
    BrigadeServiceImpl service;

    @RequestMapping("/list")
    List<Brigade> getall(){
        return service.getall();
    }
}
