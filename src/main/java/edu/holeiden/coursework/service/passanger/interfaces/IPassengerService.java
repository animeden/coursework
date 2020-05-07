package edu.holeiden.coursework.service.passanger.interfaces;

import edu.holeiden.coursework.model.Passenger;

import java.util.List;

public interface IPassengerService {
    Passenger save(Passenger passenger);
    Passenger get(String id);
    List<Passenger> getall();
    Passenger edit(Passenger passenger);
    Passenger delete(String  id);
}
