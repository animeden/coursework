package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.RouteForm;
import edu.holeiden.coursework.form.SearchForm;
import edu.holeiden.coursework.form.TimetableForm;
import edu.holeiden.coursework.model.*;
import edu.holeiden.coursework.service.ready.impls.ReadyServiceImpl;
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
@RequestMapping("/web/timetable")
public class TimetableWEBController {
    @Autowired
    TimetableServiceImpl service;

    @Autowired
    ReadyServiceImpl readyService;

    @Autowired
    RouteServiceImpl routeService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("timetables", service.getall());
        return "timetableList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<Timetable> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("timetables", list);
        return "timetableList";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("timetables", service.getall());
        return "redirect:/web/timetable/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
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

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    String create(Model model, @ModelAttribute("timetableForm") TimetableForm timetableForm){
        Timetable timetable = new Timetable();
        Route route = routeService.get(timetableForm.getNumberOfRoute());

        timetable.setTimeOfGoing(timetableForm.getTimeOfGoing());

            String timeOfGoing = timetableForm.getTimeOfGoing();
            Pattern pattern1 = Pattern.compile("^[01][0-9][:][0-5][0-9]$|^[2][0-3][:][0-5][0-9]$");
            Matcher matcher1 = pattern1.matcher(timeOfGoing);

            if(!matcher1.matches()){
                return "redirect:/web/timetable/error13";
            }

        timetable.setDateOfGoing(timetableForm.getDateOfGoing());

            String going = timetableForm.getDateOfGoing();
            Pattern pattern5 = Pattern.compile("^[0-2][0-9][.][0][0-9]$|^[3][0-1][.][0][0-9]$|^[0-2][0-9][.][1][0-2]$|^[3][0-1][.][1][0-2]$");
            Matcher matcher5 = pattern5.matcher(going);

            if(!matcher5.matches()){
                return "redirect:/web/timetable/error2";
            }

        timetable.setTimeOfCome(timetableForm.getTimeOfCome());

            String timeOfCome = timetableForm.getTimeOfCome();
            Pattern pattern2 = Pattern.compile("^[01][0-9][:][0-5][0-9]$|^[2][0-3][:][0-5][0-9]$");
            Matcher matcher2 = pattern2.matcher(timeOfCome);

            if(!matcher2.matches()){
                return "redirect:/web/timetable/error13";
            }

        timetable.setDateOfCome(timetableForm.getDateOfCome());

            String coming = timetableForm.getDateOfCome();
            Pattern pattern7 = Pattern.compile("^[0-2][0-9][.][0][0-9]$|^[3][0-1][.][0][0-9]$|^[0-2][0-9][.][1][0-2]$|^[3][0-1][.][1][0-2]$");
            Matcher matcher7 = pattern7.matcher(coming);

            if(!matcher7.matches()){
                return "redirect:/web/timetable/error2";
            }

        timetable.setNumberOfRoute(route);

        timetable.setTicketPrice(timetableForm.getTicketPrice());

            String price = timetableForm.getTicketPrice();
            Pattern pattern3 = Pattern.compile("^[1-9][0-9]{0,2}[.][0-9]{0,2}$");
            Matcher matcher3 = pattern3.matcher(price);

            if(!matcher3.matches()){
                return "redirect:/web/timetable/error12";
            }

        timetable.setNumberOfPassager(timetableForm.getNumberOfPassager());

            String numberOfPassager = timetableForm.getNumberOfPassager();
            Pattern pattern4 = Pattern.compile("^[1-9][0-9]{0,2}$");
            Matcher matcher4 = pattern4.matcher(numberOfPassager);

            if(!matcher4.matches()){
                return "redirect:/web/timetable/error6";
            }

        timetable.setDescriction(timetableForm.getDescriction());

            String description = timetableForm.getDescriction();
            Pattern pattern6 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher6 = pattern6.matcher(description);

            if(!matcher6.matches()){
                return "redirect:/web/timetable/error5";
            }


        service.save(timetable);
        model.addAttribute("timetables", service.getall());
        return "redirect:/web/timetable/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Timetable timetable = service.get(id);
        TimetableForm timetableForm = new TimetableForm();
        Map<String, String> mavs = routeService.getall().stream()
                .collect(Collectors.toMap(Route::getId, Route::getStations));
        Map<String, String> mavss = readyService.getall().stream()
                .collect(Collectors.toMap(Ready::getId, Ready::getDescriction));
        timetableForm.setTimeOfGoing(timetable.getTimeOfGoing());
        timetableForm.setDateOfCome(timetable.getDateOfCome());
        timetableForm.setTimeOfCome(timetable.getTimeOfCome());
        timetableForm.setDateOfGoing(timetable.getDateOfGoing());
        timetableForm.setNumberOfRoute(timetable.getNumberOfRoute().getStations());
        timetableForm.setTicketPrice(timetable.getTicketPrice());
        timetableForm.setNumberOfPassager(timetable.getNumberOfPassager());
        timetableForm.setDescriction(timetable.getDescriction());
        model.addAttribute("mavs", mavs);
        model.addAttribute("mavss", mavss);
        model.addAttribute("timetableForm", timetableForm);
        return "timetableAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("timetableForm") TimetableForm timetableForm){
        Timetable timetable = new Timetable();
        timetable.setId(id);
        Route route = routeService.get(timetableForm.getNumberOfRoute());

        timetable.setTimeOfGoing(timetableForm.getTimeOfGoing());

            String timeOfGoing = timetableForm.getTimeOfGoing();
            Pattern pattern1 = Pattern.compile("^[01][0-9][:][0-5][0-9]$|^[2][0-3][:][0-5][0-9]$");
            Matcher matcher1 = pattern1.matcher(timeOfGoing);

            if(!matcher1.matches()){
                return "redirect:/web/timetable/error13";
            }

        timetable.setDateOfCome(timetableForm.getDateOfCome());

            String coming = timetableForm.getDateOfCome();
            Pattern pattern7 = Pattern.compile("^[0-2][0-9][.][0][0-9]$|^[3][0-1][.][0][0-9]$|^[0-2][0-9][.][1][0-2]$|^[3][0-1][.][1][0-2]$");
            Matcher matcher7 = pattern7.matcher(coming);

            if(!matcher7.matches()){
                return "redirect:/web/timetable/error2";
            }

        timetable.setTimeOfCome(timetableForm.getTimeOfCome());

            String timeOfCome = timetableForm.getTimeOfCome();
            Pattern pattern2 = Pattern.compile("^[01][0-9][:][0-5][0-9]$|^[2][0-3][:][0-5][0-9]$");
            Matcher matcher2 = pattern2.matcher(timeOfCome);

            if(!matcher2.matches()){
                return "redirect:/web/timetable/error13";
            }

        timetable.setDateOfGoing(timetableForm.getDateOfGoing());

            String going = timetableForm.getDateOfGoing();
            Pattern pattern5 = Pattern.compile("^[0-2][0-9][.][0][0-9]$|^[3][0-1][.][0][0-9]$|^[0-2][0-9][.][1][0-2]$|^[3][0-1][.][1][0-2]$");
            Matcher matcher5 = pattern5.matcher(going);

            if(!matcher5.matches()){
                return "redirect:/web/timetable/error2";
            }

        timetable.setNumberOfRoute(route);

        timetable.setTicketPrice(timetableForm.getTicketPrice());

            String price = timetableForm.getTicketPrice();
            Pattern pattern3 = Pattern.compile("^[1-9][0-9]{0,2}[.][0-9]{0,2}$");
            Matcher matcher3 = pattern3.matcher(price);

            if(!matcher3.matches()){
                return "redirect:/web/timetable/error12";
            }

        timetable.setNumberOfPassager(timetableForm.getNumberOfPassager());

            String numberOfPassager = timetableForm.getNumberOfPassager();
            Pattern pattern4 = Pattern.compile("^[1-9][0-9]{0,2}$");
            Matcher matcher4 = pattern4.matcher(numberOfPassager);

            if(!matcher4.matches()){
                return "redirect:/web/timetable/error6";
            }

        timetable.setDescriction(timetableForm.getDescriction());

            String description = timetableForm.getDescriction();
            Pattern pattern6 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher6 = pattern6.matcher(description);

            if(!matcher6.matches()){
                return "redirect:/web/timetable/error5";
            }

        service.save(timetable);
        model.addAttribute("timetables", service.getall());
        return "redirect:/web/timetable/get/list";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Timetable> timetables = service.getall();
        List<Timetable> sorted = service.sortByName(timetables);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("timetables", sorted);
        return "timetableList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Timetable> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("timetables", list);
        return "timetableList";
    }

    @PostMapping("/error6")
    public String errorfinder6(){
        return "error";
    }

    @PostMapping("/error5")
    public String errorfinder5(){
        return "error";
    }

    @PostMapping("/error12")
    public String errorfinder12(){
        return "error";
    }

    @PostMapping("/error13")
    public String errorfinder13(){
        return "error";
    }

    @PostMapping("/error16")
    public String errorfinder16(){
        return "error";
    }
}
