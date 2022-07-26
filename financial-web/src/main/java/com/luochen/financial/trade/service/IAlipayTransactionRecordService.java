package com.luochen.financial.trade.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luochen.financial.trade.entity.AlipayTransactionRecord;
import com.luochen.financial.trade.entity.TradeIncomeExpenditure;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author luochen
 * @since 2022-07-19
 */
public interface IAlipayTransactionRecordService extends IService<AlipayTransactionRecord> {

	/**
	 * 按月份查询收支情况
	 * @return TradeIncomeExpenditure
	 */
	List<TradeIncomeExpenditure> getIncomeExpenditureByAllMonth();

	/**
	 * 查询所有转账记录
	 * @return List<AlipayTransactionRecord>
	 */
	List<AlipayTransactionRecord> fundTransferOfAll();
}
