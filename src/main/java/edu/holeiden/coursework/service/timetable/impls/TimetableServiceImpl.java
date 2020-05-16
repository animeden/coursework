package edu.holeiden.coursework.service.timetable.impls;

import edu.holeiden.coursework.dao.repository.TimetableRepository;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.model.Timetable;
import edu.holeiden.coursework.service.timetable.interfaces.ITimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimetableServiceImpl implements ITimetableService {

    @Autowired
    TimetableRepository repository;

    @PostConstruct
    void init(){

        //repository.saveAll(list);

    }

    @Override
    public Timetable save(Timetable timetable) {
        timetable.setCreate(LocalDateTime.now());
        timetable.setModified(LocalDateTime.now());
        return repository.save(timetable);
    }

    @Override
    public Timetable get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Timetable> getall() {
        return repository.findAll();
    }

    @Override
    public Timetable edit(Timetable timetable) {
        timetable.setModified(LocalDateTime.now());
        return repository.save(timetable);
    }

    @Override
    public Timetable delete(String id) {
        Timetable timetable = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return timetable;
    }

    public List<Timetable> search(String word){
        List<Timetable> list = this.getall().stream()
                .filter(timetable -> timetable.getTimeOfGoing().contains(word))
                .collect(Collectors.toList());
        return list;
    }
}
