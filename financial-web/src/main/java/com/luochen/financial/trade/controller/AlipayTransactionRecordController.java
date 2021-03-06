package com.luochen.financial.trade.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.luochen.financial.trade.entity.AlipayTransactionRecord;
import com.luochen.financial.trade.entity.TradeIncomeExpenditure;
import com.luochen.financial.trade.service.IAlipayTransactionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luochen
 * @since 2022-07-19
 */
@RestController
@RequestMapping("/trade/alipay-transaction-record")
public class AlipayTransactionRecordController {

	@Autowired
	private IAlipayTransactionRecordService alipayTransactionRecordService;

	@GetMapping("/all")
	public List<AlipayTransactionRecord> all() {
		return alipayTransactionRecordService.list();
	}

	@GetMapping("/income")
	public List<AlipayTransactionRecord> getIncome(){
		LambdaQueryWrapper<AlipayTransactionRecord> query = Wrappers.lambdaQuery();
		query.eq(AlipayTransactionRecord::getIncomeExpenditure, AlipayTransactionRecord.IncomeExpenditure.INCOME.getValue());
		return alipayTransactionRecordService.list(query);
	}

	@GetMapping("/expenditure")
	public List<AlipayTransactionRecord> getExpenditure(){
		LambdaQueryWrapper<AlipayTransactionRecord> query = Wrappers.lambdaQuery();
		query.eq(AlipayTransactionRecord::getIncomeExpenditure, AlipayTransactionRecord.IncomeExpenditure.EXPENDITURE.getValue());
		return alipayTransactionRecordService.list(query);
	}

	@GetMapping("/incomeExpenditureByAllMonth")
	List<TradeIncomeExpenditure> getIncomeExpenditureByAllMonth(){
		return alipayTransactionRecordService.getIncomeExpenditureByAllMonth();
	}

}
