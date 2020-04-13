package com.zzr.skittles.controller;

import com.zzr.skittles.dao.TestMapper;
import com.zzr.skittles.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@ResponseBody
public class TestCcontoller {
    @Autowired
    TestMapper testMapper;
    @GetMapping("/test")
    public String test(){
        return "测试web";
    }

    @GetMapping("/test2")
    public String test2() {
        Test test =testMapper.selectByPrimaryKey(1);
        System.out.println(test);
        return test.toString();
    }
}
