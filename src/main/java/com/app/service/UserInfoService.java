package com.app.service;

import com.app.entity.UserInfoEntity;

import java.util.List;

/**
 * @Package ${PACKAGE_NAME}
 * @ClassName  ${NAME}
 * @Author shaobin.wang
 * @Date  2019/08/26 21:26
 * @Version 1.0
 * @Description:  
 **/
public interface UserInfoService{


    int deleteByPrimaryKey(Long id);

    int insert(UserInfoEntity record);

    int insertSelective(UserInfoEntity record);

    UserInfoEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfoEntity record);

    int updateByPrimaryKey(UserInfoEntity record);

        List<UserInfoEntity> findAll();

    }
