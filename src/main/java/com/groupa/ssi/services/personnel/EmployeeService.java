package com.groupa.ssi.services.personnel;

import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.model.repository.personnel.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lizeth Salazar
 */

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll(){
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public Employee findById(Integer employeeId){
        return employeeRepository.findById(employeeId).orElseThrow(() -> new DomainEntityNotFoundException(Employee.class));
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteById(Integer employeeId){
        employeeRepository.deleteById(employeeId);
    }
}
