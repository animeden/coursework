package edu.holeiden.coursework.service.route.interfaces;

import edu.holeiden.coursework.model.Route;

import java.util.List;

public interface IRouteService {
    Route save(Route route);
    Route get(String id);
    List<Route> getall();
    Route edit(Route route);
    Route delete(String  id);
}
