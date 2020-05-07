package edu.holeiden.coursework.dao.repository;

import edu.holeiden.coursework.model.Timetable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TimetableRepository extends MongoRepository<Timetable, String> {
}
