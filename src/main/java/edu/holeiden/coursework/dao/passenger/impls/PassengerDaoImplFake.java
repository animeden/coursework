package edu.holeiden.coursework.dao.passenger.impls;

import edu.holeiden.coursework.dao.passenger.interfaces.IPassengerDao;
import edu.holeiden.coursework.dataSet.DataSet;
import edu.holeiden.coursework.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PassengerDaoImplFake implements IPassengerDao {
    @Autowired
    DataSet dataSet;

    @Override
    public Passenger save(Passenger passenger) {
        return null;
    }

    @Override
    public Passenger get(String id) {
        return null;
    }

    @Override
    public List<Passenger> getall() {
        return dataSet.getPassengers();
    }

    @Override
    public Passenger edit(Passenger passenger) {
        return null;
    }

    @Override
    public Passenger delete(String id) {
        return null;
    }
}
