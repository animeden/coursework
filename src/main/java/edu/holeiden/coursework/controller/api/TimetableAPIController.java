package edu.holeiden.coursework.controller.api;

import edu.holeiden.coursework.model.Timetable;
import edu.holeiden.coursework.service.timetable.impls.TimetableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
