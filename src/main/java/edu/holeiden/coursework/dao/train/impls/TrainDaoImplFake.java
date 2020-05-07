package edu.holeiden.coursework.dao.train.impls;

import edu.holeiden.coursework.dao.train.interfaces.ITrainDao;
import edu.holeiden.coursework.dataSet.DataSet;
import edu.holeiden.coursework.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrainDaoImplFake implements ITrainDao {
    @Autowired
    DataSet dataSet;

    @Override
    public Train save(Train train) {
        return null;
    }

    @Override
    public Train get(String id) {
        return null;
    }

    @Override
    public List<Train> getall() {
        return dataSet.getTrains();
    }

    @Override
    public Train edit(Train train) {
        return null;
    }

    @Override
    public Train delete(String id) {
        return null;
    }
}
