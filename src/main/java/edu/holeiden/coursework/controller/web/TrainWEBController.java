package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.AdministrationForm;
import edu.holeiden.coursework.form.SearchForm;
import edu.holeiden.coursework.form.TrainForm;
import edu.holeiden.coursework.model.*;
import edu.holeiden.coursework.service.brigade.impls.BrigadeServiceImpl;
import edu.holeiden.coursework.service.train.impls.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/train")
public class TrainWEBController {
    @Autowired
    TrainServiceImpl service;

    @Autowired
    BrigadeServiceImpl brigadeService;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("trains", service.getall());
        return "trainList";
    }

    @RequestMapping(value = "/get/list", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<Train> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("trains", list);
        return "trainList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("trains", service.getall());
        return "redirect:/web/train/get/list";
    }

    @RequestMapping("/create")
    String create(Model model){
        TrainForm trainForm = new TrainForm();
        Map<String, String> mavs = brigadeService.getall().stream()
                .collect(Collectors.toMap(Brigade::getId, Brigade::getMission));
        model.addAttribute("mavs", mavs);
        model.addAttribute("trainForm", trainForm);
        return "trainAdd";
    }

    @PostMapping("/create")
    String create(Model model, @ModelAttribute("trainForm") TrainForm trainForm){
        Train train = new Train();
        Brigade brigade = brigadeService.get(trainForm.getTrainBrigade());
        Brigade brigadee = brigadeService.get(trainForm.getRecoveryBrigade());
        train.setModel(trainForm.getModel());
        train.setTrainBrigade(brigade);
        train.setRecoveryBrigade(brigadee);
        train.setDescriction(trainForm.getDescriction());
        service.save(train);
        model.addAttribute("trains", service.getall());
        return "redirect:/web/train/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Train train = service.get(id);
        TrainForm trainForm = new TrainForm();
        Map<String, String> mavs = brigadeService.getall().stream()
                .collect(Collectors.toMap(Brigade::getId, Brigade::getMission));
        trainForm.setModel(train.getModel());
        trainForm.setTrainBrigade(train.getTrainBrigade().getMission());
        trainForm.setRecoveryBrigade(train.getRecoveryBrigade().getMission());
        trainForm.setDescriction(train.getDescriction());
        model.addAttribute("mavs", mavs);
        model.addAttribute("trainForm", trainForm);
        return "trainAdd";
    }

    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("trainForm") TrainForm trainForm){
        Train train = new Train();
        Brigade brigade = brigadeService.get(trainForm.getTrainBrigade());
        Brigade brigadee = brigadeService.get(trainForm.getRecoveryBrigade());
        train.setId(id);
        train.setModel(trainForm.getModel());
        train.setTrainBrigade(brigade);
        train.setRecoveryBrigade(brigadee);
        train.setDescriction(trainForm.getDescriction());
        service.save(train);
        model.addAttribute("trains", service.getall());
        return "redirect:/web/train/get/list";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Train> trains = service.getall();
        List<Train> sorted = service.sortByName(trains);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("trains", sorted);
        return "trainList";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Train> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("trains", list);
        return "trainList";
    }
}
