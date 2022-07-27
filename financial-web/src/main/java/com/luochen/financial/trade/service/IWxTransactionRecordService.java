package com.luochen.financial.trade.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luochen.financial.trade.entity.TradeIncomeExpenditure;
import com.luochen.financial.trade.entity.WxTransactionRecord;

import java.util.List;

/**
 * <p>
 * 微信账单 服务类
 * </p>
 *
 * @author luochen
 * @since 2022-07-26
 */
public interface IWxTransactionRecordService extends IService<WxTransactionRecord> {

	List<TradeIncomeExpenditure> getIncomeExpenditureByAllMonth();

	/**
	 * 查询所有转账记录
	 * @param wxTransactionRecord 微信账单实体
	 * @return boolean
	 */
	List<WxTransactionRecord> list(WxTransactionRecord wxTransactionRecord);
}
