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
    BrigadeDaoImplFake dao;

    @PostConstruct
    void init(){

        List<Brigade> list = dao.getall();

        //repository.saveAll(list);

    }

    @Override
    public Brigade save(Brigade brigade) {
        return null;
    }

    @Override
    public Brigade get(String id) {

        return dao.getall().stream().filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Brigade> getall() {

        return dao.getall();
    }

    @Override
    public Brigade edit(Brigade brigade) {

        return null;
    }

    @Override
    public Brigade delete(String id) {
        return null;
    }
}
