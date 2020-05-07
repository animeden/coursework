package edu.holeiden.coursework.dao.administration.interfaces;

import edu.holeiden.coursework.model.Administration;

import java.util.List;

public interface IAdministrationDao {
    Administration save(Administration administration);
    Administration get(String id);
    List<Administration> getall();
    Administration edit(Administration administration);
    Administration delete(String  id);
}
