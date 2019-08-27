package com.app.controller;

import com.app.dto.MenuDto;
import com.app.entity.MenuInfoEntity;
import com.app.service.MenuInfoEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Package com.app.controller
 * @ClassName IndexController
 * @Author shaobin.wang
 * @Date 2019/08/27 13:44
 * @Version 1.0
 * @Description: 菜单名称
 **/
@Controller
@RequestMapping("/index/")
public class IndexController {
    @Autowired
    private MenuInfoEntityService menuInfoEntityService;

    @RequestMapping("main")
    public String main(ModelMap modelMap) {
        List<MenuDto> menuDtos = menuInfoEntityService.findAllMenu();
        modelMap.addAttribute("menuList",menuDtos);
        return "main";
    }
}
