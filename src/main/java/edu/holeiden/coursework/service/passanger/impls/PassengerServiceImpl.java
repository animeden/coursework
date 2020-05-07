package edu.holeiden.coursework.service.passanger.impls;

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
    PassengerRepository repository;

    @PostConstruct
    void init(){

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
        return repository.findAll();
    }

    @Override
    public Passenger edit(Passenger passenger) {
        return null;
    }

    @Override
    public Passenger delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
