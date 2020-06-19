package edu.holeiden.coursework.dao.repository;

import edu.holeiden.coursework.model.Administration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface AdministrationRepository extends MongoRepository<Administration, String> {
}
