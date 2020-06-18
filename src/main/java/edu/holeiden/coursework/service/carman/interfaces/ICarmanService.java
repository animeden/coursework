package edu.holeiden.coursework.service.carman.interfaces;

import edu.holeiden.coursework.model.Carman;

import java.util.List;

public interface ICarmanService {
    Carman save(Carman carman);
    Carman get(String id);
    List<Carman> getall();
    Carman edit(Carman carman);
    Carman delete(String  id);
}
