package com.luochen.financial.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luochen.financial.user.entity.UserAssets;
import com.luochen.financial.user.entity.UserBalance;
import com.luochen.financial.user.mapper.UserBalanceMapper;
import com.luochen.financial.user.service.IUserBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class UserBalanceServiceImpl extends ServiceImpl<UserBalanceMapper, UserBalance> implements IUserBalanceService {

    @Override
    public UserAssets getUserAssets(Long userId) {
        UserAssets userAssets = new UserAssets();
        LambdaQueryChainWrapper<UserBalance> wrapper = lambdaQuery().eq(UserBalance::getUserId, userId);
        List<UserBalance> list = wrapper.list();
        if (!CollectionUtils.isEmpty(list)) {
            userAssets.setUserBalanceList(list);
            BigDecimal reduce = list.stream().map(UserBalance::getTotalAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
            userAssets.setTotalAmount(reduce);
        }else {
            userBalanceInit(userId);
            userAssets.setTotalAmount(BigDecimal.ZERO);
        }
        return userAssets;
    }
    @Override
    public UserBalance addNewPlatFrom(String platFrom, Long userId) {
        UserBalance userBalance = new UserBalance();
        userBalance.setUserId(userId);
        userBalance.setPlatfrom(platFrom);
        userBalance.init();
        save(userBalance);
        return userBalance;
    }

    @Override
    public UserBalance addNewPlatFrom(UserBalance.DefaultPlatFrom platFrom, Long userId) {
        return addNewPlatFrom(platFrom.getValue(), userId);
    }

    @Override
    public UserBalance userBalanceByPlatFrom(UserBalance userBalance) {
        LambdaQueryWrapper<UserBalance> query = Wrappers.lambdaQuery();
        query.eq(UserBalance::getUserId, userBalance.getUserId());
        query.eq(UserBalance::getPlatfrom, userBalance.getPlatfrom());
        UserBalance platFromBalance = getOne(query);
        if (platFromBalance == null) {
            platFromBalance = addNewPlatFrom(userBalance.getPlatfrom(), userBalance.getUserId());
        }
        platFromBalance.parseView();
        return platFromBalance;
    }

    public List<UserBalance> getAllUserBalance(Long userId) {
        LambdaQueryWrapper<UserBalance> query = Wrappers.lambdaQuery();
        query.eq(UserBalance::getUserId, userId);
        List<UserBalance> list = list(query);
        for(UserBalance userBalance : list) {
            userBalance.parseView();
        }
        return list;
    }

    @Transactional
    private void userBalanceInit(Long userId) {
        if (userId != null) {
            addNewPlatFrom(UserBalance.DefaultPlatFrom.ALIPAY, userId);
            addNewPlatFrom(UserBalance.DefaultPlatFrom.WECHAT, userId);
            addNewPlatFrom(UserBalance.DefaultPlatFrom.CASH, userId);
            addNewPlatFrom(UserBalance.DefaultPlatFrom.BANK, userId);
        }
    }
}
