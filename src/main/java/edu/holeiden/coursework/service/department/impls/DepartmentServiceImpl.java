package edu.holeiden.coursework.service.department.impls;

import edu.holeiden.coursework.dao.department.impls.DepartmentDaoImplFake;
import edu.holeiden.coursework.dao.repository.DepartmentRepository;
import edu.holeiden.coursework.model.Department;
import edu.holeiden.coursework.service.department.interfaces.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    DepartmentDaoImplFake dao;

    @Autowired
    DepartmentRepository repository;

    @PostConstruct
    void init(){

        List<Department> list = dao.getall();

        //repository.saveAll(list);

    }

    @Override
    public Department save(Department department) {
        return null;
    }

    @Override
    public Department get(String id) {
        return null;
    }

    @Override
    public List<Department> getall() {
        return repository.findAll();
    }

    @Override
    public Department edit(Department department) {
        return null;
    }

    @Override
    public Department delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
