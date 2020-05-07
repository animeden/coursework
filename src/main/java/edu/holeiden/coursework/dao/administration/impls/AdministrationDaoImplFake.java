package edu.holeiden.coursework.dao.administration.impls;

import edu.holeiden.coursework.dao.administration.interfaces.IAdministrationDao;
import edu.holeiden.coursework.dataSet.DataSet;
import edu.holeiden.coursework.model.Administration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AdministrationDaoImplFake implements IAdministrationDao {
    @Autowired
    DataSet dataSet;

    @Override
    public Administration save(Administration administration) {

        return null;
    }

    @Override
    public Administration get(String id) {

        return null;
    }

    @Override
    public List<Administration> getall() {

        return dataSet.getAdministrations();
    }

    @Override
    public Administration edit(Administration administration) {

        return null;
    }

    @Override
    public Administration delete(String id) {

        return null;
    }
}
