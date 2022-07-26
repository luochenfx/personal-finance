package com.luochen.financial.trade.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luochen.financial.trade.entity.WxTransactionRecord;
import com.luochen.financial.trade.mapper.WxTransactionRecordMapper;
import com.luochen.financial.trade.service.IWxTransactionRecordService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信账单 服务实现类
 * </p>
 *
 * @author luochen
 * @since 2022-07-26
 */
@Service
public class WxTransactionRecordServiceImpl extends ServiceImpl<WxTransactionRecordMapper, WxTransactionRecord> implements IWxTransactionRecordService {

}
