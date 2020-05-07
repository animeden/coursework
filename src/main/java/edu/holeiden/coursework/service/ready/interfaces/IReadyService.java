package edu.holeiden.coursework.service.ready.interfaces;

import edu.holeiden.coursework.model.Ready;

import java.util.List;

public interface IReadyService {
    Ready save(Ready worker);
    Ready get(String id);
    List<Ready> getall();
    Ready edit(Ready worker);
    Ready delete(String  id);
}
