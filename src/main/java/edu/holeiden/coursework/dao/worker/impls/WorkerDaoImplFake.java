package edu.holeiden.coursework.dao.worker.impls;

import edu.holeiden.coursework.dao.worker.interfaces.IWorkerDao;
import edu.holeiden.coursework.dataSet.DataSet;
import edu.holeiden.coursework.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkerDaoImplFake implements IWorkerDao {
    @Autowired
    DataSet dataSet;

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
        return dataSet.getWorkers();
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
