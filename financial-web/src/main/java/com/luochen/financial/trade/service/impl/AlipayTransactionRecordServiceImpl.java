package com.luochen.financial.trade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luochen.financial.trade.entity.AlipayTransactionRecord;
import com.luochen.financial.trade.entity.TradeIncomeExpenditure;
import com.luochen.financial.trade.mapper.AlipayTransactionRecordMapper;
import com.luochen.financial.trade.service.IAlipayTransactionRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

	@Override
	public List<TradeIncomeExpenditure> getIncomeExpenditureByAllMonth() {
		return baseMapper.getIncomeExpenditureByAllMonth();
	}

	public List<AlipayTransactionRecord> fundTransferOfAll() {
		LambdaQueryWrapper<AlipayTransactionRecord> query = Wrappers.lambdaQuery();
		query.eq(AlipayTransactionRecord::getFundStatus, AlipayTransactionRecord.FundStatus.FUND_TRANS.getValue());
		query.orderByDesc(AlipayTransactionRecord::getPayTime);
		return baseMapper.selectList(query);
	}

	@Override
	public List<Map<String, Object>> statisticsByFundStatus() {
		return baseMapper.statisticsByFundStatus();
	}

	@Override
	public double spendingThisMonth() {
		return baseMapper.spendingThisMonth();
	}

}
