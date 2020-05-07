package edu.holeiden.coursework.dao.repository;

import edu.holeiden.coursework.model.Worker;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkerRepository extends MongoRepository<Worker, String> {
}
