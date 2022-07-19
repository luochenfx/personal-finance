package com.luochen.financial.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luochen.financial.user.entity.UserAssets;
import com.luochen.financial.user.entity.UserBalance;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author luochen
 * @since 2022-07-12
 */
public interface IUserBalanceService extends IService<UserBalance> {

	/**
	 * get all user balance
	 * @param userId userId
	 * @return UserAssets
	 */
	UserAssets getUserAssets(String userId);
}
