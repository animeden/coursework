package edu.holeiden.coursework.service.administration.impls;

import edu.holeiden.coursework.dao.repository.AdministrationRepository;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.service.administration.interfaces.IAdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdministrationServiceImpl implements IAdministrationService {

    @Autowired
    AdministrationRepository repository;

    @PostConstruct
    void init(){

        //repository.saveAll(list);

    }

    @Override
    public Administration save(Administration administration) {
        administration.setCreate(LocalDateTime.now());
        administration.setModified(LocalDateTime.now());
        return repository.save(administration);
    }

    @Override
    public Administration get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Administration> getall() {
        return repository.findAll();
    }

    @Override
    public Administration edit(Administration administration) {
        administration.setModified(LocalDateTime.now());
        return repository.save(administration);
    }

    @Override
    public Administration delete(String id) {
        Administration administration = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return administration;
    }

    public List<Administration> search(String word){
        List<Administration> list = this.getall().stream()
                .filter(administration -> administration.getName().contains(word.toLowerCase()))
                .collect(Collectors.toList());
        return list;
    }

    public List<Administration> sortByName(List<Administration> people){

        Collections.sort(people, new AdministarationNameComparator());

        return people;
    }

    private class AdministarationNameComparator implements Comparator<Administration> {
        public int compare(Administration p1, Administration p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }
}
