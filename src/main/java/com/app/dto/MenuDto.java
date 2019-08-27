package com.app.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Package com.app.dto
 * @ClassName MenuDto
 * @Author shaobin.wang
 * @Date 2019/08/27 14:25
 * @Version 1.0
 * @Description:
 **/
@Data
public class MenuDto implements Serializable {
    private static final long serialVersionUID = 1491242354544345751L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 名称
     */
    private String menuName;

    /**
     * 路径
     */
    private String menuUrl;

    /**
     * 父类id
     */
    private Long parentId;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 子类
     */
    private List<MenuDto> childMenuList;
}
