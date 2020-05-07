package edu.holeiden.coursework.dao.repository;

import edu.holeiden.coursework.model.Train;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrainRepository extends MongoRepository<Train, String> {
}
