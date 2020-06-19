package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.SearchForm;
import edu.holeiden.coursework.form.TimetableForm;
import edu.holeiden.coursework.form.WorkerForm;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.model.Brigade;
import edu.holeiden.coursework.model.Timetable;
import edu.holeiden.coursework.model.Worker;
import edu.holeiden.coursework.service.brigade.impls.BrigadeServiceImpl;
import edu.holeiden.coursework.service.worker.impls.WorkerServiceImpl;
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
@RequestMapping("/web/worker")
public class WorkerWEBController {
    @Autowired
    WorkerServiceImpl service;

    @Autowired
    BrigadeServiceImpl brigadeService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    String getall(Model model){
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("workers", service.getall());
        return "workerList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/get/list", method = RequestMethod.POST)
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm){
        String word = searchForm.getString();
        List<Worker> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("workers", list);
        return "workerList";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("workers", service.getall());
        return "redirect:/web/worker/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/create")
    String create(Model model){
        WorkerForm workerForm = new WorkerForm();
        Map<String, String> mavs = brigadeService.getall().stream()
                .collect(Collectors.toMap(Brigade::getId, Brigade::getMission));
        model.addAttribute("mavs", mavs);
        model.addAttribute("workerForm", workerForm);
        return "workerAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    String create(Model model, @ModelAttribute("workerForm") WorkerForm workerForm){
        Worker worker = new Worker();
        Brigade brigade = brigadeService.get(workerForm.getBrigateID());
        worker.setFullName(workerForm.getFullName());

            String name = workerForm.getFullName();
            Pattern pattern1 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,26}$|^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[-]{0,1}[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[-]{0,1}[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[-]{0,1}[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}$|^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{1,18}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,8}[']{0,1}[а-я]{0,8}[']{0,1}[a-zа-яіїєґ]{1,18}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{1,18}");
            Matcher matcher1 = pattern1.matcher(name);

            if(!matcher1.matches()){
                return "redirect:/web/worker/error1";
            }

        worker.setPhone(workerForm.getPhone());

            String number = workerForm.getPhone();
            Pattern pattern2 = Pattern.compile("^[0][6][8][0-9]{7}$|^[0][3][9][0-9]{7}$|^[0][6][7][0-9]{7}$|^[0][9][6][0-9]{7}$|^[0][9][7][0-9]{7}$|^[0][9][8][0-9]{7}$|^[0][5][0][0-9]{7}$|^[0][6][6][0-9]{7}$|^[0][9][5][0-9]{7}$|^[0][9][9][0-9]{7}$|^[0][6][3][0-9]{7}$|^[0][9][3][0-9]{7}$|^[0][9][1][0-9]{7}$|^[0][9][2][0-9]{7}$|^[0][9][4][0-9]{7}$");
            Matcher matcher2 = pattern2.matcher(number);

            if(!matcher2.matches()){
                return "redirect:/web/worker/error3";
            }

        worker.setAdress(workerForm.getAdress());

            String adress = workerForm.getAdress();
            Pattern pattern3 = Pattern.compile(".{10,100}");
            Matcher matcher3 = pattern3.matcher(adress);

            if(!matcher3.matches()){
                return "redirect:/web/worker/error9";
            }

        worker.setBirth(workerForm.getBirth());

            String birth = workerForm.getBirth();
            Pattern pattern4 = Pattern.compile("^[0-2][0-9][.][0][1-9][.][1][9][0-9][0-9]$|[3][0-1][.][0][1-9][.][1][9][0-9][0-9]$|[0-2][0-9][.][1][0-2][.][1][9][0-9][0-9]$|[3][0-1][.][1][0-2][.][1][9][0-9][0-9]$|[0-2][0-9][.][0][1-9][.][2][0][0-9][0-9]$|[3][0-1][.][0][1-9][.][2][0][0-9][0-9]$|[0-2][0-9][.][1][0-2][.][2][0][0-9][0-9]$|[3][0-1][.][1][0-2][.][2][0][0-9][0-9]$");
            Matcher matcher4 = pattern4.matcher(birth);

            if(!matcher4.matches()){
                return "redirect:/web/worker/error2";
            }

        worker.setSubclass(workerForm.getSubclass());

            String subclass = workerForm.getSubclass();
            Pattern pattern5 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher5 = pattern5.matcher(subclass);

            if(!matcher5.matches()){
                return "redirect:/web/worker/error15";
            }

        worker.setBrigateID(brigade);

        worker.setExperience(workerForm.getExperience());

            String experience = workerForm.getExperience();
            Pattern pattern7 = Pattern.compile("^[0-9][0-9]{0,1}$");
            Matcher matcher7 = pattern7.matcher(experience);

            if(!matcher7.matches()){
                return "redirect:/web/worker/error8";
            }

        worker.setDescriction(workerForm.getDescriction());

            String description = workerForm.getDescriction();
            Pattern pattern6 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher6 = pattern6.matcher(description);

            if(!matcher6.matches()){
                return "redirect:/web/worker/error5";
            }

        service.save(worker);
        model.addAttribute("workers", service.getall());
        return "redirect:/web/worker/get/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Worker worker = service.get(id);
        WorkerForm workerForm = new WorkerForm();
        Map<String, String> mavs = brigadeService.getall().stream()
                .collect(Collectors.toMap(Brigade::getId, Brigade::getMission));
        workerForm.setFullName(worker.getFullName());
        workerForm.setPhone(worker.getPhone());
        workerForm.setAdress(worker.getAdress());
        workerForm.setBirth(worker.getBirth());
        workerForm.setSubclass(worker.getSubclass());
        workerForm.setBrigateID(worker.getBrigateID().getMission());
        workerForm.setExperience(worker.getExperience());
        workerForm.setDescriction(worker.getDescriction());
        model.addAttribute("mavs", mavs);
        model.addAttribute("workerForm", workerForm);
        return "workerAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("workerForm") WorkerForm workerForm){
        Worker worker = new Worker();
        Brigade brigade = brigadeService.get(workerForm.getBrigateID());
        worker.setId(id);

        worker.setFullName(workerForm.getFullName());

            String name = workerForm.getFullName();
            Pattern pattern1 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,26}$|^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[-]{0,1}[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[-]{0,1}[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}[-]{0,1}[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{2,20}$|^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{1,18}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,8}[']{0,1}[а-я]{0,8}[']{0,1}[a-zа-яіїєґ]{1,18}[\\s][A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{0,8}[']{0,1}[a-zа-яіїєґ]{1,18}");
            Matcher matcher1 = pattern1.matcher(name);

            if(!matcher1.matches()){
                return "redirect:/web/worker/error1";
            }

        worker.setPhone(workerForm.getPhone());

            String number = workerForm.getPhone();
            Pattern pattern2 = Pattern.compile("^[0][6][8][0-9]{7}$|^[0][3][9][0-9]{7}$|^[0][6][7][0-9]{7}$|^[0][9][6][0-9]{7}$|^[0][9][7][0-9]{7}$|^[0][9][8][0-9]{7}$|^[0][5][0][0-9]{7}$|^[0][6][6][0-9]{7}$|^[0][9][5][0-9]{7}$|^[0][9][9][0-9]{7}$|^[0][6][3][0-9]{7}$|^[0][9][3][0-9]{7}$|^[0][9][1][0-9]{7}$|^[0][9][2][0-9]{7}$|^[0][9][4][0-9]{7}$");
            Matcher matcher2 = pattern2.matcher(number);

            if(!matcher2.matches()){
                return "redirect:/web/worker/error3";
            }

        worker.setAdress(workerForm.getAdress());

            String adress = workerForm.getAdress();
            Pattern pattern3 = Pattern.compile(".{10,100}");
            Matcher matcher3 = pattern3.matcher(adress);

            if(!matcher3.matches()){
                return "redirect:/web/worker/error9";
            }

        worker.setBirth(workerForm.getBirth());

            String birth = workerForm.getBirth();
            Pattern pattern4 = Pattern.compile("^[0-2][0-9][.][0][1-9][.][1][9][0-9][0-9]$|[3][0-1][.][0][1-9][.][1][9][0-9][0-9]$|[0-2][0-9][.][1][0-2][.][1][9][0-9][0-9]$|[3][0-1][.][1][0-2][.][1][9][0-9][0-9]$|[0-2][0-9][.][0][1-9][.][2][0][0-9][0-9]$|[3][0-1][.][0][1-9][.][2][0][0-9][0-9]$|[0-2][0-9][.][1][0-2][.][2][0][0-9][0-9]$|[3][0-1][.][1][0-2][.][2][0][0-9][0-9]$");
            Matcher matcher4 = pattern4.matcher(birth);

            if(!matcher4.matches()){
                return "redirect:/web/worker/error2";
            }

        worker.setSubclass(workerForm.getSubclass());

            String subclass = workerForm.getSubclass();
            Pattern pattern5 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher5 = pattern5.matcher(subclass);

            if(!matcher5.matches()){
                return "redirect:/web/worker/error15";
            }

        worker.setBrigateID(brigade);

        worker.setExperience(workerForm.getExperience());

            String experience = workerForm.getExperience();
            Pattern pattern7 = Pattern.compile("^[0-9][0-9]{0,1}$");
            Matcher matcher7 = pattern7.matcher(experience);

            if(!matcher7.matches()){
                return "redirect:/web/worker/error8";
            }

        worker.setDescriction(workerForm.getDescriction());

            String description = workerForm.getDescriction();
            Pattern pattern6 = Pattern.compile("^[A-ZА-ЯІЇЄҐ][a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[\\s]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}[-]{0,1}[A-ZА-ЯІЇЄҐ]{0,1}[a-zа-яіїєґ]{0,15}[']{0,1}[a-zа-яіїєґ]{0,15}$");
            Matcher matcher6 = pattern6.matcher(description);

            if(!matcher6.matches()){
                return "redirect:/web/worker/error5";
            }

        service.save(worker);
        model.addAttribute("workers", service.getall());
        return "redirect:/web/worker/get/list";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public String showSorted(Model model) {
        List<Worker> workers = service.getall();
        List<Worker> sorted = service.sortByName(workers);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("workers", sorted);
        return "workerList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Worker> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("workers", list);
        return "workerList";
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
}
