package edu.holeiden.coursework.service.carman.impls;

import edu.holeiden.coursework.dao.repository.CarmanRepository;
import edu.holeiden.coursework.model.Carman;
import edu.holeiden.coursework.service.carman.interfaces.ICarmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarmanServiceImpl implements ICarmanService {
    @Autowired
    CarmanRepository repository;

    @PostConstruct
    void init(){

        //repository.saveAll(list);

    }

    @Override
    public Carman save(Carman carman) {
        carman.setCreate(LocalDateTime.now());
        carman.setModified(LocalDateTime.now());
        return repository.save(carman);
    }

    @Override
    public Carman get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Carman> getall() {
        return repository.findAll();
    }

    @Override
    public Carman edit(Carman carman) {
        carman.setModified(LocalDateTime.now());
        return repository.save(carman);
    }

    @Override
    public Carman delete(String id) {
        Carman carman = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return carman;
    }

    public List<Carman> search(String word){
        List<Carman> list = this.getall().stream()
                .filter(carman -> carman.getFullName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
        return list;
    }

    public List<Carman> sortByName(List<Carman> people){

        Collections.sort(people, new CarmanComparator());

        return people;
    }

    private class CarmanComparator implements Comparator<Carman> {
        public int compare(Carman p1, Carman p2) {
            return p1.getFullName().compareTo(p2.getFullName());
        }
    }
}
