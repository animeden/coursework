package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.AdministrationForm;
import edu.holeiden.coursework.form.SearchForm;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.service.administration.impls.AdministrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/administration")
public class AdministrationWEBController {
    @Autowired
    AdministrationServiceImpl service;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    public String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("administrations", service.getall());
        return "administrationList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<Administration> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("administrations", list);
        return "administrationList";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    public String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("administrations", service.getall());
        return "redirect:/web/administration/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/create")
    public String create(Model model){
        AdministrationForm administrationForm = new AdministrationForm();
        model.addAttribute("administrationForm", administrationForm);
        return "administrationAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public String create(Model model, @ModelAttribute("administrationForm") AdministrationForm administrationForm){
        Administration administration = new Administration();
        administration.setName(administrationForm.getName());
        administration.setBirth(administrationForm.getBirth());
        administration.setPhoneNumber(administrationForm.getPhoneNumber());
        administration.setAdress(administrationForm.getAdress());
        administration.setDescriction(administrationForm.getDescriction());
        service.save(administration);
        model.addAttribute("administrations", service.getall());
        return "redirect:/web/administration/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String id){
        Administration administration = service.get(id);
        AdministrationForm administrationForm = new AdministrationForm();
        administrationForm.setName(administration.getName());
        administrationForm.setBirth(administration.getBirth());
        administrationForm.setPhoneNumber(administration.getPhoneNumber());
        administrationForm.setAdress(administration.getAdress());
        administrationForm.setDescriction(administration.getDescriction());
        model.addAttribute("administrationForm", administrationForm);
        return "administrationAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit/{id}")
    public String edith(Model model, @PathVariable("id") String id, @ModelAttribute("administrationForm") AdministrationForm administrationForm){
        Administration administration = new Administration();
        administration.setId(id);
        administration.setName(administrationForm.getName());
        administration.setBirth(administrationForm.getBirth());
        administration.setPhoneNumber(administrationForm.getPhoneNumber());
        administration.setAdress(administrationForm.getAdress());
        administration.setDescriction(administrationForm.getDescriction());
        service.save(administration);
        model.addAttribute("administrations", service.getall());
        return "redirect:/web/administration/get/list";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Administration> administrations = service.getall();
        List<Administration> sorted = service.sortByName(administrations);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("administrations", sorted);
        return "administrationList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Administration> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("administrations", list);
        return "administrationList";
    }
}
