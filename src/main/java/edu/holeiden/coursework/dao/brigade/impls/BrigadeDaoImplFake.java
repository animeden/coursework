package edu.holeiden.coursework.dao.brigade.impls;

import edu.holeiden.coursework.dao.brigade.interfaces.IBrigadeDao;
import edu.holeiden.coursework.dataSet.DataSet;
import edu.holeiden.coursework.model.Brigade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrigadeDaoImplFake implements IBrigadeDao {
    @Autowired
    DataSet dataSet;

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
        return dataSet.getBrigades();
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
