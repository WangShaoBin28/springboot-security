package com.app.controller;

import com.app.entity.UserInfoEntity;
import com.app.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Package com.app.controller
 * @ClassName UserController
 * @Author shaobin.wang
 * @Date 2019/08/26 21:28
 * @Version 1.0
 * @Description:
 **/
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("list")
    public String list(ModelMap modelMap) {

        List<UserInfoEntity> userInfoEntityList = userInfoService.findAll();
        modelMap.addAttribute("userList", userInfoEntityList);

        return "list";
    }
}
