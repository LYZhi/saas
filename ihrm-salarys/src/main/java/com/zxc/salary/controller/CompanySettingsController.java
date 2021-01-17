package com.zxc.salary.controller;

import com.zxc.common.controller.BaseController;
import com.zxc.common.entity.Result;
import com.zxc.common.entity.ResultCode;
import com.zxc.model.salarys.CompanySettings;

import com.zxc.common.controller.BaseController;
import com.zxc.salary.service.CompanySettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 企业设置Controller
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/salarys")
public class CompanySettingsController extends BaseController {

	@Autowired
	private CompanySettingsService companySettingsService;

	/**
	 * 获取企业是否设置工资
	 */
	@RequestMapping(value = "/company-settings", method = RequestMethod.GET)
	public Result getCompanySettings() throws Exception {
		CompanySettings companySettings = companySettingsService.findById(companyId);
		return new Result(ResultCode.SUCCESS, companySettings);
	}

	/**
	 * 保存企业工资设置
	 */
	@RequestMapping(value = "/company-settings", method = RequestMethod.POST)
	public Result saveCompanySettings(@RequestBody CompanySettings companySettings) throws Exception {
		companySettings.setCompanyId(companyId);
		companySettingsService.save(companySettings);
		return new Result(ResultCode.SUCCESS);
	}

	//构造新报表
	@RequestMapping(value = "/reports/{yearMonth}/newReport", method = RequestMethod.PUT)
	public Result newReport(@PathVariable(value = "yearMonth") String yearMonth) {
		CompanySettings companySettings = new CompanySettings();
		companySettings.setCompanyId(companyId);
		companySettings.setDataMonth(yearMonth);
		companySettingsService.save(companySettings);
		return new Result(ResultCode.SUCCESS);
	}
}
