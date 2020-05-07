package edu.holeiden.coursework.dao.timetable.interfaces;

import edu.holeiden.coursework.model.Timetable;

import java.util.List;

public interface ITimetableDao {
    Timetable save(Timetable timetable);
    Timetable get(String id);
    List<Timetable> getall();
    Timetable edit(Timetable timetable);
    Timetable delete(String  id);
}
