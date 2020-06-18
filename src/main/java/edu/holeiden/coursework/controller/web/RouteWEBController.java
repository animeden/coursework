package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.DepartmentForm;
import edu.holeiden.coursework.form.RouteForm;
import edu.holeiden.coursework.form.SearchForm;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.model.Department;
import edu.holeiden.coursework.model.Ready;
import edu.holeiden.coursework.model.Route;
import edu.holeiden.coursework.service.route.impls.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/web/route")
public class RouteWEBController {
    @Autowired
    RouteServiceImpl service;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("routes", service.getall());
        return "routeList";
    }

    @RequestMapping(value = "/get/list", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<Route> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("routes", list);
        return "routeList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("routes", service.getall());
        return "redirect:/web/route/get/list";
    }

    @RequestMapping("/create")
    String create(Model model){
        RouteForm routeForm = new RouteForm();
        model.addAttribute("routeForm", routeForm);
        return "routeAdd";
    }

    @PostMapping("/create")
    String create(Model model, @ModelAttribute("routeForm") RouteForm routeForm){
        Route route = new Route();

        route.setNumber(routeForm.getNumber());

            String number = routeForm.getNumber();
            Pattern pattern5 = Pattern.compile("^[1-9][0-9]{0,1}[0-9]{0,1}$");
            Matcher matcher5 = pattern5.matcher(number);

            if(!matcher5.matches()){
                return "redirect:/web/route/error6";
            }

        route.setStart(routeForm.getStart());

            String start = routeForm.getStart();
            Pattern pattern1 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$|^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s][A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}");
            Matcher matcher1 = pattern1.matcher(start);

            if(!matcher1.matches()){
                return "redirect:/web/route/error10";
            }

        route.setEnd(routeForm.getEnd());

            String end = routeForm.getEnd();
            Pattern pattern2 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$|^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s][A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}");
            Matcher matcher2 = pattern2.matcher(end);

            if(!matcher2.matches()){
                return "redirect:/web/route/error10";
            }

        route.setStations(routeForm.getStations());

            String stations = routeForm.getStations();
            Pattern pattern3 = Pattern.compile(".{10,120}");
            Matcher matcher3 = pattern3.matcher(stations);

            if(!matcher3.matches()){
                return "redirect:/web/department/error11";
            }

        route.setTypeOfRoute(routeForm.getTypeOfRoute());

        route.setDescriction(routeForm.getDescriction());

            String description = routeForm.getDescriction();
            Pattern pattern4 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher4 = pattern4.matcher(description);

            if(!matcher4.matches()){
                return "redirect:/web/route/error5";
            }

        service.save(route);
        model.addAttribute("routes", service.getall());
        return "redirect:/web/route/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Route route = service.get(id);
        RouteForm routeForm = new RouteForm();
        routeForm.setNumber(route.getNumber());
        routeForm.setStart(route.getStart());
        routeForm.setEnd(route.getEnd());
        routeForm.setStations(route.getStations());
        routeForm.setTypeOfRoute(route.getTypeOfRoute());
        routeForm.setDescriction(route.getDescriction());
        model.addAttribute("routeForm", routeForm);
        return "routeAdd";
    }

    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("routeForm") RouteForm routeForm){
        Route route = new Route();
        route.setId(id);

        route.setNumber(routeForm.getNumber());

            String number = routeForm.getNumber();
            Pattern pattern5 = Pattern.compile("^[1-9][0-9]{0,1}[0-9]{0,1}$");
            Matcher matcher5 = pattern5.matcher(number);

            if(!matcher5.matches()){
                return "redirect:/web/route/error6";
            }

        route.setStart(routeForm.getStart());

            String start = routeForm.getStart();
            Pattern pattern1 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$|^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s][A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}");
            Matcher matcher1 = pattern1.matcher(start);

            if(!matcher1.matches()){
                return "redirect:/web/route/error10";
            }

        route.setEnd(routeForm.getEnd());

            String end = routeForm.getEnd();
            Pattern pattern2 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$|^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s][A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}");
            Matcher matcher2 = pattern2.matcher(end);

            if(!matcher2.matches()){
                return "redirect:/web/route/error10";
            }

        route.setStations(routeForm.getStations());

            String stations = routeForm.getStations();
            Pattern pattern3 = Pattern.compile(".{10,120}");
            Matcher matcher3 = pattern3.matcher(stations);

            if(!matcher3.matches()){
                return "redirect:/web/department/error11";
            }

        route.setTypeOfRoute(routeForm.getTypeOfRoute());

        route.setDescriction(routeForm.getDescriction());

            String description = routeForm.getDescriction();
            Pattern pattern4 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher4 = pattern4.matcher(description);

            if(!matcher4.matches()){
                return "redirect:/web/route/error5";
            }

        service.save(route);
        model.addAttribute("routes", service.getall());
        return "redirect:/web/route/get/list";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Route> routes = service.getall();
        List<Route> sorted = service.sortByName(routes);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("routes", sorted);
        return "routeList";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Route> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("routes", list);
        return "routeList";
    }

    @PostMapping("/error5")
    public String errorfinder5(){
        return "error";
    }

    @PostMapping("/error10")
    public String errorfinder10(){
        return "error";
    }

    @PostMapping("/error11")
    public String errorfinder11(){
        return "error";
    }

    @PostMapping("/error6")
    public String errorfinder6(){
        return "error";
    }
}
