package edu.holeiden.coursework.dao.repository;

import edu.holeiden.coursework.model.Station;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StationRepository extends MongoRepository<Station, String> {
}
