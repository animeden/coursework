package edu.holeiden.coursework.service.ready.impls;

import edu.holeiden.coursework.dao.repository.ReadyRepository;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.model.Ready;
import edu.holeiden.coursework.service.administration.impls.AdministrationServiceImpl;
import edu.holeiden.coursework.service.ready.interfaces.IReadyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        Ready ready = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return ready;
    }

    public List<Ready> search(String word){
        List<Ready> list = this.getall().stream()
                .filter(ready -> ready.getDescriction().contains(word))
                .collect(Collectors.toList());
        return list;
    }

    public List<Ready> sortByName(List<Ready> people){

        Collections.sort(people, new ReadyNameComparator());

        return people;
    }

    private class ReadyNameComparator implements Comparator<Ready> {
        public int compare(Ready p1, Ready p2) {
            return p1.getDescriction().compareTo(p2.getDescriction());
        }
    }
}
