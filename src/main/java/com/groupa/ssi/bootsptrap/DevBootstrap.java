/**
 * @author: Walker Colina
 */
package com.groupa.ssi.bootsptrap;

import com.groupa.ssi.model.domain.catalog.PpeClassification;
import com.groupa.ssi.model.domain.catalog.WorkItem;
import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.model.repository.catalog.PpeClassificationRepository;
import com.groupa.ssi.model.repository.catalog.WorkItemRepository;
import com.groupa.ssi.model.repository.personnel.DepartmentRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private WorkItemRepository workItemRepository;
    private DepartmentRepository departmentRepository;
    private PpeClassificationRepository ppeClassificationRepository;

    public DevBootstrap(WorkItemRepository workItemRepository, DepartmentRepository departmentRepository,
                        PpeClassificationRepository ppeClassificationRepository) {
        this.workItemRepository = workItemRepository;
        this.departmentRepository = departmentRepository;
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

        //Department
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
    }

}
