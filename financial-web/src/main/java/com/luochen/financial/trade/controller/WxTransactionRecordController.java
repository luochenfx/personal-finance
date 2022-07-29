package com.luochen.financial.trade.controller;


import com.luochen.financial.trade.entity.TradeIncomeExpenditure;
import com.luochen.financial.trade.entity.WxTransactionRecord;
import com.luochen.financial.trade.service.IWxTransactionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 微信账单 前端控制器
 * </p>
 *
 * @author luochen
 * @since 2022-07-26
 */
@RestController
@RequestMapping("/trade/wx")
public class WxTransactionRecordController {

	@Autowired
	private IWxTransactionRecordService wxTransactionRecordService;

	@GetMapping("/all")
	public List<WxTransactionRecord> all() {
		return wxTransactionRecordService.list();
	}


	@GetMapping("/list")
	public List<WxTransactionRecord> list(WxTransactionRecord wxTransactionRecord) {
		return wxTransactionRecordService.list(wxTransactionRecord);
	}

	@GetMapping("/incomeExpenditureByAllMonth")
	public List<TradeIncomeExpenditure> getIncomeExpenditureByAllMonth(){
		return wxTransactionRecordService.getIncomeExpenditureByAllMonth();
	}

	public List<WxTransactionRecord> statistics(WxTransactionRecord wxTransactionRecord) {
		return wxTransactionRecordService.list();
	}


	@GetMapping("/spendingThisMonth")
	public double spendingThisMonth(){
		return wxTransactionRecordService.spendingThisMonth();
	}


}
