package edu.holeiden.coursework.service.route.impls;

import edu.holeiden.coursework.dao.repository.RouteRepository;
import edu.holeiden.coursework.model.Route;
import edu.holeiden.coursework.service.route.interfaces.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

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
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
