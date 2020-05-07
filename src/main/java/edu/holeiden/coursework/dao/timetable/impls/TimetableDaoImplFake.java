package edu.holeiden.coursework.dao.timetable.impls;

import edu.holeiden.coursework.dao.timetable.interfaces.ITimetableDao;
import edu.holeiden.coursework.dataSet.DataSet;
import edu.holeiden.coursework.model.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimetableDaoImplFake implements ITimetableDao {
    @Autowired
    DataSet dataSet;

    @Override
    public Timetable save(Timetable timetable) {
        return null;
    }

    @Override
    public Timetable get(String id) {
        return null;
    }

    @Override
    public List<Timetable> getall() {
        return dataSet.getTimetables();
    }

    @Override
    public Timetable edit(Timetable timetable) {
        return null;
    }

    @Override
    public Timetable delete(String id) {
        return null;
    }
}
