/**
 * @author: Walker Colina
 */
package com.groupa.ssi.bootsptrap;


import com.groupa.ssi.common.constant.EnumSaCategory;
import com.groupa.ssi.common.constant.EnumSaType;
import com.groupa.ssi.model.domain.audit.Audit;
import com.groupa.ssi.model.domain.saClassification.SaCategory;
import com.groupa.ssi.model.domain.saClassification.SaClassification;
import com.groupa.ssi.model.domain.catalog.WorkItemClassification;
import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpe;
import com.groupa.ssi.model.domain.personalprotectionequipment.ExistingPpeAssigned;
import com.groupa.ssi.model.domain.personalprotectionequipment.Ppe;
import com.groupa.ssi.model.domain.catalog.PpeClassification;
import com.groupa.ssi.model.domain.saClassification.SaType;
import com.groupa.ssi.model.domain.workitem.ExistingWorkItem;
import com.groupa.ssi.model.domain.workitem.ExistingWorkItemAssigned;
import com.groupa.ssi.model.domain.workitem.WorkItem;
import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.model.repository.audit.AuditRepository;
import com.groupa.ssi.model.repository.audit.SafetyRuleRepository;
import com.groupa.ssi.model.repository.catalog.PpeClassificationRepository;
import com.groupa.ssi.model.domain.accident.Accident;
import com.groupa.ssi.model.domain.personnel.Role;
import com.groupa.ssi.model.domain.functionmanual.FunctionManual;
import com.groupa.ssi.model.domain.sickness.Sickness;
import com.groupa.ssi.model.repository.catalog.SaClassificationRepository;
import com.groupa.ssi.model.repository.catalog.WorkItemClassificationRepository;
import com.groupa.ssi.model.repository.personalprotectionequipment.ExistingPpeAssignedRepository;
import com.groupa.ssi.model.repository.personalprotectionequipment.ExistingPpeRepository;
import com.groupa.ssi.model.repository.personalprotectionequipment.PpeRepository;
import com.groupa.ssi.model.repository.saclassification.SaCategoryRepository;
import com.groupa.ssi.model.repository.saclassification.SaTypeRepository;
import com.groupa.ssi.model.repository.sickness.SicknessRepository;
import com.groupa.ssi.model.repository.accident.AccidentRepository;
import com.groupa.ssi.model.repository.workitem.ExistingWorkItemAssignedRepository;
import com.groupa.ssi.model.repository.workitem.ExistingWorkItemRepository;
import com.groupa.ssi.model.repository.workitem.WorkItemRepository;
import com.groupa.ssi.model.repository.personnel.DepartmentRepository;
import com.groupa.ssi.model.repository.personnel.EmployeeRepository;
import com.groupa.ssi.model.repository.personnel.RoleRepository;
import com.groupa.ssi.model.repository.functionmanual.FunctionManualRepository;
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
    private FunctionManualRepository functionManualRepository;
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
    @Autowired
    private ExistingWorkItemRepository existingWorkItemRepository;
    @Autowired
    private ExistingWorkItemAssignedRepository existingWorkItemAssignedRepository;
    @Autowired
    private SaCategoryRepository saCategoryRepository;
    @Autowired
    private SaTypeRepository saTypeRepository;

    public DevBootstrap() {
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
        initData();
    }

    private void initData() {
        // Classification work item
        WorkItemClassification manualWorkItem = new WorkItemClassification();
        manualWorkItem.setName("Herramienta manual");
        manualWorkItem.setDescription("Son impulsados manualmente.");
        workItemClassificationRepository.save(manualWorkItem);

        // WorkItem
        WorkItem workItem = new WorkItem();
        workItem.setName("Casco");
        workItem.setDescription("Casco de seguridad");
        workItem.setWorkItemClassification(manualWorkItem);
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

        // Existing work item
        ExistingWorkItem existingWorkItem = new ExistingWorkItem();
        existingWorkItem.setDetail("Adicionando stock de moledora");
        existingWorkItem.setPurchaseDate(new Date());
        existingWorkItem.setSerieNo("111-CA");
        existingWorkItem.setWorkItem(workItem);
        existingWorkItemRepository.save(existingWorkItem);

        //FunctionManual
        FunctionManual constFunctionManual = new FunctionManual();
        constFunctionManual.setName("administrador 1");
        constFunctionManual.setPosition("Jefe de piso");
        constFunctionManual.setHierarchicalLever("administrador");
        constFunctionManual.setSuperiorBoss("gerente");
        constFunctionManual.setDependentPersonal("empleados de planta");
        constFunctionManual.setInternalRelation("relacion con gerencia");
        constFunctionManual.setExternalRelation("relacion con el exterior");
        constFunctionManual.setGeneralActivity("general activity");
        constFunctionManual.setPrincipalFunction("seguridad de la empresa");
        constFunctionManual.setRoleFunction(consRole);
        functionManualRepository.save(constFunctionManual);

        //Sickness and Accident classification
        /*for accident*/
        SaCategory accidentCategory = new com.groupa.ssi.model.domain.saClassification.SaCategory();
        accidentCategory.setCategory(EnumSaCategory.DAYS_OUT_OF_WORK.getCode());
        accidentCategory.setDescription("this category is follow the OSHA documentation");
        accidentCategory.setReference("Formulario OSHA - 300");
        saCategoryRepository.save(accidentCategory);

        SaType saType = new SaType();
        saType.setType(EnumSaType.INJURY.getCode());
        saType.setDescription("this type was includes by osha rules normative");
        saTypeRepository.save(saType);

        SaCategory accidentCategory2 = new com.groupa.ssi.model.domain.saClassification.SaCategory();
        accidentCategory2.setCategory(EnumSaCategory.RESTRICTED_TRANSFERRED_WORK.getCode());
        accidentCategory2.setDescription("this category is follow the OSHA documentation");
        accidentCategory2.setReference("Formulario OSHA - 300");
        saCategoryRepository.save(accidentCategory2);

        SaType saType2 = new SaType();
        saType2.setType(EnumSaType.INJURY.getCode());
        saType2.setDescription("this type was includes by osha rules normative");
        saTypeRepository.save(saType2);

        /*for sickness*/
        SaCategory sicknessCategory = new com.groupa.ssi.model.domain.saClassification.SaCategory();
        sicknessCategory.setCategory(EnumSaCategory.OTHER_RECORDABLE_CASES.getCode());
        sicknessCategory.setDescription("this category is follow the OSHA documentation");
        sicknessCategory.setReference(null);
        saCategoryRepository.save(sicknessCategory);

        SaType sicknessSaType = new SaType();
        sicknessSaType.setType(EnumSaType.POISONING.getCode());
        sicknessSaType.setDescription("this type was includes by osha rules normative");
        saTypeRepository.save(sicknessSaType);

        SaCategory sicknessCategory2 = new com.groupa.ssi.model.domain.saClassification.SaCategory();
        sicknessCategory2.setCategory(EnumSaCategory.REMAINED_AT_WORK.getCode());
        sicknessCategory2.setDescription("this category is follow the OSHA documentation");
        sicknessCategory2.setReference("Formulario OSHA - 300");
        saCategoryRepository.save(sicknessCategory2);

        SaType sicknessSaType2 = new SaType();
        sicknessSaType2.setType(EnumSaType.SKIN_DISORDER.getCode());
        sicknessSaType2.setDescription("this type was includes by osha rules normative");
        saTypeRepository.save(sicknessSaType2);


        //Accident
        Accident accident = new Accident();
        accident.setDateAccident(new Date());
        accident.setDescription("this is a critical accident that will cost a lot to the enterprise");
        accident.setWhereOccurr("It occurred during the revision under maquinary");
        accident.setStatusRecord(Boolean.TRUE);
        accident.setTotalDaysOutOfWork(2);
        accident.setTotalDaysRestrictedTransferredWork(0);
        accident.setSaCategory(accidentCategory);
        accident.setSaType(saType);
        accident.setEmployee(constEmployee);
        accidentRepository.save(accident);


        Accident accident2 = new Accident();
        accident2.setDateAccident(new Date());
        accident2.setDescription("el accidente occurrio cuando el admin no estaba sando proteccion");
        accident2.setWhereOccurr("It occurred during the revision under maquinary");
        accident2.setStatusRecord(Boolean.TRUE);
        accident2.setTotalDaysOutOfWork(0);
        accident2.setTotalDaysRestrictedTransferredWork(5);
        accident2.setSaCategory(accidentCategory2);
        accident2.setSaType(saType2);
        accident2.setEmployee(admEmployee);
        accidentRepository.save(accident2);

        //Sickness
        Sickness sickness = new Sickness();
        sickness.setDateSickness(new Date());
        sickness.setDescription("during the night duty shift and with inadequate clothing is that the employee has a cold, and due to negligence");
        sickness.setWhereOccurr("this happened on guard night shift");
        sickness.setStatusRecord(Boolean.TRUE);
        sickness.setTotalDaysOutOfWork(3);
        sickness.setTotalDaysRestrictedTransferredWork(5);
        sickness.setSaCategory(sicknessCategory);
        sickness.setSaType(sicknessSaType);
        sickness.setEmployee(admEmployee);
        sicknessRepository.save(sickness);

        Sickness sicknessAdmin = new Sickness();
        sicknessAdmin.setDateSickness(new Date());
        sicknessAdmin.setDescription("problema de salud por la noche, duranto turno de guardia");
        sicknessAdmin.setWhereOccurr("en la empresa");
        sicknessAdmin.setStatusRecord(Boolean.TRUE);
        sicknessAdmin.setTotalDaysOutOfWork(2);
        sicknessAdmin.setTotalDaysRestrictedTransferredWork(8);
        sicknessAdmin.setSaCategory(sicknessCategory2);
        sicknessAdmin.setSaType(sicknessSaType2);
        sicknessAdmin.setEmployee(constEmployee);
        sicknessRepository.save(sicknessAdmin);

        ExistingWorkItemAssigned existingWorkItemAssigned = new ExistingWorkItemAssigned();
        existingWorkItemAssigned.setAssignedNotes("Asignado una moledora en buen estado");
        existingWorkItemAssigned.setAssignedDate(new Date());
        existingWorkItemAssigned.setReturnNotes("");
        existingWorkItemAssigned.setExistingWorkItem(existingWorkItem);
        existingWorkItemAssigned.setEmployee(constEmployee);
        existingWorkItemAssignedRepository.save(existingWorkItemAssigned);

    }
}