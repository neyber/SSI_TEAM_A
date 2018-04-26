/**
 * @author: Walker Colina
 */
package com.groupa.ssi.bootsptrap;

import com.groupa.ssi.model.domain.catalog.WorkItem;
import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.model.domain.personnel.Role;
import com.groupa.ssi.model.repository.catalog.WorkItemRepository;
import com.groupa.ssi.model.repository.personnel.DepartmentRepository;
import com.groupa.ssi.model.repository.personnel.EmployeeRepository;
import com.groupa.ssi.model.repository.personnel.RoleRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private WorkItemRepository workItemRepository;
    private DepartmentRepository departmentRepository;
    private RoleRepository roleRepository;
    private EmployeeRepository employeeRepository;

    public DevBootstrap(WorkItemRepository workItemRepository, DepartmentRepository departmentRepository, RoleRepository roleRepository, EmployeeRepository employeeRepository) {
        this.workItemRepository = workItemRepository;
        this.departmentRepository = departmentRepository;
        this.roleRepository = roleRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
        initData();
    }

    private void initData() {
        // WorkItem
        WorkItem workItem = new WorkItem();
        workItem.setName("Casco");
        workItem.setDescription("Casco de seguridad");
        workItemRepository.save(workItem);

        //Departments
        Department constDepartment = new Department();
        constDepartment.setName("Construccion");
        constDepartment.setDescription("Departamento de trabajo de construccion y obras");
        departmentRepository.save(constDepartment);

        Department admDepartment = new Department();
        admDepartment.setName("Administracion");
        admDepartment.setDescription("Departamento de Administracion");
        departmentRepository.save(admDepartment);

        //Roles
        Role consRole = new Role();
        consRole.setName("Constructor");
        consRole.setDescription("Constructor de obra");
        roleRepository.save(consRole);

        Role admRole = new Role();
        admRole.setName("Administrador de Personal");
        admRole.setDescription("Administrador de personal");
        roleRepository.save(admRole);

        //Employees
        Employee admEmployee = new Employee();
        admEmployee.setIdentificationNumber(new Long(234234));
        admEmployee.setFirstName("Maria");
        admEmployee.setLastName("Lopez");
        admEmployee.setDateOfBirth(new Date(1975,05,05));
        admEmployee.setGender('F');
        admEmployee.setStartDateInCompany(new Date(2012,02,02));
        admEmployee.setRoleEmployee(admRole);
        admEmployee.setDepartmentEmployee(admDepartment);
        admEmployee.setHealthConditions("Uses wheel chair");
        employeeRepository.save(admEmployee);

        Employee constEmployee = new Employee();
        constEmployee.setIdentificationNumber(new Long(123123));
        constEmployee.setFirstName("Juan");
        constEmployee.setLastName("Perez");
        constEmployee.setDateOfBirth(new Date(1980,01,01));
        constEmployee.setGender('M');
        constEmployee.setStartDateInCompany(new Date(2015,01,01));
        constEmployee.setRoleEmployee(consRole);
        constEmployee.setSupervisor(admEmployee);
        constEmployee.setDepartmentEmployee(constDepartment);
        constEmployee.setHealthConditions("Good health");
        employeeRepository.save(constEmployee);



    }

}
