package edu.holeiden.coursework.service.worker.impls;

import edu.holeiden.coursework.dao.repository.WorkerRepository;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.model.Worker;
import edu.holeiden.coursework.service.administration.impls.AdministrationServiceImpl;
import edu.holeiden.coursework.service.worker.interfaces.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerServiceImpl implements IWorkerService {
    @Autowired
    WorkerRepository repository;

    @PostConstruct
    void init(){

        //repository.saveAll(list);

    }

    @Override
    public Worker save(Worker worker) {
        worker.setCreate(LocalDateTime.now());
        worker.setModified(LocalDateTime.now());
        return repository.save(worker);
    }

    @Override
    public Worker get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Worker> getall() {
        return repository.findAll();
    }

    @Override
    public Worker edit(Worker worker) {
        worker.setModified(LocalDateTime.now());
        return repository.save(worker);
    }

    @Override
    public Worker delete(String id) {
        Worker worker = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return worker;
    }

    public List<Worker> search(String word){
        List<Worker> list = this.getall().stream()
                .filter(worker -> worker.getFullName().contains(word))
                .collect(Collectors.toList());
        return list;
    }

    public List<Worker> sortByName(List<Worker> people){

        Collections.sort(people, new WorkerComparator());

        return people;
    }

    private class WorkerComparator implements Comparator<Worker> {
        public int compare(Worker p1, Worker p2) {
            return p1.getFullName().compareTo(p2.getFullName());
        }
    }
}
