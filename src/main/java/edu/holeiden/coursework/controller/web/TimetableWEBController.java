package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.RouteForm;
import edu.holeiden.coursework.form.TimetableForm;
import edu.holeiden.coursework.model.Ready;
import edu.holeiden.coursework.model.Route;
import edu.holeiden.coursework.model.Timetable;
import edu.holeiden.coursework.model.Train;
import edu.holeiden.coursework.service.ready.impls.ReadyServiceImpl;
import edu.holeiden.coursework.service.route.impls.RouteServiceImpl;
import edu.holeiden.coursework.service.timetable.impls.TimetableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/timetable")
public class TimetableWEBController {
    @Autowired
    TimetableServiceImpl service;

    @Autowired
    ReadyServiceImpl readyService;

    @Autowired
    RouteServiceImpl routeService;

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
        return "redirect:/web/timetable/get/list";
    }

    @RequestMapping("/create")
    String create(Model model){
        TimetableForm timetableForm = new TimetableForm();
        Map<String, String> mavs = routeService.getall().stream()
                .collect(Collectors.toMap(Route::getId, Route::getStations));
        Map<String, String> mavss = readyService.getall().stream()
                .collect(Collectors.toMap(Ready::getId, Ready::getDescriction));
        model.addAttribute("mavs", mavs);
        model.addAttribute("mavss", mavss);
        model.addAttribute("timetableForm", timetableForm);
        return "timetableAdd";
    }

    @PostMapping("/create")
    String create(Model model, @ModelAttribute("timetableForm") TimetableForm timetableForm){
        Timetable timetable = new Timetable();
        Ready ready = readyService.get(timetableForm.getReadyID());
        Route route = routeService.get(timetableForm.getNumberOfRoute());
        timetable.setTimeOfGoing(timetableForm.getTimeOfGoing());
        timetable.setTimeOfCome(timetableForm.getTimeOfCome());
        timetable.setNumberOfRoute(route);
        timetable.setTicketPrice(timetableForm.getTicketPrice());
        timetable.setReadyID(ready);
        timetable.setNumberOfPassager(timetableForm.getNumberOfPassager());
        timetable.setFreeSpace(timetableForm.getFreeSpace());
        timetable.setDescriction(timetableForm.getDescriction());
        service.save(timetable);
        model.addAttribute("timetables", service.getall());
        return "redirect:/web/timetable/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Timetable timetable = service.get(id);
        TimetableForm timetableForm = new TimetableForm();
        Map<String, String> mavs = routeService.getall().stream()
                .collect(Collectors.toMap(Route::getId, Route::getStations));
        Map<String, String> mavss = readyService.getall().stream()
                .collect(Collectors.toMap(Ready::getId, Ready::getDescriction));
        timetableForm.setTimeOfGoing(timetable.getTimeOfGoing());
        timetableForm.setTimeOfCome(timetable.getTimeOfCome());
        timetableForm.setNumberOfRoute(timetable.getNumberOfRoute().getStations());
        timetableForm.setTicketPrice(timetable.getTicketPrice());
        timetableForm.setReadyID(timetable.getReadyID().getDescriction());
        timetableForm.setNumberOfPassager(timetable.getNumberOfPassager());
        timetableForm.setFreeSpace(timetable.getFreeSpace());
        timetableForm.setDescriction(timetable.getDescriction());
        model.addAttribute("mavs", mavs);
        model.addAttribute("mavss", mavss);
        model.addAttribute("timetableForm", timetableForm);
        return "timetableAdd";
    }

    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("timetableForm") TimetableForm timetableForm){
        Timetable timetable = new Timetable();
        timetable.setId(id);
        Ready ready = readyService.get(timetableForm.getReadyID());
        Route route = routeService.get(timetableForm.getNumberOfRoute());
        timetable.setTimeOfGoing(timetableForm.getTimeOfGoing());
        timetable.setTimeOfCome(timetableForm.getTimeOfCome());
        timetable.setNumberOfRoute(route);
        timetable.setTicketPrice(timetableForm.getTicketPrice());
        timetable.setReadyID(ready);
        timetable.setNumberOfPassager(timetableForm.getNumberOfPassager());
        timetable.setFreeSpace(timetableForm.getFreeSpace());
        timetable.setDescriction(timetableForm.getDescriction());
        service.save(timetable);
        model.addAttribute("timetables", service.getall());
        return "redirect:/web/timetable/get/list";
    }
}
