package com.luochen.financial.user.entity;

import lombok.Data;

import java.util.List;
@Data
public class UserInfoVo {
    private String name;
    private String avatar;
    private String introduction;
    private List<String> roles;
}
