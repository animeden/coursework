package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Passenger;
import edu.holeiden.coursework.service.passanger.impls.PassengerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passenger")
public class PassengerAPIController {
    @Autowired
    PassengerServiceImpl service;

    @RequestMapping("/get/list")
    List<Passenger> getall() {
        return service.getall();
    }

    @RequestMapping("/get/{id}")
    Passenger get(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping("/delete/{id}")
    Passenger delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Passenger create(@RequestBody Passenger passenger){
        return service.save(passenger);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    Passenger edit(@RequestBody Passenger passenger){
        return service.edit(passenger);
    }
}
