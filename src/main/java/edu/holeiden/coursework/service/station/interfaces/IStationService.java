package edu.holeiden.coursework.service.station.interfaces;

import edu.holeiden.coursework.model.Station;

import java.util.List;

public interface IStationService {
    Station save(Station station);
    Station get(String id);
    List<Station> getall();
    Station edit(Station station);
    Station delete(String  id);
}
