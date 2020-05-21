package edu.holeiden.coursework.service.route.impls;

import edu.holeiden.coursework.dao.repository.RouteRepository;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.model.Route;
import edu.holeiden.coursework.service.administration.impls.AdministrationServiceImpl;
import edu.holeiden.coursework.service.route.interfaces.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements IRouteService {

    @Autowired
    RouteRepository repository;

    @PostConstruct
    void init(){

        //repository.saveAll(list);

    }

    @Override
    public Route save(Route route) {
        route.setCreate(LocalDateTime.now());
        route.setModified(LocalDateTime.now());
        return repository.save(route);
    }

    @Override
    public Route get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Route> getall() {
        return repository.findAll();
    }

    @Override
    public Route edit(Route route) {
        route.setModified(LocalDateTime.now());
        return repository.save(route);
    }

    @Override
    public Route delete(String id) {
        Route route = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return route;
    }

    public List<Route> search(String word){
        List<Route> list = this.getall().stream()
                .filter(route -> route.getStations().contains(word))
                .collect(Collectors.toList());
        return list;
    }

    public List<Route> sortByName(List<Route> people){

        Collections.sort(people, new RouteComparator());

        return people;
    }

    private class RouteComparator implements Comparator<Route> {
        public int compare(Route p1, Route p2) {
            return p1.getStart().compareTo(p2.getStart());
        }
    }
}
