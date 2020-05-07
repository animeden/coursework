package edu.holeiden.coursework.dao.route.impls;

import edu.holeiden.coursework.dao.route.interfaces.IRouteDao;
import edu.holeiden.coursework.dataSet.DataSet;
import edu.holeiden.coursework.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteDaoImplFake implements IRouteDao {
    @Autowired
    DataSet dataSet;

    @Override
    public Route save(Route route) {
        return null;
    }

    @Override
    public Route get(String id) {
        return null;
    }

    @Override
    public List<Route> getall() {
        return dataSet.getRoutes();
    }

    @Override
    public Route edit(Route route) {
        return null;
    }

    @Override
    public Route delete(String id) {
        return null;
    }
}
