package edu.holeiden.coursework.dao.worker.interfaces;

import edu.holeiden.coursework.model.Worker;

import java.util.List;

public interface IWorkerDao {
    Worker save(Worker worker);
    Worker get(String id);
    List<Worker> getall();
    Worker edit(Worker worker);
    Worker delete(String  id);
}
