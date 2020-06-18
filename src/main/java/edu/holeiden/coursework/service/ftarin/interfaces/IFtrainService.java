package edu.holeiden.coursework.service.ftarin.interfaces;

import edu.holeiden.coursework.model.Ftrains;

import java.util.List;

public interface IFtrainService {
    Ftrains save(Ftrains ftrains);
    Ftrains get(String id);
    List<Ftrains> getall();
    Ftrains edit(Ftrains ftrains);
    Ftrains delete(String  id);
}
