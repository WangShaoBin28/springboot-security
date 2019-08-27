package com.app.service;

import com.app.dto.MenuDto;
import com.app.entity.MenuInfoEntity;

import java.util.List;

/**
 * @Package ${PACKAGE_NAME}
 * @ClassName  ${NAME}
 * @Author shaobin.wang
 * @Date  2019/08/27 14:20
 * @Version 1.0
 * @Description:  
 **/
public interface MenuInfoEntityService{


    int deleteByPrimaryKey(Long id);

    int insert(MenuInfoEntity record);

    int insertSelective(MenuInfoEntity record);

    MenuInfoEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MenuInfoEntity record);

    int updateByPrimaryKey(MenuInfoEntity record);

        List<MenuDto> findAllMenu();
    }
