package edu.holeiden.coursework.service.brigade.impls;

import edu.holeiden.coursework.dao.repository.BrigadeRepository;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.model.Brigade;
import edu.holeiden.coursework.service.administration.impls.AdministrationServiceImpl;
import edu.holeiden.coursework.service.brigade.interfaces.IBrigadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrigadeServiceImpl implements IBrigadeService {

    @Autowired
    BrigadeRepository repository;

    @PostConstruct
    void init(){

        //repository.saveAll(list);

    }

    @Override
    public Brigade save(Brigade brigade) {
        brigade.setCreate(LocalDateTime.now());
        brigade.setModified(LocalDateTime.now());
        return repository.save(brigade);
    }

    @Override
    public Brigade get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Brigade> getall() {
        return repository.findAll();
    }

    @Override
    public Brigade edit(Brigade brigade) {
        brigade.setModified(LocalDateTime.now());
        return repository.save(brigade);
    }

    @Override
    public Brigade delete(String id) {
        Brigade brigade = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return brigade;
    }

    public List<Brigade> search(String word){
        List<Brigade> list = this.getall().stream()
                .filter(brigade -> brigade.getMission().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
        return list;
    }

    public List<Brigade> sortByName(List<Brigade> people){

        Collections.sort(people, new BrigadeComparator());

        return people;
    }

    private class BrigadeComparator implements Comparator<Brigade> {
        public int compare(Brigade p1, Brigade p2) {
            return p1.getMission().compareTo(p2.getMission());
        }
    }
}
