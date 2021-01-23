package com.zxc.inters;

import com.zxc.common.entity.Result;
import com.zxc.model.system.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface SystemInter {
    @RequestMapping(value = "/user/{id}" , method = RequestMethod.GET)
    public Result findById(@PathVariable(value = "id") String id);


}
