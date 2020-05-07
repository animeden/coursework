package edu.holeiden.coursework.service.brigade.impls;

import edu.holeiden.coursework.dao.brigade.impls.BrigadeDaoImplFake;
import edu.holeiden.coursework.dao.repository.BrigadeRepository;
import edu.holeiden.coursework.model.Brigade;
import edu.holeiden.coursework.service.brigade.interfaces.IBrigadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

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
        return null;
    }

    @Override
    public Brigade get(String id) {

        return null;
    }

    @Override
    public List<Brigade> getall() {

        return repository.findAll();
    }

    @Override
    public Brigade edit(Brigade brigade) {

        return null;
    }

    @Override
    public Brigade delete(String id) {

        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
