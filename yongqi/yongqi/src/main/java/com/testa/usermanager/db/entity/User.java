package com.testa.usermanager.db.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    // 主键ID
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String nickname;

    private String phone;

    private String password;

    private Character sex;

    @TableField(value = "`describe`") // describe属于数据库关键字，加上``区分
    private String describe;

    // 创建时间
    @TableField(fill = FieldFill.INSERT) // insert操作时自动注入时间
    private Date gmtCreate;
}
