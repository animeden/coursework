package edu.holeiden.coursework.service.passanger.impls;

import edu.holeiden.coursework.dao.passenger.impls.PassengerDaoImplFake;
import edu.holeiden.coursework.dao.repository.PassengerRepository;
import edu.holeiden.coursework.model.Passenger;
import edu.holeiden.coursework.service.passanger.interfaces.IPassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PassengerServiceImpl implements IPassengerService {
    @Autowired
    PassengerDaoImplFake dao;

    @PostConstruct
    void init(){

        List<Passenger> list = dao.getall();

        //repository.saveAll(list);

    }

    @Override
    public Passenger save(Passenger passenger) {
        return null;
    }

    @Override
    public Passenger get(String id) {
        return null;
    }

    @Override
    public List<Passenger> getall() {
        return dao.getall();
    }

    @Override
    public Passenger edit(Passenger passenger) {
        return null;
    }

    @Override
    public Passenger delete(String id) {
        return null;
    }
}
