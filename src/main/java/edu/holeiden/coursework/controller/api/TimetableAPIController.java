package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Timetable;
import edu.holeiden.coursework.service.timetable.impls.TimetableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timetable")
public class TimetableAPIController {
    @Autowired
    TimetableServiceImpl service;

    @RequestMapping("/get/list")
    List<Timetable> getall(){
        return service.getall();
    }

    @RequestMapping("/get/{id}")
    Timetable get(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping("/delete/{id}")
    Timetable delete(@PathVariable("id") String id){
        return service.delete(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Timetable create(@RequestBody Timetable timetable){
        return service.save(timetable);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PATCH)
    Timetable edit(@RequestBody Timetable timetable){
        return service.edit(timetable);
    }
}
