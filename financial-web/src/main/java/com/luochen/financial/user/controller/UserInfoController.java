package com.luochen.financial.user.controller;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
