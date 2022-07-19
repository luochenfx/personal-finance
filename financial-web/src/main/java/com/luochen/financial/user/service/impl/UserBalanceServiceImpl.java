package com.luochen.financial.user.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luochen.financial.user.entity.UserAssets;
import com.luochen.financial.user.entity.UserBalance;
import com.luochen.financial.user.mapper.UserBalanceMapper;
import com.luochen.financial.user.service.IUserBalanceService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luochen
 * @since 2022-07-12
 */
@Service
public class UserBalanceServiceImpl extends ServiceImpl<UserBalanceMapper, UserBalance> implements IUserBalanceService {

	@Override
	public UserAssets getUserAssets(String userId) {
		UserAssets userAssets = new UserAssets();
		LambdaQueryChainWrapper<UserBalance> wrapper = lambdaQuery().eq(UserBalance::getUserId, userId);
		List<UserBalance> list = wrapper.list();
		if (!CollectionUtils.isEmpty(list)) {
			userAssets.setUserBalanceList(list);
			BigDecimal reduce = list.stream().map(UserBalance::getTotalAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
			userAssets.setTotalAmount(reduce);
		}
		return userAssets;
	}
}
