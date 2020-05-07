package edu.holeiden.coursework.dao.ready.interfaces;

import edu.holeiden.coursework.model.Ready;

import java.util.List;

public interface IReadyDao {
    Ready save(Ready worker);
    Ready get(String id);
    List<Ready> getall();
    Ready edit(Ready worker);
    Ready delete(String  id);
}
