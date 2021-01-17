package com.zxc.attendance.dao;

import com.zxc.model.atte.entity.ExtraDutyRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ExtraDutyRuleDao extends JpaRepository<ExtraDutyRule,String>, JpaSpecificationExecutor<ExtraDutyRule> {

    /**
     *
     *  根据公司和部门查询加班规则配置信息
     * @param extraDutyConfigId
     * @return
     */
    List<ExtraDutyRule> findByExtraDutyConfigId(String extraDutyConfigId);


    /**
     * 删除配置id的规则
     * @param extraDutyConfigId
     * @return
     */
    Integer deleteByExtraDutyConfigId(String extraDutyConfigId);


    /**
     * @param companyId
     * @param departmentId
     * @return
     */
    List<ExtraDutyRule> findByCompanyIdAndDepartmentId(String companyId, String departmentId);
}
