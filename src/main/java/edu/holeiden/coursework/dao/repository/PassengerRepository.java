package edu.holeiden.coursework.dao.repository;

import edu.holeiden.coursework.model.Passenger;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PassengerRepository extends MongoRepository<Passenger, String> {
}
