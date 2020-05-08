package edu.holeiden.coursework.service.administration.impls;

import edu.holeiden.coursework.dao.repository.AdministrationRepository;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.service.administration.interfaces.IAdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

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
}
