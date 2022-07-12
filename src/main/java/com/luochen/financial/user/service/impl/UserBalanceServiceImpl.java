package com.luochen.financial.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luochen.financial.user.entity.UserBalance;
import com.luochen.financial.user.mapper.UserBalanceMapper;
import com.luochen.financial.user.service.IUserBalanceService;
import org.springframework.stereotype.Service;

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

}
