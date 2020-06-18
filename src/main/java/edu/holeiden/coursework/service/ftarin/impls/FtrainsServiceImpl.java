package edu.holeiden.coursework.service.ftarin.impls;

import edu.holeiden.coursework.dao.repository.FtrainsRepository;
import edu.holeiden.coursework.model.Ftrains;
import edu.holeiden.coursework.service.ftarin.interfaces.IFtrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FtrainsServiceImpl implements IFtrainService {
    @Autowired
    FtrainsRepository repository;

    @PostConstruct
    void init(){

        //repository.saveAll(list);

    }

    @Override
    public Ftrains save(Ftrains ftrains) {
        ftrains.setCreate(LocalDateTime.now());
        ftrains.setModified(LocalDateTime.now());
        return repository.save(ftrains);
    }

    @Override
    public Ftrains get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Ftrains> getall() {
        return repository.findAll();
    }

    @Override
    public Ftrains edit(Ftrains ftrains) {
        ftrains.setModified(LocalDateTime.now());
        return repository.save(ftrains);
    }

    @Override
    public Ftrains delete(String id) {
        Ftrains ftrains = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return ftrains;
    }

    public List<Ftrains> search(String word){
        List<Ftrains> list = this.getall().stream()
                .filter(ftrains -> ftrains.getModel().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
        return list;
    }

    public List<Ftrains> sortByName(List<Ftrains> people){

        Collections.sort(people, new Ftraincomparator());

        return people;
    }

    private class Ftraincomparator implements Comparator<Ftrains> {
        public int compare(Ftrains p1, Ftrains p2) {
            return p1.getModel().compareTo(p2.getModel());
        }
    }
}
