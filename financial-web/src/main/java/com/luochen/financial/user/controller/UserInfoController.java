package com.luochen.financial.user.controller;


import com.luochen.financial.user.entity.LoginInfo;
import com.luochen.financial.user.entity.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author luochen
 * @since 2022-07-12
 */
@Api(tags = "用户信息")
@RestController
@RequestMapping("/user/user-info")
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class UserInfoController {

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public LoginInfo login(LoginInfo info){
        return new LoginInfo("admin-token");
    }
    @ApiOperation(value = "获取用户信息")
    @GetMapping("/info")
    public UserInfoVo getInfo(@RequestParam("token") String token){
        UserInfoVo vo = new UserInfoVo();
        vo.setName("admin");
        vo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        vo.setIntroduction("admin - introduction");
        vo.setRoles(Collections.singletonList("admin"));
        return vo;
    }
    @ApiOperation(value = "登出")
    @PostMapping("/logout")
    public String logout(){
        return "success";
    }
}
