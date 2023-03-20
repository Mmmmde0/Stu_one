package com.testa.usermanager.vo;

import lombok.Data;

@Data
public class QueryParam {

    // 用户名
    private String username;

    // 昵称
    private String nickname;

    // 号码
    private String phone;

    // 性别
    private String sex;

    // 创建时间
    private String time;
}
