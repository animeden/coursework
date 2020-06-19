package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.PassengerForm;
import edu.holeiden.coursework.form.SearchForm;
import edu.holeiden.coursework.model.*;
import edu.holeiden.coursework.service.passanger.impls.PassengerServiceImpl;
import edu.holeiden.coursework.service.route.impls.RouteServiceImpl;
import edu.holeiden.coursework.service.timetable.impls.TimetableServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/passenger")
public class PassengerWEBController {
    @Autowired
    PassengerServiceImpl service;

    @Autowired
    TimetableServiceImpl timetableService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("passengers", service.getall());
        return "passengerList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<Passenger> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("passengers", list);
        return "passengerList";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("passengers", service.getall());
        return "redirect:/web/passenger/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/create")
    String create(Model model){
        PassengerForm passengerForm = new PassengerForm();
        Map<String, String> mavs = timetableService.getall().stream()
                .collect(Collectors.toMap(Timetable::getId, Timetable::getTimeOfGoing));
        model.addAttribute("mavs", mavs);
        model.addAttribute("passengerForm", passengerForm);
        return "passengerAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    String create(Model model, @ModelAttribute("passengerForm") PassengerForm passengerForm){
        Passenger passenger = new Passenger();
        Timetable timetable = timetableService.get(passengerForm.getTimetableID());

        passenger.setTicketStatus(passengerForm.getStatus());

            String  ticketStatus = passengerForm.getStatus();
            Pattern pattern2 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher2 = pattern2.matcher((ticketStatus));

            if(!matcher2.matches()){
                return "redirect:/web/passenger/error18";
            }

        passenger.setTimetableID(timetable);

        passenger.setBaggageStatus(passengerForm.getBaggageStatus());

            String  baggageStatus = passengerForm.getBaggageStatus();
            Pattern pattern3 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher3 = pattern3.matcher((baggageStatus));

            if(!matcher3.matches()){
                return "redirect:/web/passenger/error18";
            }

        passenger.setDescriction(passengerForm.getDescriction());

            String description = passengerForm.getDescriction();
            Pattern pattern1 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher1 = pattern1.matcher(description);

            if(!matcher1.matches()){
                return "redirect:/web/passenger/error5";
            }

        service.save(passenger);
        model.addAttribute("passengers", service.getall());
        return "redirect:/web/passenger/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Passenger passenger = service.get(id);
        PassengerForm passengerForm = new PassengerForm();
        Map<String, String> mavs = timetableService.getall().stream()
                .collect(Collectors.toMap(Timetable::getId, Timetable::getTimeOfGoing));
        passengerForm.setStatus(passenger.getTicketStatus());
        passengerForm.setTimetableID(passenger.getTimetableID().getTimeOfGoing());
        passengerForm.setBaggageStatus(passenger.getBaggageStatus());
        passengerForm.setDescriction(passenger.getDescriction());
        model.addAttribute("mavs", mavs);
        model.addAttribute("passengerForm", passengerForm);
        return "passengerAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("passengerForm") PassengerForm passengerForm){
        Passenger passenger = new Passenger();
        Timetable timetable = timetableService.get(passengerForm.getTimetableID());
        passenger.setId(id);

        passenger.setTicketStatus(passengerForm.getStatus());

            String  ticketStatus = passengerForm.getStatus();
            Pattern pattern2 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher2 = pattern2.matcher((ticketStatus));

            if(!matcher2.matches()){
                return "redirect:/web/passenger/error18";
            }

        passenger.setTimetableID(timetable);

        passenger.setBaggageStatus(passengerForm.getBaggageStatus());

            String  baggageStatus = passengerForm.getBaggageStatus();
            Pattern pattern3 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher3 = pattern3.matcher((baggageStatus));

            if(!matcher3.matches()){
                return "redirect:/web/passenger/error18";
            }

        passenger.setDescriction(passengerForm.getDescriction());

            String description = passengerForm.getDescriction();
            Pattern pattern1 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher1 = pattern1.matcher(description);

            if(!matcher1.matches()){
                return "redirect:/web/passenger/error5";
            }

        service.save(passenger);
        model.addAttribute("passengers", service.getall());
        return "redirect:/web/passenger/get/list";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Passenger> passengers = service.getall();
        List<Passenger> sorted = service.sortByName(passengers);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("passengers", sorted);
        return "passengerList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Passenger> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("passengers", list);
        return "passengerList";
    }

    @PostMapping("/error5")
    public String errorfinder5(){
        return "error";
    }

    @PostMapping("/error18")
    public String errorfinder18(){
        return "error";
    }
}

