package edu.holeiden.coursework.service.worker.impls;

import edu.holeiden.coursework.dao.repository.WorkerRepository;
import edu.holeiden.coursework.model.Worker;
import edu.holeiden.coursework.service.worker.interfaces.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

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
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
