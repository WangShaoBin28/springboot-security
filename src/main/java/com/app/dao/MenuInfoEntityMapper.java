package com.app.dao;

import com.app.entity.MenuInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Package ${PACKAGE_NAME}
 * @ClassName ${NAME}
 * @Author shaobin.wang
 * @Date 2019/08/27 14:20
 * @Version 1.0
 * @Description:
 **/
@Mapper
@Repository
public interface MenuInfoEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MenuInfoEntity record);

    int insertSelective(MenuInfoEntity record);

    MenuInfoEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MenuInfoEntity record);

    int updateByPrimaryKey(MenuInfoEntity record);

    List<MenuInfoEntity> findAllMenu();
}