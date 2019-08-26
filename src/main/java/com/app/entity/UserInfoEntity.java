package com.app.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @Package ${PACKAGE_NAME}
 * @ClassName  ${NAME}
 * @Author shaobin.wang
 * @Date  2019/08/26 21:26
 * @Version 1.0
 * @Description:  
 **/
@Data
public class UserInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键
    */
    private Long id;

    private String userName;

    private String passWord;

}