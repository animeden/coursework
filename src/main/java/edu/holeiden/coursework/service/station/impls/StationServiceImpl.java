package edu.holeiden.coursework.service.station.impls;

import edu.holeiden.coursework.dao.repository.StationRepository;
import edu.holeiden.coursework.model.Station;
import edu.holeiden.coursework.service.station.interfaces.IStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationServiceImpl implements IStationService {
    @Autowired
    StationRepository repository;

    @PostConstruct
    void init(){

        //repository.saveAll(list);

    }

    @Override
    public Station save(Station station) {
        station.setCreate(LocalDateTime.now());
        station.setModified(LocalDateTime.now());
        return repository.save(station);
    }

    @Override
    public Station get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Station> getall() {
        return repository.findAll();
    }

    @Override
    public Station edit(Station station) {
        station.setModified(LocalDateTime.now());
        return repository.save(station);
    }

    @Override
    public Station delete(String id) {
        Station station = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return station;
    }

    public List<Station> search(String word){
        List<Station> list = this.getall().stream()
                .filter(station -> station.getName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
        return list;
    }

    public List<Station> sortByName(List<Station> people){

        Collections.sort(people, new StationComparator());

        return people;
    }

    private class StationComparator implements Comparator<Station> {
        public int compare(Station p1, Station p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }
}
