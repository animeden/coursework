package edu.holeiden.coursework.dao.repository;

import edu.holeiden.coursework.model.Route;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouteRepository extends MongoRepository<Route, String> {
}
