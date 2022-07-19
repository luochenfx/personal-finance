package com.luochen.financial.trade.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luochen.financial.trade.entity.AlipayTransactionRecord;
import com.luochen.financial.trade.mapper.AlipayTransactionRecordMapper;
import com.luochen.financial.trade.service.IAlipayTransactionRecordService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luochen
 * @since 2022-07-19
 */
@Service
public class AlipayTransactionRecordServiceImpl extends ServiceImpl<AlipayTransactionRecordMapper, AlipayTransactionRecord> implements IAlipayTransactionRecordService {

}
