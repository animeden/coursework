package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.AdministrationForm;
import edu.holeiden.coursework.form.SearchForm;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.service.administration.impls.AdministrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/web/administration")
public class AdministrationWEBController {
    @Autowired
    AdministrationServiceImpl service;

    @RequestMapping("/get/list")
    public String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("administrations", service.getall());
        return "administrationList";
    }

    @PostMapping("/get/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<Administration> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("administrations", list);
        return "administrationList";
    }


    @RequestMapping("/delete/{id}")
    public String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("administrations", service.getall());
        return "redirect:/web/administration/get/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        AdministrationForm administrationForm = new AdministrationForm();
        model.addAttribute("administrationForm", administrationForm);
        return "administrationAdd";
    }

    @RequestMapping( value = "/create", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute("administrationForm") AdministrationForm administrationForm){
        Administration administration = new Administration();

        administration.setName(administrationForm.getName());

            String name = administrationForm.getName();
            Pattern pattern1 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,26}$|^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[-]{0,1}[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[-]{0,1}[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[-]{0,1}[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}$|^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{1,18}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,8}[']{0,1}[а-я]{0,8}[']{0,1}[a-zа-яіїєґ]{1,18}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{1,18}");
            Matcher matcher1 = pattern1.matcher(name);

            if(!matcher1.matches()){
                return "redirect:/web/administration/error1";
            }

        administration.setBirth(administrationForm.getBirth());

            String birth = administrationForm.getBirth();
            Pattern pattern2 = Pattern.compile("^[0-2][0-9][.][0][1-9][.][1][9][0-9][0-9]$|[3][0-1][.][0][1-9][.][1][9][0-9][0-9]$|[0-2][0-9][.][1][0-2][.][1][9][0-9][0-9]$|[3][0-1][.][1][0-2][.][1][9][0-9][0-9]$|[0-2][0-9][.][0][1-9][.][2][0][0-9][0-9]$|[3][0-1][.][0][1-9][.][2][0][0-9][0-9]$|[0-2][0-9][.][1][0-2][.][2][0][0-9][0-9]$|[3][0-1][.][1][0-2][.][2][0][0-9][0-9]$");
            Matcher matcher2 = pattern2.matcher(birth);

            if(!matcher2.matches()){
                return "redirect:/web/administration/error2";
            }

        administration.setPhoneNumber(administrationForm.getPhoneNumber());

            String number = administrationForm.getPhoneNumber();
            Pattern pattern3 = Pattern.compile("^[0][6][8][0-9]{7}$|^[0][3][9][0-9]{7}$|^[0][6][7][0-9]{7}$|^[0][9][6][0-9]{7}$|^[0][9][7][0-9]{7}$|^[0][9][8][0-9]{7}$|^[0][5][0][0-9]{7}$|^[0][6][6][0-9]{7}$|^[0][9][5][0-9]{7}$|^[0][9][9][0-9]{7}$|^[0][6][3][0-9]{7}$|^[0][9][3][0-9]{7}$|^[0][9][1][0-9]{7}$|^[0][9][2][0-9]{7}$|^[0][9][4][0-9]{7}$");
            Matcher matcher3 = pattern3.matcher(number);

            if(!matcher3.matches()){
                return "redirect:/web/administration/error3";
            }

        administration.setAdress(administrationForm.getAdress());

            String adress = administrationForm.getAdress();
            Pattern pattern4 = Pattern.compile(".{10,100}");
            Matcher matcher4 = pattern4.matcher(adress);

            if(!matcher4.matches()){
                return "redirect:/web/administration/error9";
            }

        administration.setDescriction(administrationForm.getDescriction());

            String description = administrationForm.getDescriction();
            Pattern pattern5 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher5 = pattern5.matcher(description);

            if(!matcher5.matches()){
                return "redirect:/web/administration/error5";
            }

        service.save(administration);
        model.addAttribute("administrations", service.getall());
        return "redirect:/web/administration/get/list";
    }

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

    @PostMapping("/edit/{id}")
    public String edith(Model model, @PathVariable("id") String id, @ModelAttribute("administrationForm") AdministrationForm administrationForm){
        Administration administration = new Administration();
        administration.setId(id);
        administration.setName(administrationForm.getName());

            String name = administrationForm.getName();
            Pattern pattern1 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,26}$|^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[-]{0,1}[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[-]{0,1}[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[-]{0,1}[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}$|^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{1,18}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,8}[']{0,1}[а-я]{0,8}[']{0,1}[a-zа-яіїєґ]{1,18}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{1,18}");
            Matcher matcher1 = pattern1.matcher(name);

            if(!matcher1.matches()){
                return "redirect:/web/administration/error1";
            }

        administration.setBirth(administrationForm.getBirth());

            String birth = administrationForm.getBirth();
            Pattern pattern2 = Pattern.compile("^[0-2][0-9][.][0][1-9][.][1][9][0-9][0-9]$|[3][0-1][.][0][1-9][.][1][9][0-9][0-9]$|[0-2][0-9][.][1][0-2][.][1][9][0-9][0-9]$|[3][0-1][.][1][0-2][.][1][9][0-9][0-9]$|[0-2][0-9][.][0][1-9][.][2][0][0-9][0-9]$|[3][0-1][.][0][1-9][.][2][0][0-9][0-9]$|[0-2][0-9][.][1][0-2][.][2][0][0-9][0-9]$|[3][0-1][.][1][0-2][.][2][0][0-9][0-9]$");
            Matcher matcher2 = pattern2.matcher(birth);

            if(!matcher2.matches()){
                return "redirect:/web/administration/error2";
            }

        administration.setPhoneNumber(administrationForm.getPhoneNumber());

            String number = administrationForm.getPhoneNumber();
            Pattern pattern3 = Pattern.compile("^[0][6][8][0-9]{7}$|^[0][3][9][0-9]{7}$|^[0][6][7][0-9]{7}$|^[0][9][6][0-9]{7}$|^[0][9][7][0-9]{7}$|^[0][9][8][0-9]{7}$|^[0][5][0][0-9]{7}$|^[0][6][6][0-9]{7}$|^[0][9][5][0-9]{7}$|^[0][9][9][0-9]{7}$|^[0][6][3][0-9]{7}$|^[0][9][3][0-9]{7}$|^[0][9][1][0-9]{7}$|^[0][9][2][0-9]{7}$|^[0][9][4][0-9]{7}$");
            Matcher matcher3 = pattern3.matcher(number);

            if(!matcher3.matches()){
                return "redirect:/web/administration/error3";
            }

        administration.setAdress(administrationForm.getAdress());

            String adress = administrationForm.getAdress();
            Pattern pattern4 = Pattern.compile(".{10,100}");
            Matcher matcher4 = pattern4.matcher(adress);

            if(!matcher4.matches()){
                return "redirect:/web/administration/error9";
            }

        administration.setDescriction(administrationForm.getDescriction());

            String description = administrationForm.getDescriction();
            Pattern pattern5 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher5 = pattern5.matcher(description);

            if(!matcher5.matches()){
                return "redirect:/web/administration/error5";
            }

        service.save(administration);
        model.addAttribute("administrations", service.getall());
        return "redirect:/web/administration/get/list";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Administration> administrations = service.getall();
        List<Administration> sorted = service.sortByName(administrations);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("administrations", sorted);
        return "administrationList";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Administration> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("administrations", list);
        return "administrationList";
    }

    @PostMapping("/error1")
    public String errorfinder1(){
        return "error";
    }

    @PostMapping("/error2")
    public String errorfinder2(){
        return "error";
    }

    @PostMapping("/error3")
    public String errorfinder3(){
        return "error";
    }

    @PostMapping("/error5")
    public String errorfinder5(){
        return "error";
    }

    @PostMapping("/error9")
    public String errorfinder9(){
        return "error";
    }
}
