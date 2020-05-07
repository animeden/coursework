package edu.holeiden.coursework.dao.ready.impls;

import edu.holeiden.coursework.dao.ready.interfaces.IReadyDao;
import edu.holeiden.coursework.dataSet.DataSet;
import edu.holeiden.coursework.model.Ready;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ReadyDaoImplFake implements IReadyDao {
    @Autowired
    DataSet dataSet;

    @Override
    public Ready save(Ready worker) {
        return null;
    }

    @Override
    public Ready get(String id) {
        return null;
    }

    @Override
    public List<Ready> getall() {
        return dataSet.getReadies();
    }

    @Override
    public Ready edit(Ready worker) {
        return null;
    }

    @Override
    public Ready delete(String id) {
        return null;
    }
}
