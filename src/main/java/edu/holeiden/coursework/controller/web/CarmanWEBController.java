package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.CarmanForm;
import edu.holeiden.coursework.form.SearchForm;
import edu.holeiden.coursework.form.WorkerForm;
import edu.holeiden.coursework.model.Brigade;
import edu.holeiden.coursework.model.Carman;
import edu.holeiden.coursework.model.Worker;
import edu.holeiden.coursework.service.brigade.impls.BrigadeServiceImpl;
import edu.holeiden.coursework.service.carman.impls.CarmanServiceImpl;
import edu.holeiden.coursework.service.worker.impls.WorkerServiceImpl;
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
@RequestMapping("/web/carman")
public class CarmanWEBController {
    @Autowired
    CarmanServiceImpl service;

    @Autowired
    BrigadeServiceImpl brigadeService;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("carmans", service.getall());
        return "carmanList";
    }

    @RequestMapping(value = "/get/list", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<Carman> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("carmans", list);
        return "carmanList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("carmans", service.getall());
        return "redirect:/web/carman/get/list";
    }

    @RequestMapping("/create")
    String create(Model model){
        CarmanForm carmanForm = new CarmanForm();
        Map<String, String> mavs = brigadeService.getall().stream()
                .collect(Collectors.toMap(Brigade::getId, Brigade::getMission));
        model.addAttribute("mavs", mavs);
        model.addAttribute("carmanForm", carmanForm);
        return "carmanAdd";
    }

    @PostMapping("/create")
    String create(Model model, @ModelAttribute("carmanForm") CarmanForm carmanForm){
        Carman carman = new Carman();
        Brigade brigade = brigadeService.get(carmanForm.getBrigateID());
        carman.setFullName(carmanForm.getFullName());

            String name = carmanForm.getFullName();
            Pattern pattern1 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,26}$|^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[-]{0,1}[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[-]{0,1}[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[-]{0,1}[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}$|^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{1,18}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,8}[']{0,1}[а-я]{0,8}[']{0,1}[a-zа-яіїєґ]{1,18}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{1,18}");
            Matcher matcher1 = pattern1.matcher(name);

            if(!matcher1.matches()){
                return "redirect:/web/carman/error1";
            }

        carman.setPhone(carmanForm.getPhone());

            String number = carmanForm.getPhone();
            Pattern pattern2 = Pattern.compile("^[0][6][8][0-9]{7}$|^[0][3][9][0-9]{7}$|^[0][6][7][0-9]{7}$|^[0][9][6][0-9]{7}$|^[0][9][7][0-9]{7}$|^[0][9][8][0-9]{7}$|^[0][5][0][0-9]{7}$|^[0][6][6][0-9]{7}$|^[0][9][5][0-9]{7}$|^[0][9][9][0-9]{7}$|^[0][6][3][0-9]{7}$|^[0][9][3][0-9]{7}$|^[0][9][1][0-9]{7}$|^[0][9][2][0-9]{7}$|^[0][9][4][0-9]{7}$");
            Matcher matcher2 = pattern2.matcher(number);

            if(!matcher2.matches()){
                return "redirect:/web/carman/error3";
            }

        carman.setAdress(carmanForm.getAdress());

            String adress = carmanForm.getAdress();
            Pattern pattern3 = Pattern.compile(".{10,100}");
            Matcher matcher3 = pattern3.matcher(adress);

            if(!matcher3.matches()){
                return "redirect:/web/carman/error9";
            }

        carman.setBirth(carmanForm.getBirth());

            String birth = carmanForm.getBirth();
            Pattern pattern4 = Pattern.compile("^[0-2][0-9][.][0][1-9][.][1][9][0-9][0-9]$|[3][0-1][.][0][1-9][.][1][9][0-9][0-9]$|[0-2][0-9][.][1][0-2][.][1][9][0-9][0-9]$|[3][0-1][.][1][0-2][.][1][9][0-9][0-9]$|[0-2][0-9][.][0][1-9][.][2][0][0-9][0-9]$|[3][0-1][.][0][1-9][.][2][0][0-9][0-9]$|[0-2][0-9][.][1][0-2][.][2][0][0-9][0-9]$|[3][0-1][.][1][0-2][.][2][0][0-9][0-9]$");
            Matcher matcher4 = pattern4.matcher(birth);

            if(!matcher4.matches()){
                return "redirect:/web/carman/error2";
            }

        carman.setSubclass(carmanForm.getSubclass());

            String subclass = carmanForm.getSubclass();
            Pattern pattern5 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher5 = pattern5.matcher(subclass);

            if(!matcher5.matches()){
                return "redirect:/web/carman/error15";
            }

        carman.setBrigateID(brigade);

        carman.setDriveExperience(carmanForm.getDriveExperience());

            String experience = carmanForm.getDriveExperience();
            Pattern pattern7 = Pattern.compile("^[0-9][0-9]{0,1}$");
            Matcher matcher7 = pattern7.matcher(experience);

            if(!matcher7.matches()){
                return "redirect:/web/carman/error8";
            }

        carman.setTypeOfTrains(carmanForm.getTypeOfTrains());

            String typeOfTrains = carmanForm.getTypeOfTrains();
            Pattern pattern8 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher8 = pattern8.matcher(typeOfTrains);

            if(!matcher8.matches()){
                return "redirect:/web/carman/error20";
            }

        carman.setDescriction(carmanForm.getDescriction());

            String description = carmanForm.getDescriction();
            Pattern pattern6 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher6 = pattern6.matcher(description);

            if(!matcher6.matches()){
                return "redirect:/web/carman/error5";
            }

        service.save(carman);
        model.addAttribute("carmans", service.getall());
        return "redirect:/web/carman/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Carman carman = service.get(id);
        CarmanForm carmanForm = new CarmanForm();
        Map<String, String> mavs = brigadeService.getall().stream()
                .collect(Collectors.toMap(Brigade::getId, Brigade::getMission));
        carmanForm.setFullName(carman.getFullName());
        carmanForm.setPhone(carman.getPhone());
        carmanForm.setAdress(carman.getAdress());
        carmanForm.setBirth(carman.getBirth());
        carmanForm.setSubclass(carman.getSubclass());
        carmanForm.setBrigateID(carman.getBrigateID().getMission());
        carmanForm.setDriveExperience(carman.getDriveExperience());
        carmanForm.setTypeOfTrains(carman.getTypeOfTrains());
        carmanForm.setDescriction(carman.getDescriction());
        model.addAttribute("mavs", mavs);
        model.addAttribute("carmanForm", carmanForm);
        return "carmanAdd";
    }

    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("carmanForm") CarmanForm carmanForm) {
        Carman carman = new Carman();
        Brigade brigade = brigadeService.get(carmanForm.getBrigateID());
        carman.setId(id);

        carman.setFullName(carmanForm.getFullName());

            String name = carmanForm.getFullName();
            Pattern pattern1 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,26}$|^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[-]{0,1}[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[-]{0,1}[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[-]{0,1}[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}$|^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{1,18}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,8}[']{0,1}[а-я]{0,8}[']{0,1}[a-zа-яіїєґ]{1,18}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{1,18}");
            Matcher matcher1 = pattern1.matcher(name);

            if (!matcher1.matches()) {
                return "redirect:/web/carman/error1";
            }

        carman.setPhone(carmanForm.getPhone());

            String number = carmanForm.getPhone();
            Pattern pattern2 = Pattern.compile("^[0][6][8][0-9]{7}$|^[0][3][9][0-9]{7}$|^[0][6][7][0-9]{7}$|^[0][9][6][0-9]{7}$|^[0][9][7][0-9]{7}$|^[0][9][8][0-9]{7}$|^[0][5][0][0-9]{7}$|^[0][6][6][0-9]{7}$|^[0][9][5][0-9]{7}$|^[0][9][9][0-9]{7}$|^[0][6][3][0-9]{7}$|^[0][9][3][0-9]{7}$|^[0][9][1][0-9]{7}$|^[0][9][2][0-9]{7}$|^[0][9][4][0-9]{7}$");
            Matcher matcher2 = pattern2.matcher(number);

            if (!matcher2.matches()) {
                return "redirect:/web/carman/error3";
            }

        carman.setAdress(carmanForm.getAdress());

            String adress = carmanForm.getAdress();
            Pattern pattern3 = Pattern.compile(".{10,100}");
            Matcher matcher3 = pattern3.matcher(adress);

            if (!matcher3.matches()) {
                return "redirect:/web/carman/error9";
            }

        carman.setBirth(carmanForm.getBirth());

            String birth = carmanForm.getBirth();
            Pattern pattern4 = Pattern.compile("^[0-2][0-9][.][0][1-9][.][1][9][0-9][0-9]$|[3][0-1][.][0][1-9][.][1][9][0-9][0-9]$|[0-2][0-9][.][1][0-2][.][1][9][0-9][0-9]$|[3][0-1][.][1][0-2][.][1][9][0-9][0-9]$|[0-2][0-9][.][0][1-9][.][2][0][0-9][0-9]$|[3][0-1][.][0][1-9][.][2][0][0-9][0-9]$|[0-2][0-9][.][1][0-2][.][2][0][0-9][0-9]$|[3][0-1][.][1][0-2][.][2][0][0-9][0-9]$");
            Matcher matcher4 = pattern4.matcher(birth);

            if (!matcher4.matches()) {
                return "redirect:/web/carman/error2";
            }

        carman.setSubclass(carmanForm.getSubclass());

            String subclass = carmanForm.getSubclass();
            Pattern pattern5 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher5 = pattern5.matcher(subclass);

            if (!matcher5.matches()) {
                return "redirect:/web/carman/error15";
            }

        carman.setBrigateID(brigade);

        carman.setDriveExperience(carmanForm.getDriveExperience());

            String experience = carmanForm.getDriveExperience();
            Pattern pattern7 = Pattern.compile("^[0-9][0-9]{0,1}$");
            Matcher matcher7 = pattern7.matcher(experience);

            if (!matcher7.matches()) {
                return "redirect:/web/carman/error8";
            }

        carman.setTypeOfTrains(carmanForm.getTypeOfTrains());

            String typeOfTrains = carmanForm.getTypeOfTrains();
            Pattern pattern8 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher8 = pattern8.matcher(typeOfTrains);

            if (!matcher8.matches()) {
                return "redirect:/web/carman/error20";
            }

        carman.setDescriction(carmanForm.getDescriction());

            String description = carmanForm.getDescriction();
            Pattern pattern6 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher6 = pattern6.matcher(description);

            if (!matcher6.matches()) {
                return "redirect:/web/carman/error5";
            }

        service.save(carman);
        model.addAttribute("carmans", service.getall());
        return "redirect:/web/carman/get/list";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Carman> carmans = service.getall();
        List<Carman> sorted = service.sortByName(carmans);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("carmans", sorted);
        return "carmanList";
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Carman> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("carmans", list);
        return "carmanList";
    }

    @PostMapping("/error5")
    public String errorfinder5(){
        return "error";
    }

    @PostMapping("/error15")
    public String errorfinder15(){
        return "error";
    }

    @PostMapping("/error1")
    public String errorfinder1(){
        return "error";
    }

    @PostMapping("/error3")
    public String errorfinder3(){
        return "error";
    }

    @PostMapping("/error9")
    public String errorfinder9(){
        return "error";
    }

    @PostMapping("/error2")
    public String errorfinder2(){
        return "error";
    }

    @PostMapping("/error8")
    public String errorfinder8(){
        return "error";
    }

    @PostMapping("/error20")
    public String errorfinder20(){
        return "error";
    }
}
