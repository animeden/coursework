package edu.holeiden.coursework.controller.web;

import edu.holeiden.coursework.form.TimetableForm;
import edu.holeiden.coursework.form.WorkerForm;
import edu.holeiden.coursework.model.Timetable;
import edu.holeiden.coursework.model.Worker;
import edu.holeiden.coursework.service.worker.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/worker")
public class WorkerWEBController {
    @Autowired
    WorkerServiceImpl service;

    @RequestMapping("/get/list")
    String getall(Model model){
        model.addAttribute("workers", service.getall());
        return "workerList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("workers", service.getall());
        return "redirect:/web/worker/get/list";
    }

    @RequestMapping("/create")
    String create(Model model){
        WorkerForm workerForm = new WorkerForm();
        model.addAttribute("workerForm", workerForm);
        return "workerAdd";
    }

    @PostMapping("/create")
    String create(Model model, @ModelAttribute("workerForm") WorkerForm workerForm){
        Worker worker = new Worker();
        worker.setFullName(workerForm.getFullName());
        worker.setPhone(workerForm.getPhone());
        worker.setAdress(workerForm.getAdress());
        worker.setBirth(workerForm.getBirth());
        worker.setSubclass(workerForm.getSubclass());
        worker.setBrigateID(workerForm.getBrigateID());
        worker.setDescriction(workerForm.getDescriction());
        service.save(worker);
        model.addAttribute("workers", service.getall());
        return "redirect:/web/worker/get/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Worker worker = service.get(id);
        WorkerForm workerForm = new WorkerForm();
        workerForm.setFullName(worker.getFullName());
        workerForm.setPhone(worker.getPhone());
        workerForm.setAdress(worker.getAdress());
        workerForm.setBirth(worker.getBirth());
        workerForm.setSubclass(worker.getSubclass());
        workerForm.setBrigateID(worker.getBrigateID());
        workerForm.setDescriction(worker.getDescriction());
        model.addAttribute("workerForm", workerForm);
        return "workerAdd";
    }

    @PostMapping("/edit/{id}")
    String edith(Model model, @PathVariable("id") String id, @ModelAttribute("workerForm") WorkerForm workerForm){
        Worker worker = new Worker();
        worker.setId(id);
        worker.setFullName(workerForm.getFullName());
        worker.setPhone(workerForm.getPhone());
        worker.setAdress(workerForm.getAdress());
        worker.setBirth(workerForm.getBirth());
        worker.setSubclass(workerForm.getSubclass());
        worker.setBrigateID(workerForm.getBrigateID());
        worker.setDescriction(workerForm.getDescriction());
        service.save(worker);
        model.addAttribute("workers", service.getall());
        return "redirect:/web/worker/get/list";
    }
}
