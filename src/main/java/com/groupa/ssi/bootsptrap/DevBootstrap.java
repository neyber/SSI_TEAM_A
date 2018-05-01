/**
 * @author: Walker Colina
 */
package com.groupa.ssi.bootsptrap;


import com.groupa.ssi.model.domain.audit.Audit;
import com.groupa.ssi.model.domain.audit.SafetyRule;
import com.groupa.ssi.model.domain.catalog.SaClassification;
import com.groupa.ssi.model.domain.catalog.WorkItemClassification;
import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpe;
import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpeAssigned;
import com.groupa.ssi.model.domain.personalprotectionequipment.Ppe;
import com.groupa.ssi.model.domain.catalog.PpeClassification;
import com.groupa.ssi.model.domain.catalog.WorkItem;
import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.model.repository.audit.AuditRepository;
import com.groupa.ssi.model.repository.audit.SafetyRuleRepository;
import com.groupa.ssi.model.repository.catalog.PpeClassificationRepository;
import com.groupa.ssi.model.domain.accident.Accident;
import com.groupa.ssi.model.domain.personnel.Role;
import com.groupa.ssi.model.domain.usermanual.UserManual;
import com.groupa.ssi.model.domain.sickness.Sickness;
import com.groupa.ssi.model.repository.catalog.SaClassificationRepository;
import com.groupa.ssi.model.repository.catalog.WorkItemClassificationRepository;
import com.groupa.ssi.model.repository.personalprotectionequipment.ExistingPpeAssignedRepository;
import com.groupa.ssi.model.repository.personalprotectionequipment.ExistingPpeRepository;
import com.groupa.ssi.model.repository.personalprotectionequipment.PpeRepository;
import com.groupa.ssi.model.repository.sickness.SicknessRepository;
import com.groupa.ssi.model.repository.accident.AccidentRepository;
import com.groupa.ssi.model.repository.catalog.WorkItemRepository;
import com.groupa.ssi.model.repository.personnel.DepartmentRepository;
import com.groupa.ssi.model.repository.personnel.EmployeeRepository;
import com.groupa.ssi.model.repository.personnel.RoleRepository;
import com.groupa.ssi.model.repository.usermanual.UserManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private WorkItemRepository workItemRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private PpeClassificationRepository ppeClassificationRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UserManualRepository userManualRepository;
    @Autowired
    private AccidentRepository accidentRepository;
    @Autowired
    private SicknessRepository sicknessRepository;
    @Autowired
    private PpeRepository ppeRepository;
    @Autowired
    private ExistingPpeRepository existingPpeRepository;
    @Autowired
    private ExistingPpeAssignedRepository existingPpeAssignedRepository;
    @Autowired
    private AuditRepository auditRepository;
    @Autowired
    private SafetyRuleRepository safetyRuleRepository;
    @Autowired
    private SaClassificationRepository saClassificationRepository;
    @Autowired
    private WorkItemClassificationRepository workItemClassificationRepository;

    public DevBootstrap() {
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

        // Classification Personal protection equiment (classification Epp)
        PpeClassification skullProtection = new PpeClassification();
        skullProtection.setName("Protección de cráneo");
        skullProtection.setDescription("Son elementos que cubren totalmente el cráneo, protegiéndolo contra los" +
                "efectos de golpes, sustancias químicas, riesgos eléctricos y térmicos.");
        ppeClassificationRepository.save(skullProtection);

        // Personal protection equiment (Epp)
        Ppe headProtecction = new Ppe();
        headProtecction.setName("Casco");
        headProtecction.setDescription("Protege contra golpes en la cabeza.");
        headProtecction.setPpeClassification(skullProtection);
        ppeRepository.save(headProtecction);

        // Existing Personal protection equiment (Epp)
        ExistingPpe existingPpe = new ExistingPpe();
        existingPpe.setDetail("10101-CA");
        existingPpe.setLifeTimeDays(100);
        existingPpe.setCurrentLifeTimeDays(100);
        existingPpe.setPurchaseDate(new Date());
        existingPpe.setPpe(headProtecction);
        existingPpeRepository.save(existingPpe);

        //Roles
        Role consRole = new Role();
        consRole.setName("Constructor");
        consRole.setDescription("Constructor de obra");
        roleRepository.save(consRole);

        Role admRole = new Role();
        admRole.setName("Administrador de Personal");
        admRole.setDescription("Administrador de personal");
        roleRepository.save(admRole);


        //Sickness and Accident classification
        /*for accident*/
        SaClassification accidentClassification = new SaClassification();
        accidentClassification.setCategory("Trabajo restringido o transferido");
        accidentClassification.setTotalDaysOutOfWork(2);
        accidentClassification.setTotalDaysRestrictedTransferredWork(5);
        accidentClassification.setType("Condicion respiratoria");
        saClassificationRepository.save(accidentClassification);

        /*for sickness*/
        SaClassification sicknessClassification = new SaClassification();
        sicknessClassification.setCategory("Permanecio en el trabajo");
        sicknessClassification.setTotalDaysOutOfWork(3);
        sicknessClassification.setTotalDaysRestrictedTransferredWork(0);
        sicknessClassification.setType("Envenenamiento");
        saClassificationRepository.save(sicknessClassification);

        //Accident
        Accident accident = new Accident();
        accident.setDateAccident(new Date());
        accident.setDescription("this is a critical accident that will cost a lot to the enterprise");
        accident.setWhereOccurr("It occurred during the revision under maquinary");
        accident.setStatusRecord(Boolean.TRUE);
        accident.setSaClassification(accidentClassification);
        accidentRepository.save(accident);

        //Sickness
        Sickness sickness = new Sickness();
        sickness.setDateSickness(new Date());
        sickness.setDescription("during the night duty shift and with inadequate clothing is that the employee has a cold, and due to negligence");
        sickness.setWhereOccurr("this happened on guard night shift");
        sickness.setStatusRecord(Boolean.TRUE);
        sickness.setSaClassification(sicknessClassification);
        sicknessRepository.save(sickness);

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
        admEmployee.setHealthConditionStartingAtCompany("Uses wheel chair");
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
        constEmployee.setHealthConditionStartingAtCompany("Good health");
        employeeRepository.save(constEmployee);

        // Existing Personal protection equiment (Epp) assigned to employee
        ExistingPpeAssigned existingPpeAssigned = new ExistingPpeAssigned();
        existingPpeAssigned.setAssignedNotes("Asignado un casco en buen estado");
        existingPpeAssigned.setAssignedDate(new Date());
        existingPpeAssigned.setReturnNotes("");
        existingPpeAssigned.setExistingPpe(existingPpe);
        existingPpeAssigned.setEmployee(constEmployee);
        existingPpeAssignedRepository.save(existingPpeAssigned);

        // Audit register by employee
        Audit audit = new Audit();
        audit.setAuditName("Auditoria Test 1");
        audit.setAuditCode("AUD-INT-001");
        audit.setAuditType("INTERNA");
        audit.setAuditScope("Some scope");
        audit.setAuditCriteria("Some criteria");
        audit.setAuditObjective("Some objectives");
        audit.setEmployee(constEmployee);
        auditRepository.save(audit);

        // Classification work item
        WorkItemClassification manual = new WorkItemClassification();
        manual.setName("Herramienta manual");
        manual.setDescription("Son impulsados manualmente.");
        workItemClassificationRepository.save(manual);
    }
}