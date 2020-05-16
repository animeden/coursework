package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.DepartmentForm;
import edu.holeiden.coursework.form.ReadyForm;
import edu.holeiden.coursework.form.SearchForm;
import edu.holeiden.coursework.model.*;
import edu.holeiden.coursework.service.ready.impls.ReadyServiceImpl;
import edu.holeiden.coursework.service.train.impls.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/ready")
public class ReadyWEBController {
    @Autowired
    ReadyServiceImpl service;

    @Autowired
    TrainServiceImpl trainService;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("readies", service.getall());
        return "readyList";
    }

    @RequestMapping(value = "/get/list", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<Ready> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("readies", list);
        return "readyList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("readies", service.getall());
        return "redirect:/web/ready/get/list";
    }

    @RequestMapping("/create")
    String create(Model model){
        ReadyForm readyForm = new ReadyForm();
        Map<String, String> mavs = trainService.getall().stream()
                .collect(Collectors.toMap(Train::getId, Train::getModel));
        model.addAttribute("mavs", mavs);
        model.addAttribute("readyForm", readyForm);
        return "readyAdd";
    }

    @PostMapping("/create")
    String create(Model model, @ModelAttribute("readyForm") ReadyForm readyForm){
        Ready ready = new Ready();
        Train train = trainService.get(readyForm.getTrainID());
        ready.setTrainID(train);
        ready.setReview(readyForm.getReview());
        ready.setClear(readyForm.getClear());
        ready.setFood(readyForm.getFood());
        ready.setDescriction(readyForm.getDescriction());
        service.save(ready);
        model.addAttribute("readies", service.getall());
        return "redirect:/web/ready/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Ready ready = service.get(id);
        ReadyForm readyForm = new ReadyForm();
        Map<String, String> mavs = trainService.getall().stream()
                .collect(Collectors.toMap(Train::getId, Train::getModel));
        readyForm.setTrainID(ready.getTrainID().getModel());
        readyForm.setReview(ready.getReview());
        readyForm.setClear(ready.getClear());
        readyForm.setFood(ready.getFood());
        readyForm.setDescriction(ready.getDescriction());
        model.addAttribute("mavs", mavs);
        model.addAttribute("readyForm", readyForm);
        return "readyAdd";
    }

    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("readyForm") ReadyForm readyForm){
        Ready ready = new Ready();
        Train train = trainService.get(readyForm.getTrainID());
        ready.setId(id);
        ready.setTrainID(train);
        ready.setReview(readyForm.getReview());
        ready.setClear(readyForm.getClear());
        ready.setFood(readyForm.getFood());
        ready.setDescriction(readyForm.getDescriction());
        service.save(ready);
        model.addAttribute("readies", service.getall());
        return "redirect:/web/ready/get/list";
    }
}
