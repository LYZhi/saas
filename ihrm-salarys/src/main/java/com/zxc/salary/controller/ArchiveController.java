package com.zxc.salary.controller;

import com.zxc.common.controller.BaseController;
import com.zxc.common.entity.Result;
import com.zxc.common.entity.ResultCode;
import com.zxc.model.salarys.CompanySettings;
import com.zxc.model.salarys.SalaryArchive;
import com.zxc.model.salarys.SalaryArchiveDetail;
import com.zxc.salary.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/salarys")
public class ArchiveController extends BaseController {

    @Autowired
    private ArchiveService archiveService;

    /**
     * 制作薪资报表
     */
    @RequestMapping(value = "/reports/{yearMonth}" , method = RequestMethod.GET)
    public Result historyDetail(@PathVariable String yearMonth, int opType){
        List<SalaryArchiveDetail> list = new ArrayList<>();
        //判断opType是否为新制作的报表
        if (opType == 1){
            //新制作的报表
            list = archiveService.getReports(yearMonth , companyId);
        }else{
            //查询归档历史报表
            //1.查询主表数据
            SalaryArchive sa = archiveService.findSalaryArchive(yearMonth , companyId);
            //2.根据主表的id,查询明细表的所有数据
            if (sa != null){
                list = archiveService.findSalaryDetail(sa.getId());
            }
        }
        return new Result(ResultCode.SUCCESS , list);
    }
}
