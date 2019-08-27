package com.app.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.app.entity.UserInfoEntity;
import com.app.dao.UserInfoMapper;
import com.app.service.UserInfoService;

import java.util.List;

/**
 * @Package ${PACKAGE_NAME}
 * @ClassName ${NAME}
 * @Author shaobin.wang
 * @Date 2019/08/26 21:26
 * @Version 1.0
 * @Description:
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserInfoEntity record) {
        return userInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(UserInfoEntity record) {
        return userInfoMapper.insertSelective(record);
    }

    @Override
    public UserInfoEntity selectByPrimaryKey(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfoEntity record) {
        return userInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserInfoEntity record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<UserInfoEntity> findAll() {
        return userInfoMapper.findAll();
    }

    @Override
    public PageInfo<UserInfoEntity> findAllByPage(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        Page<UserInfoEntity> all = userInfoMapper.findAllByPage();
        PageInfo<UserInfoEntity> of = PageInfo.of(all);

        return of;
    }

}
