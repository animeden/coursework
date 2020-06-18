package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Station;
import edu.holeiden.coursework.service.station.impls.StationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/station")
public class StationAPIController {
    @Autowired
    StationServiceImpl service;

    @RequestMapping("/get/list")
    List<Station> getall(){
        return service.getall();
    }

    @RequestMapping("/get/{id}")
    Station get(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping("/delete/{id}")
    Station delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Station create(@RequestBody Station station){
        return service.save(station);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    Station edit(@RequestBody Station station){
        return service.edit(station);
    }
}
