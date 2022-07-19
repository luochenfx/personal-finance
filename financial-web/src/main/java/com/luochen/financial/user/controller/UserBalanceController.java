package com.luochen.financial.user.controller;


import com.luochen.financial.user.entity.UserAssets;
import com.luochen.financial.user.service.IUserBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public UserAssets inquireBalance(String userId) {
		return userBalanceService.getUserAssets(userId);
	}


}
