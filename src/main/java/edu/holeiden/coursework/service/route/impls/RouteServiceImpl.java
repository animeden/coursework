package edu.holeiden.coursework.service.route.impls;

import edu.holeiden.coursework.dao.repository.RouteRepository;
import edu.holeiden.coursework.dao.route.impls.RouteDaoImplFake;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.model.Route;
import edu.holeiden.coursework.service.route.interfaces.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class RouteServiceImpl implements IRouteService {
    @Autowired
    RouteDaoImplFake dao;

    @PostConstruct
    void init(){

        List<Route> list = dao.getall();

        //repository.saveAll(list);

    }

    @Override
    public Route save(Route route) {
        return null;
    }

    @Override
    public Route get(String id) {
        return dao.getall().stream().filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Route> getall() {
        return dao.getall();
    }

    @Override
    public Route edit(Route route) {
        return null;
    }

    @Override
    public Route delete(String id) {
        Route route = this.get(id);
        dao.getall().remove(route);
        return route;
    }
}
