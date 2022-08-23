package com.luochen.financial.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luochen.financial.user.entity.UserInfo;
import com.luochen.financial.user.mapper.UserInfoMapper;
import com.luochen.financial.user.service.IUserBalanceService;
import com.luochen.financial.user.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author luochen
 * @since 2022-07-12
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Autowired
    private IUserBalanceService userBalanceService;




}
