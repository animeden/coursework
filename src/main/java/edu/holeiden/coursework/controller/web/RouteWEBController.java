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
        route.setStart(routeForm.getStart());
        route.setEnd(routeForm.getEnd());
        route.setStations(routeForm.getStations());
        route.setTypeOfRoute(routeForm.getTypeOfRoute());
        route.setDescriction(routeForm.getDescriction());
        service.save(route);
        model.addAttribute("routes", service.getall());
        return "redirect:/web/route/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Route route = service.get(id);
        RouteForm routeForm = new RouteForm();
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
        route.setStart(routeForm.getStart());
        route.setEnd(routeForm.getEnd());
        route.setStations(routeForm.getStations());
        route.setTypeOfRoute(routeForm.getTypeOfRoute());
        route.setDescriction(routeForm.getDescriction());
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
}
