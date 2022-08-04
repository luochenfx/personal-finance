package com.luochen.financial.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luochen.financial.user.entity.UserAssets;
import com.luochen.financial.user.entity.UserBalance;

import java.util.List;

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
	UserAssets getUserAssets(Long userId);

	/**
	 * add user balance
	 * @param platFrom 平台
	 * @param userId 用户id
	 * @return boolean
	 */
	UserBalance addNewPlatFrom(String platFrom, Long userId);

	/**
	 * add user balance
	 * @param platFrom {@link UserBalance.DefaultPlatFrom}
	 * @param userId 用户id
	 * @return boolean
	 */
	UserBalance addNewPlatFrom(UserBalance.DefaultPlatFrom platFrom, Long userId);

	/**
	 * 余额查询
	 * @param userBalance userBalance
	 * @return 平台余额
	 */
	UserBalance userBalanceByPlatFrom(UserBalance userBalance);

	/**
	 * 用户在所有平台的余额
	 * @param userId 用户id
	 * @return List<UserBalance>
	 */
	List<UserBalance> getAllUserBalance(Long userId);
}
