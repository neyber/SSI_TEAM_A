/**
 * @author: Walker Colina
 */
package com.groupa.ssi.bootsptrap;


import com.groupa.ssi.model.domain.catalog.PpeClassification;
import com.groupa.ssi.model.domain.catalog.WorkItem;
import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.model.repository.catalog.PpeClassificationRepository;
import com.groupa.ssi.model.domain.accident.Accident;
import com.groupa.ssi.model.domain.personnel.Role;
import com.groupa.ssi.model.domain.sickness.Sickness;
import com.groupa.ssi.model.repository.sickness.SicknessRepository;
import com.groupa.ssi.model.repository.accident.AccidentRepository;
import com.groupa.ssi.model.repository.catalog.WorkItemRepository;
import com.groupa.ssi.model.repository.personnel.DepartmentRepository;
import com.groupa.ssi.model.repository.personnel.RoleRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private WorkItemRepository workItemRepository;
    private DepartmentRepository departmentRepository;
    private PpeClassificationRepository ppeClassificationRepository;
    private RoleRepository roleRepository;
    private AccidentRepository accidentRepository;
    private SicknessRepository sicknessRepository;

    public DevBootstrap(WorkItemRepository workItemRepository, DepartmentRepository departmentRepository, RoleRepository roleRepository, AccidentRepository accidentRepository, SicknessRepository sicknessRepository,
                PpeClassificationRepository ppeClassificationRepository) {
            this.workItemRepository = workItemRepository;
            this.departmentRepository = departmentRepository;
            this.roleRepository = roleRepository;
            this.accidentRepository = accidentRepository;
            this.sicknessRepository = sicknessRepository;
            this.ppeClassificationRepository = ppeClassificationRepository;
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

            // Personal protection equiment (Epp)
            PpeClassification skullProtection = new PpeClassification();
            skullProtection.setName("Protección de cráneo");
            skullProtection.setDescription("Son elementos que cubren totalmente el cráneo, protegiéndolo contra los" +
                    "efectos de golpes, sustancias químicas, riesgos eléctricos y térmicos.");
            ppeClassificationRepository.save(skullProtection);

            //Roles
            Role consRole = new Role();
            consRole.setName("Constructor");
            consRole.setDescription("Constructor de obra");
            roleRepository.save(consRole);

            Role admRole = new Role();
            admRole.setName("Administrador de Personal");
            admRole.setDescription("Administrador de personal");
            roleRepository.save(admRole);

            //Accident

            Accident accident = new Accident();
            accident.setDateAccident(new Date());
            accident.setDescription("this is a critical accident that will cost a lot to the enterprise");
            accident.setWhereOccurr("It occurred during the revision under maquinary");
            accidentRepository.save(accident);

            //Sickness
            Sickness sickness = new Sickness();
            sickness.setDateSickness(new Date());
            sickness.setDescription("during the night duty shift and with inadequate clothing is that the employee has a cold, and due to negligence");
            sickness.setWhereOccurr("this happened on guard night shift");
            sicknessRepository.save(sickness);

        }

    }
