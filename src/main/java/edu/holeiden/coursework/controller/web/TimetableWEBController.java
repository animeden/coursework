package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.model.Timetable;
import edu.holeiden.coursework.service.timetable.impls.TimetableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/web/timetable")
public class TimetableWEBController {
    @Autowired
    TimetableServiceImpl service;

    @RequestMapping("/get/list")
    String getall(Model model){
        model.addAttribute("timetables", service.getall());
        return "timetableList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("timetables", service.getall());
        return "timetableList";
    }
}
