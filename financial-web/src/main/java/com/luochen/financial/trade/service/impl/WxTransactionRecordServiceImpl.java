package com.luochen.financial.trade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luochen.financial.trade.entity.TradeIncomeExpenditure;
import com.luochen.financial.trade.entity.WxTransactionRecord;
import com.luochen.financial.trade.mapper.WxTransactionRecordMapper;
import com.luochen.financial.trade.service.IWxTransactionRecordService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

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

	@Override
	public List<TradeIncomeExpenditure> getIncomeExpenditureByAllMonth() {
		return baseMapper.getIncomeExpenditureByAllMonth();
	}

	@Override
	public List<WxTransactionRecord> list(WxTransactionRecord wxTransactionRecord) {
		LambdaQueryWrapper<WxTransactionRecord> query = Wrappers.lambdaQuery(wxTransactionRecord);
		query.orderByDesc(WxTransactionRecord::getPayTime);
		String dateTimeRange = wxTransactionRecord.getDateTimeRange();
		if (StringUtils.hasText(dateTimeRange)) {
			String[] split = dateTimeRange.split(" - ");
			query.between(WxTransactionRecord::getPayTime, split[0], split[1]);
		}
		return list(query);
	}
}
