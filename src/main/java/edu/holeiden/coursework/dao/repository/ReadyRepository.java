package edu.holeiden.coursework.dao.repository;

import edu.holeiden.coursework.model.Ready;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReadyRepository extends MongoRepository<Ready, String> {
}
