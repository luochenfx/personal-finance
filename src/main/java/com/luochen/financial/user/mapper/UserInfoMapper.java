package com.luochen.financial.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luochen.financial.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author luochen
 * @since 2022-07-12
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
