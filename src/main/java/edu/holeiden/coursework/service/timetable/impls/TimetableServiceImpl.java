package edu.holeiden.coursework.service.timetable.impls;

import edu.holeiden.coursework.dao.repository.TimetableRepository;
import edu.holeiden.coursework.model.Timetable;
import edu.holeiden.coursework.service.timetable.interfaces.ITimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

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
        return null;
    }

    @Override
    public Timetable get(String id) {
        return null;
    }

    @Override
    public List<Timetable> getall() {
        return repository.findAll();
    }

    @Override
    public Timetable edit(Timetable timetable) {
        return null;
    }

    @Override
    public Timetable delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
