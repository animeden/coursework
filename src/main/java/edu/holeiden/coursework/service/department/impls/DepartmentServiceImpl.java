package edu.holeiden.coursework.service.department.impls;

import edu.holeiden.coursework.dao.repository.DepartmentRepository;
import edu.holeiden.coursework.model.Administration;
import edu.holeiden.coursework.model.Department;
import edu.holeiden.coursework.service.administration.impls.AdministrationServiceImpl;
import edu.holeiden.coursework.service.department.interfaces.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    DepartmentRepository repository;

    @PostConstruct
    void init(){

        //repository.saveAll(list);

    }

    @Override
    public Department save(Department department) {
        department.setCreate(LocalDateTime.now());
        department.setModified(LocalDateTime.now());
        return repository.save(department);
    }

    @Override
    public Department get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Department> getall() {
        return repository.findAll();
    }

    @Override
    public Department edit(Department department) {
        department.setModified(LocalDateTime.now());
        return repository.save(department);
    }

    @Override
    public Department delete(String id) {
        Department department = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return department;
    }

    public List<Department> search(String word){
        List<Department> list = this.getall().stream()
                .filter(department -> department.getName().contains(word))
                .collect(Collectors.toList());
        return list;
    }

    public List<Department> sortByName(List<Department> people){

        Collections.sort(people, new DepartmentComparator());

        return people;
    }

    private class DepartmentComparator implements Comparator<Department> {
        public int compare(Department p1, Department p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }
}
