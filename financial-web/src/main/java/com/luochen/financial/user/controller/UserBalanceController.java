package com.luochen.financial.user.controller;


import com.luochen.financial.user.entity.UserAssets;
import com.luochen.financial.user.entity.UserBalance;
import com.luochen.financial.user.service.IUserBalanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luochen
 * @since 2022-07-12
 */

@Api(tags = "平台余额")
@RestController
@RequestMapping("/user/user-balance")
public class UserBalanceController {

    @Autowired
    private IUserBalanceService userBalanceService;

    @ApiOperation(value = "全平台余额")
    @GetMapping("/inquireBalance")
    public UserAssets inquireBalance(Long userId) {
        return userBalanceService.getUserAssets(userId);
    }

    /**
     * 获取用户平台资产
     * @param userBalance userBalance
     * @return UserBalance
     */
    @ApiOperation(value = "余额查询")
    @GetMapping("/getUserBalance")
    public UserBalance userBalance(UserBalance userBalance) {
        return userBalanceService.userBalanceByPlatFrom(userBalance);
    }

    @ApiOperation(value = "用户在所有平台的余额")
    @GetMapping("/getAllUserBalance")
    public List<UserBalance> getAllUserBalance(Long userId) {
        return userBalanceService.getAllUserBalance(userId);
    }


    /**
     * 修改用户平台资产
     */
    @ApiOperation(value = "修改用户平台资产")
    @PostMapping("/saveOrUpdateUserBalance")
    public boolean saveOrUpdateUserBalance(@RequestBody UserBalance userBalance) {
        return userBalanceService.saveOrUpdate(userBalance);
    }
}
