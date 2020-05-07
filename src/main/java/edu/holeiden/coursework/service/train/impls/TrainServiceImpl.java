package edu.holeiden.coursework.service.train.impls;

import edu.holeiden.coursework.dao.repository.TrainRepository;
import edu.holeiden.coursework.dao.train.impls.TrainDaoImplFake;
import edu.holeiden.coursework.model.Timetable;
import edu.holeiden.coursework.model.Train;
import edu.holeiden.coursework.service.train.interfaces.ITrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TrainServiceImpl implements ITrainService {
    @Autowired
    TrainDaoImplFake dao;

    @Autowired
    TrainRepository repository;

    @PostConstruct
    void init(){

        List<Train> list = dao.getall();

        //repository.saveAll(list);

    }

    @Override
    public Train save(Train train) {
        return null;
    }

    @Override
    public Train get(String id) {
        return null;
    }

    @Override
    public List<Train> getall() {
        return repository.findAll();
    }

    @Override
    public Train edit(Train train) {
        return null;
    }

    @Override
    public Train delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
