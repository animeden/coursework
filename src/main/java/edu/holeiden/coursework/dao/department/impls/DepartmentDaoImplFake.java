package edu.holeiden.coursework.dao.department.impls;

import edu.holeiden.coursework.dao.department.interfaces.IDepartmentDao;
import edu.holeiden.coursework.dataSet.DataSet;
import edu.holeiden.coursework.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentDaoImplFake implements IDepartmentDao {
    @Autowired
    DataSet dataSet;

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
        return dataSet.getDepartments();
    }

    @Override
    public Department edit(Department department) {
        return null;
    }

    @Override
    public Department delete(String id) {
        return null;
    }
}
