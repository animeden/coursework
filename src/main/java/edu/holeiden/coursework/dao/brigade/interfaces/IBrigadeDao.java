package edu.holeiden.coursework.dao.brigade.interfaces;

import edu.holeiden.coursework.model.Brigade;

import java.util.List;

public interface IBrigadeDao {
    Brigade save(Brigade brigade);
    Brigade get(String id);
    List<Brigade> getall();
    Brigade edit(Brigade brigade);
    Brigade delete(String  id);
}
