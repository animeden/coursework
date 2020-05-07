package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Passenger;
import edu.holeiden.coursework.service.passanger.impls.PassengerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/passenger")
public class PassengerAPIController {
    @Autowired
    PassengerServiceImpl service;

    @RequestMapping("/list")
    List<Passenger> getall() {
        return service.getall();
    }
}
