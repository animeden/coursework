package edu.holeiden.coursework.dao.train.interfaces;

import edu.holeiden.coursework.model.Train;

import java.util.List;

public interface ITrainDao {
    Train save(Train train);
    Train get(String id);
    List<Train> getall();
    Train edit(Train train);
    Train delete(String  id);
}
