package edu.holeiden.coursework.service.department.interfaces;

import edu.holeiden.coursework.model.Department;

import java.util.List;

public interface IDepartmentService {
    Department save(Department department);
    Department get(String id);
    List<Department> getall();
    Department edit(Department department);
    Department delete(String  id);
}
