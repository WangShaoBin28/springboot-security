package com.app.service.impl;

import com.app.dto.MenuDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.app.dao.MenuInfoEntityMapper;
import com.app.entity.MenuInfoEntity;
import com.app.service.MenuInfoEntityService;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Package ${PACKAGE_NAME}
 * @ClassName ${NAME}
 * @Author shaobin.wang
 * @Date 2019/08/27 14:20
 * @Version 1.0
 * @Description:
 **/
@Service
public class MenuInfoEntityServiceImpl implements MenuInfoEntityService {

    @Resource
    private MenuInfoEntityMapper menuInfoEntityMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return menuInfoEntityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MenuInfoEntity record) {
        return menuInfoEntityMapper.insert(record);
    }

    @Override
    public int insertSelective(MenuInfoEntity record) {
        return menuInfoEntityMapper.insertSelective(record);
    }

    @Override
    public MenuInfoEntity selectByPrimaryKey(Long id) {
        return menuInfoEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MenuInfoEntity record) {
        return menuInfoEntityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MenuInfoEntity record) {
        return menuInfoEntityMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<MenuDto> findAllMenu() {
        List<MenuInfoEntity> menuInfoEntities = menuInfoEntityMapper.findAllMenu();
        List<MenuDto> menuDtos = new ArrayList<>();

        List<MenuInfoEntity> parentMenuList = menuInfoEntities.stream().filter(item -> item.getParentId() == null).collect(Collectors.toList());
        menuInfoEntities.removeAll(parentMenuList);

        parentMenuList.forEach(i -> {
            MenuDto menuDto = new MenuDto();
            BeanUtils.copyProperties(i, menuDto);
            List<MenuDto> menuDtos1 = childMenu(menuInfoEntities, i.getId());
            menuDto.setChildMenuList(menuDtos1);
            menuDtos.add(menuDto);
        });
        return menuDtos;
    }

    public List<MenuDto> childMenu(List<MenuInfoEntity> menuInfoEntities, Long parentId) {
        List<MenuDto> menuDtos = new ArrayList<>();
        List<MenuInfoEntity> collect = menuInfoEntities.stream().filter(item -> item.getParentId().equals(parentId)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(menuInfoEntities)) {
            collect.forEach(i -> {
                MenuDto menuDto = new MenuDto();
                BeanUtils.copyProperties(i, menuDto);
                List<MenuDto> menuDtos1 = childMenu(menuInfoEntities, i.getId());
                if (!CollectionUtils.isEmpty(menuDtos1)) {
                    menuDto.setChildMenuList(menuDtos1);
                }
                menuDtos.add(menuDto);
            });
        }
        return menuDtos;
    }

}
