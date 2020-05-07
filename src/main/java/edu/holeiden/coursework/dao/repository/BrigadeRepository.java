package edu.holeiden.coursework.dao.repository;

import edu.holeiden.coursework.model.Brigade;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BrigadeRepository extends MongoRepository<Brigade, String> {
}
