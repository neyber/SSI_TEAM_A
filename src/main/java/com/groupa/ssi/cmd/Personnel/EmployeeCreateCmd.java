package com.groupa.ssi.cmd.Personnel;

import com.groupa.ssi.common.cmd.AbstractCommand;
import com.groupa.ssi.common.context.CommandScoped;
import com.groupa.ssi.controller.common.FileDocumentDownloadController;
import com.groupa.ssi.model.domain.common.FileDocument;
import com.groupa.ssi.model.domain.personnel.Department;
import com.groupa.ssi.model.domain.personnel.Employee;
import com.groupa.ssi.model.domain.personnel.Role;
import com.groupa.ssi.request.personnel.EmployeeRequest;
import com.groupa.ssi.services.personnel.DepartmentService;
import com.groupa.ssi.services.personnel.EmployeeService;
import com.groupa.ssi.services.personnel.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Lizeth Salazar
 */

@CommandScoped
public class EmployeeCreateCmd extends AbstractCommand {
    private static Logger log = LoggerFactory.getLogger(EmployeeCreateCmd.class);
    private EmployeeRequest employeeRequest;
    private MultipartFile photoFile;

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private DepartmentService departmentService;

    @Override
    protected void run() {
        Role roleEmployee = null;
        Department department = null;
        Employee supervisor = null;

        if(employeeRequest.getRoleId() != null) {
            roleEmployee = roleService.findById(employeeRequest.getRoleId());
        }
        if(employeeRequest.getDepartmentId() != null) {
            department = departmentService.findById(employeeRequest.getDepartmentId());
        }
        if (employeeRequest.getSupervisorId() != null){
            supervisor = employeeService.findById(employeeRequest.getSupervisorId());
        }

        Employee employee = ComposeEmployee(employeeRequest, roleEmployee, department, supervisor, photoFile);

        employeeService.save(employee);
    }

    private Employee ComposeEmployee(EmployeeRequest employeeRequest, Role role, Department department, Employee supervisor, MultipartFile photoFile) {
        Employee employee = new Employee();
        employee.setIdentificationNumber(employeeRequest.getIdentificationNumber());
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setDateOfBirth(employeeRequest.getDateOfBirth());
        employee.setGender(employeeRequest.getGender());
        employee.setStartDateInCompany(employeeRequest.getStartDateInCompany());
        employee.setHealthConditionStartingAtCompany(employeeRequest.getHealthConditionStartingAtCompany());
        employee.setRoleEmployee(role);
        employee.setDepartmentEmployee(department);
        employee.setSupervisor(supervisor);
        employee.setPhotoFileDocument(composeFileDocument(photoFile));

        return employee;
    }

    private FileDocument composeFileDocument(MultipartFile file) {
        FileDocument fileDocument = null;

        if (file != null) {
            try {
                fileDocument = new FileDocument();
                fileDocument.setFileName(file.getOriginalFilename());
                fileDocument.setContentType(file.getContentType());
                fileDocument.setSize(file.getSize());
                fileDocument.setData(file.getBytes());
            } catch (IOException e) {
                log.debug("Error in recovery employee photo..", e);
            }
        }
        return fileDocument;
    }

    public void setEmployeeRequest(EmployeeRequest employeeRequest) {
        this.employeeRequest = employeeRequest;
    }

    public void setPhotoFile(MultipartFile photoFile) {
        this.photoFile = photoFile;
    }
}
