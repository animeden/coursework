package edu.holeiden.coursework.service.passanger.impls;

import edu.holeiden.coursework.dao.repository.PassengerRepository;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.model.Passenger;
import edu.holeiden.coursework.service.passanger.interfaces.IPassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
        passenger.setCreate(LocalDateTime.now());
        passenger.setModified(LocalDateTime.now());
        return repository.save(passenger);
    }

    @Override
    public Passenger get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Passenger> getall() {
        return repository.findAll();
    }

    @Override
    public Passenger edit(Passenger passenger) {
        passenger.setModified(LocalDateTime.now());
        return repository.save(passenger);
    }

    @Override
    public Passenger delete(String id) {
        Passenger passenger = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return passenger;
    }

    public List<Passenger> search(String word){
        List<Passenger> list = this.getall().stream()
                .filter(passenger -> passenger.getId().contains(word))
                .collect(Collectors.toList());
        return list;
    }
}
