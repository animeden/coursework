package edu.holeiden.coursework.service.ready.impls;

import edu.holeiden.coursework.dao.repository.ReadyRepository;
import edu.holeiden.coursework.model.Ready;
import edu.holeiden.coursework.service.ready.interfaces.IReadyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReadyServiceImpl implements IReadyService {

    @Autowired
    ReadyRepository repository;

    @PostConstruct
    void init(){

        //repository.saveAll(list);

    }

    @Override
    public Ready save(Ready ready) {
        ready.setCreate(LocalDateTime.now());
        ready.setModified(LocalDateTime.now());
        return repository.save(ready);
    }

    @Override
    public Ready get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Ready> getall() {
        return repository.findAll();
    }

    @Override
    public Ready edit(Ready ready) {
        ready.setModified(LocalDateTime.now());
        return repository.save(ready);
    }

    @Override
    public Ready delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
