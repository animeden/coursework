package edu.holeiden.coursework.dao.repository;

import edu.holeiden.coursework.model.Carman;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarmanRepository extends MongoRepository<Carman, String> {
}
