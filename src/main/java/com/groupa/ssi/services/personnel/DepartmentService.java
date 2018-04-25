package com.groupa.ssi.services.personnel;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.catalog.WorkItem;
import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.model.repository.personnel.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lizeth Salazar
 */

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAll(){
        List<Department> departments = new ArrayList();
        departmentRepository.findAll().forEach(departments::add);
        return departments;
    }

    public Department findById(Integer departmentId){
        return departmentRepository.findById(departmentId).orElseThrow(() -> new DomainEntityNotFoundException(Department.class));
    }

    public Department save(Department department){
        return departmentRepository.save(department);
    }

    public void deleteById(Integer departmentId){
        departmentRepository.deleteById(departmentId);
    }
}
