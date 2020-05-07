package edu.holeiden.coursework.service.worker.interfaces;

import edu.holeiden.coursework.model.Worker;

import java.util.List;

public interface IWorkerService {
    Worker save(Worker worker);
    Worker get(String id);
    List<Worker> getall();
    Worker edit(Worker worker);
    Worker delete(String  id);
}
