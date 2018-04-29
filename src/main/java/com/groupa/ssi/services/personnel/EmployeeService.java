package com.groupa.ssi.services.personnel;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.model.repository.personnel.EmployeeRepository;
import com.groupa.ssi.services.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lizeth Salazar
 */

@Service
public class EmployeeService extends GenericService<Employee> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    protected JpaRepository<Employee, Integer> getRepository() {return employeeRepository;}
}
