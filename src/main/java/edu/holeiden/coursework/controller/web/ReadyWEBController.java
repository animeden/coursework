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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

            String review = readyForm.getReview();
            Pattern pattern2 = Pattern.compile("^[+-]$");
            Matcher matcher2 = pattern2.matcher(review);

            if(!matcher2.matches()){
                return "redirect:/web/ready/error19";
            }

        ready.setClear(readyForm.getClear());

            String clear = readyForm.getClear();
            Pattern pattern3 = Pattern.compile("^[+-]$");
            Matcher matcher3 = pattern3.matcher(clear);

            if(!matcher3.matches()){
                return "redirect:/web/ready/error19";
            }

        ready.setFood(readyForm.getFood());

            String food = readyForm.getFood();
            Pattern pattern4 = Pattern.compile("^[+-]$");
            Matcher matcher4 = pattern4.matcher(food);

            if(!matcher4.matches()){
                return "redirect:/web/ready/error19";
            }

        ready.setDescriction(readyForm.getDescriction());

            String description = readyForm.getDescriction();
            Pattern pattern1 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher1 = pattern1.matcher(description);

            if(!matcher1.matches()){
                return "redirect:/web/ready/error1";
            }

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

            String review = readyForm.getReview();
            Pattern pattern2 = Pattern.compile("^[+-]$");
            Matcher matcher2 = pattern2.matcher(review);

            if(!matcher2.matches()){
                return "redirect:/web/ready/error19";
            }

        ready.setClear(readyForm.getClear());

            String clear = readyForm.getClear();
            Pattern pattern3 = Pattern.compile("^[+-]$");
            Matcher matcher3 = pattern3.matcher(clear);

            if(!matcher3.matches()){
                return "redirect:/web/ready/error19";
            }

        ready.setFood(readyForm.getFood());

            String food = readyForm.getFood();
            Pattern pattern4 = Pattern.compile("^[+-]$");
            Matcher matcher4 = pattern4.matcher(food);

            if(!matcher4.matches()){
                return "redirect:/web/ready/error19";
            }

        ready.setDescriction(readyForm.getDescriction());

            String description = readyForm.getDescriction();
            Pattern pattern1 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher1 = pattern1.matcher(description);

            if(!matcher1.matches()){
                return "redirect:/web/ready/error5";
            }

        service.save(ready);
        model.addAttribute("readies", service.getall());
        return "redirect:/web/ready/get/list";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Ready> readies = service.getall();
        List<Ready> sorted = service.sortByName(readies);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("readies", sorted);
        return "readyList";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Ready> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("readies", list);
        return "readyList";
    }

    @PostMapping("/error5")
    public String errorfinder5(){
        return "error";
    }
}
