package com.zxc.salary.service;

import com.zxc.common.entity.PageResult;
import com.zxc.model.salarys.UserSalary;
import com.zxc.salary.dao.UserSalaryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalaryService {
	
    @Autowired
    private UserSalaryDao userSalaryDao;

    //定薪或者调薪
    public void saveUserSalary(UserSalary userSalary) {
        userSalaryDao.save(userSalary);
    }

	//查询用户薪资
    public UserSalary findUserSalary(String userId) {
        Optional<UserSalary> optional = userSalaryDao.findById(userId);
        return optional.isPresent() ? optional.get() : null;
    }

	//分页查询当月薪资列表
	public PageResult findAll(Integer page, Integer pageSize, String companyId) {
		Page page1 = userSalaryDao.findPage(companyId, PageRequest.of(page - 1, pageSize));
		page1.getContent();
		return new PageResult(page1.getTotalElements(),page1.getContent());
	}

}
