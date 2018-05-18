package com.groupa.ssi.model.domain.audit;

import com.groupa.ssi.model.domain.ModelBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author Neyber Rojas Zapata
 */
@Entity
public class SafetyRule extends ModelBase {

    @Column
    private String policyCode;
    @Column
    private String policyName;
    @Column
    private Integer complianceParameter;
    @Column
    private Integer complianceMetric;
    @Column
    private Boolean accomplishment;
    @ManyToOne
    private Audit audit;

    public String getPolicyCode() {
        return policyCode;
    }

    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public Integer getComplianceParameter() {
        return complianceParameter;
    }

    public void setComplianceParameter(Integer complianceParameter) {
        this.complianceParameter = complianceParameter;
    }

    public Integer getComplianceMetric() {
        return complianceMetric;
    }

    public void setComplianceMetric(Integer complianceMetric) {
        this.complianceMetric = complianceMetric;
    }

    public Boolean getAccomplishment() {
        return accomplishment;
    }

    public void setAccomplishment(Boolean accomplishment) {
        this.accomplishment = accomplishment;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }
}
