package edu.holeiden.coursework.service.train.impls;

import edu.holeiden.coursework.dao.repository.TrainRepository;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.model.Timetable;
import edu.holeiden.coursework.model.Train;
import edu.holeiden.coursework.service.administration.impls.AdministrationServiceImpl;
import edu.holeiden.coursework.service.train.interfaces.ITrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainServiceImpl implements ITrainService {

    @Autowired
    TrainRepository repository;

    @PostConstruct
    void init(){

        //repository.saveAll(list);

    }

    @Override
    public Train save(Train train) {
        train.setCreate(LocalDateTime.now());
        train.setModified(LocalDateTime.now());
        return repository.save(train);
    }

    @Override
    public Train get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Train> getall() {
        return repository.findAll();
    }

    @Override
    public Train edit(Train train) {
        train.setModified(LocalDateTime.now());
        return repository.save(train);
    }

    @Override
    public Train delete(String id) {
        Train train = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return train;
    }

    public List<Train> search(String word){
        List<Train> list = this.getall().stream()
                .filter(train -> train.getModel().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
        return list;
    }

    public List<Train> sortByName(List<Train> people){

        Collections.sort(people, new Traincomparator());

        return people;
    }

    private class Traincomparator implements Comparator<Train> {
        public int compare(Train p1, Train p2) {
            return p1.getModel().compareTo(p2.getModel());
        }
    }
}
