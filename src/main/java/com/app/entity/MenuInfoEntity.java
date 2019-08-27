package com.app.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @Package ${PACKAGE_NAME}
 * @ClassName  ${NAME}
 * @Author shaobin.wang
 * @Date  2019/08/27 14:20
 * @Version 1.0
 * @Description:  
 **/
@Data
public class MenuInfoEntity implements Serializable {
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

    private static final long serialVersionUID = 1L;
}