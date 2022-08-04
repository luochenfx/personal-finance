package com.luochen.financial.user.controller;


import com.luochen.financial.user.entity.UserAssets;
import com.luochen.financial.user.entity.UserBalance;
import com.luochen.financial.user.service.IUserBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luochen
 * @since 2022-07-12
 */
@RestController
@RequestMapping("/user/user-balance")
public class UserBalanceController {

	@Autowired
	private IUserBalanceService userBalanceService;

	@GetMapping("/inquireBalance")
	public UserAssets inquireBalance(Long userId) {
		return userBalanceService.getUserAssets(userId);
	}

	/**
	 * 获取用户平台资产
	 * @param userBalance userBalance
	 * @return UserBalance
	 */
	@GetMapping("/getUserBalance")
	public UserBalance userBalance(UserBalance userBalance) {
		return userBalanceService.userBalanceByPlatFrom(userBalance);
	}

	@GetMapping("/getAllUserBalance")
	public List<UserBalance> getAllUserBalance(Long userId) {
		return userBalanceService.getAllUserBalance(userId);
	}

}
