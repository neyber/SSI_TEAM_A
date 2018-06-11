package com.groupa.ssi.model.repository.personnel;

import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.model.repository.storedprocedures.personnel.DepartmentRepositoryProcedure;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lizeth Salazar
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer>, DepartmentRepositoryProcedure {

}
