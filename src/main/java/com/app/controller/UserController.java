package com.app.controller;

import com.app.entity.UserInfoEntity;
import com.app.service.UserInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String list(@RequestParam Integer pageNum, @RequestParam Integer pageSize, ModelMap modelMap) {
        PageInfo<UserInfoEntity> userInfoEntities = userInfoService.findAllByPage(pageNum, pageSize);

        modelMap.addAttribute("page", userInfoEntities);

        return "list";
    }
}
