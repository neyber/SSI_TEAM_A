/**
 * @author: Walker Colina
 */
package com.groupa.ssi.bootsptrap;

import com.groupa.ssi.model.domain.catalog.WorkItem;
import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.model.domain.personnel.Role;
import com.groupa.ssi.model.domain.usermanual.UserManual;
import com.groupa.ssi.model.repository.catalog.WorkItemRepository;
import com.groupa.ssi.model.repository.personnel.DepartmentRepository;
import com.groupa.ssi.model.repository.personnel.RoleRepository;
import com.groupa.ssi.model.repository.usermanual.UserManualRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private WorkItemRepository workItemRepository;
    private DepartmentRepository departmentRepository;
    private RoleRepository roleRepository;
    private UserManualRepository userManualRepository;

    public DevBootstrap(WorkItemRepository workItemRepository, DepartmentRepository departmentRepository, RoleRepository roleRepository, UserManualRepository userManualRepository) {
        this.workItemRepository = workItemRepository;
        this.departmentRepository = departmentRepository;
        this.roleRepository = roleRepository;
        this.userManualRepository = userManualRepository;

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

        //UserManual
        UserManual constUserManual = new UserManual();
        constUserManual.setName("Manual de seguridad1");
        constUserManual.setPosition("Jefe de piso");
        constUserManual.setHierarchicalLever("administrador");
        constUserManual.setSuperiorBoss("gerente");
        constUserManual.setDependentPersonal("empleados de planta");
        constUserManual.setInternalRelation("relacion con gerencia");
        constUserManual.setExternalRelation("relacion con el exterior");
        constUserManual.setActivity("seguridad de planta");
        constUserManual.setGeneralActivity("general activity");
        constUserManual.setPrincipalFunction("seguridad de la empresa");
        userManualRepository.save(constUserManual);

    }

}
