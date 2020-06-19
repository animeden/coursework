package edu.holeiden.coursework.dao.repository;

import edu.holeiden.coursework.model.Administration;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdministrationRepository extends MongoRepository<Administration, Integer> {
}
