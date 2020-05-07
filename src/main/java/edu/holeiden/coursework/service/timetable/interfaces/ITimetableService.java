package edu.holeiden.coursework.service.timetable.interfaces;

import edu.holeiden.coursework.model.Timetable;

import java.util.List;

public interface ITimetableService {
    Timetable save(Timetable timetable);
    Timetable get(String id);
    List<Timetable> getall();
    Timetable edit(Timetable timetable);
    Timetable delete(String  id);
}
