package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.DepartmentForm;
import edu.holeiden.coursework.form.PassengerForm;
import edu.holeiden.coursework.form.SearchForm;
import edu.holeiden.coursework.model.*;
import edu.holeiden.coursework.service.passanger.impls.PassengerServiceImpl;
import edu.holeiden.coursework.service.route.impls.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/passenger")
public class PassengerWEBController {
    @Autowired
    PassengerServiceImpl service;

    @Autowired
    RouteServiceImpl routeService;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("passengers", service.getall());
        return "passengerList";
    }

    @RequestMapping(value = "/get/list", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<Passenger> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("passengers", list);
        return "passengerList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("passengers", service.getall());
        return "redirect:/web/passenger/get/list";
    }

    @RequestMapping("/create")
    String create(Model model){
        PassengerForm passengerForm = new PassengerForm();
        Map<String, String> mavs = routeService.getall().stream()
                .collect(Collectors.toMap(Route::getId, Route::getStations));
        model.addAttribute("mavs", mavs);
        model.addAttribute("passengerForm", passengerForm);
        return "passengerAdd";
    }

    @PostMapping("/create")
    String create(Model model, @ModelAttribute("passengerForm") PassengerForm passengerForm){
        Passenger passenger = new Passenger();
        Route route = routeService.get(passengerForm.getRouteID());
        passenger.setStatus(passengerForm.getStatus());
        passenger.setRouteID(route);
        passenger.setDescriction(passengerForm.getDescriction());
        service.save(passenger);
        model.addAttribute("passengers", service.getall());
        return "redirect:/web/passenger/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Passenger passenger = service.get(id);
        PassengerForm passengerForm = new PassengerForm();
        Map<String, String> mavs = routeService.getall().stream()
                .collect(Collectors.toMap(Route::getId, Route::getStations));
        passengerForm.setStatus(passenger.getStatus());
        passengerForm.setRouteID(passenger.getRouteID().getStations());
        passengerForm.setDescriction(passenger.getDescriction());
        model.addAttribute("mavs", mavs);
        model.addAttribute("passengerForm", passengerForm);
        return "passengerAdd";
    }

    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("passengerForm") PassengerForm passengerForm){
        Passenger passenger = new Passenger();
        Route route = routeService.get(passengerForm.getRouteID());
        passenger.setId(id);
        passenger.setStatus(passengerForm.getStatus());
        passenger.setRouteID(route);
        passenger.setDescriction(passengerForm.getDescriction());
        service.save(passenger);
        model.addAttribute("passengers", service.getall());
        return "redirect:/web/passenger/get/list";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Passenger> passengers = service.getall();
        List<Passenger> sorted = service.sortByName(passengers);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("passengers", sorted);
        return "passengerList";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Passenger> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("passengers", list);
        return "passengerList";
    }
}

