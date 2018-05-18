package com.groupa.ssi.cmd.audit;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.model.domain.audit.Audit;
import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.request.audit.AuditRequest;
import com.groupa.ssi.services.audit.AuditService;
import com.groupa.ssi.services.personnel.DepartmentService;
import com.groupa.ssi.services.personnel.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Neyber Rojas Zapata
 */
@CommandScoped
public class AuditCreateCmd extends AbstractCommand {

    private AuditRequest auditRequest;

    @Autowired
    private AuditService auditService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @Override
    protected void run() {
        Employee employee = null;
        Department department = null;

        if (auditRequest.getEmployeeId() != null) {
            employee = employeeService.findById(auditRequest.getEmployeeId());
        }
        if (auditRequest.getDepartmentId() != null) {
            department = departmentService.findById(auditRequest.getDepartmentId());
        }

        Audit audit = ComposeAudit(auditRequest, employee, department);
        auditService.save(audit);
    }

    private Audit ComposeAudit(AuditRequest auditRequest,  Employee employee, Department department) {
        Audit audit = new Audit();
        audit.setAuditName(auditRequest.getAuditName());
        audit.setAuditCode(auditRequest.getAuditCode());
        audit.setAuditType(auditRequest.getAuditType());
        audit.setAuditScope(auditRequest.getAuditScope());
        audit.setAuditCriteria(auditRequest.getAuditCriteria());
        audit.setAuditObjective(auditRequest.getAuditObjective());
        audit.setPeriodicity(auditRequest.getPeriodicity());
        audit.setEmployee(employee);
        audit.setDepartment(department);

        return audit;
    }

    public void setAuditRequest(AuditRequest auditRequest) {
        this.auditRequest = auditRequest;
    }
}
