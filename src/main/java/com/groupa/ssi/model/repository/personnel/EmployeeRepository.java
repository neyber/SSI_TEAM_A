package com.groupa.ssi.model.repository.personnel;

import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.model.repository.storedprocedures.personnel.EmployeeRepositoryProcedure;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lizeth Salazar
 */

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, EmployeeRepositoryProcedure {
}
