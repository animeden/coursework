package edu.holeiden.coursework.service.administration.impls;

import edu.holeiden.coursework.dao.administration.impls.AdministrationDaoImplFake;
import edu.holeiden.coursework.dao.repository.AdministrationRepository;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.service.administration.interfaces.IAdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AdministrationServiceImpl implements IAdministrationService {
    @Autowired
    AdministrationDaoImplFake dao;

    @PostConstruct
    void init(){

        List<Administration> list = dao.getall();

        ///repository.saveAll(list);

    }

    @Override
    public Administration save(Administration administration) {

        return null;
    }

    @Override
    public Administration get(String id) {

        return dao.getall().stream().filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Administration> getall() {

        return dao.getall();
    }

    @Override
    public Administration edit(Administration administration) {

        return null;
    }

    @Override
    public Administration delete(String id) {
        Administration administration = this.get(id);
        dao.getall().remove(administration);
        return administration;
    }
}
