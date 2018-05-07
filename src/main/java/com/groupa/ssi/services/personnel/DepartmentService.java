package com.groupa.ssi.services.personnel;

import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.model.repository.personnel.DepartmentRepository;
import com.groupa.ssi.services.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author Lizeth Salazar
 */

@Service
public class DepartmentService extends GenericService<Department> {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    protected JpaRepository<Department, Integer> getRepository() {return departmentRepository;}

}
