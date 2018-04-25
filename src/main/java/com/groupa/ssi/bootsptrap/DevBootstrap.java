/**
 * @author: Walker Colina
 */
package com.groupa.ssi.bootsptrap;

//import com.dh.spring5webapp.model.*;
//import com.dh.spring5webapp.repositories.*;
import com.groupa.ssi.model.domain.catalog.WorkItem;
import com.groupa.ssi.model.repository.catalog.WorkItemRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private WorkItemRepository workItemRepository;
    /*private SubCategoryRepository subCategoryRepository;
    private ItemRepository itemRepository;
    private EmployeeRepository employeeRepository;
    private PositionRepository positionRepository;
    private ContractRepository contractRepository;*/

    public DevBootstrap(WorkItemRepository workItemRepository) {
        this.workItemRepository = workItemRepository;
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
    }
}
