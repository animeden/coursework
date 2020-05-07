package edu.holeiden.coursework.dao.repository;

import edu.holeiden.coursework.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, String> {
}
