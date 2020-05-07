package edu.holeiden.coursework.dao.passenger.interfaces;

import edu.holeiden.coursework.model.Passenger;

import java.util.List;

public interface IPassengerDao {
    Passenger save(Passenger passenger);
    Passenger get(String id);
    List<Passenger> getall();
    Passenger edit(Passenger passenger);
    Passenger delete(String  id);
}
