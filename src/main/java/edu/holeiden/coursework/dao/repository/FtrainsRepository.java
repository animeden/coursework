package edu.holeiden.coursework.dao.repository;

import edu.holeiden.coursework.model.Ftrains;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FtrainsRepository extends MongoRepository<Ftrains, String > {
}
