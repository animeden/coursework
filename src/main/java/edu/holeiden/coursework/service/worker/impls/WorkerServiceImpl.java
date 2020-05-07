package edu.holeiden.coursework.service.worker.impls;

import edu.holeiden.coursework.dao.repository.WorkerRepository;
import edu.holeiden.coursework.dao.worker.impls.WorkerDaoImplFake;
import edu.holeiden.coursework.model.Worker;
import edu.holeiden.coursework.service.worker.interfaces.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class WorkerServiceImpl implements IWorkerService {
    @Autowired
    WorkerDaoImplFake dao;

    @PostConstruct
    void init(){

        List<Worker> list = dao.getall();

        //repository.saveAll(list);

    }

    @Override
    public Worker save(Worker worker) {
        return null;
    }

    @Override
    public Worker get(String id) {
        return null;
    }

    @Override
    public List<Worker> getall() {
        return dao.getall();
    }

    @Override
    public Worker edit(Worker worker) {
        return null;
    }

    @Override
    public Worker delete(String id) {
        return null;
    }
}
