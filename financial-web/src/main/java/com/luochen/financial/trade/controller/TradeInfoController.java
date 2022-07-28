package com.luochen.financial.trade.controller;


import com.luochen.financial.trade.entity.TradeIncomeExpenditure;
import com.luochen.financial.trade.entity.TradeInfo;
import com.luochen.financial.trade.service.ITradeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luochen
 * @since 2022-07-12
 */
@RestController
@RequestMapping("/trade/trade-info")
public class TradeInfoController {

	@Autowired
	private ITradeInfoService tradeInfoService;

	@GetMapping("/all")
	public List<TradeInfo> all() {
		return tradeInfoService.list();
	}


	@GetMapping("/list")
	public List<TradeInfo> list(TradeInfo tradeInfo) {
		return tradeInfoService.list(tradeInfo);
	}


	/**
	 *
	 * @param tradeInfo
	 */
	@PostMapping("/save")
	public void addTradeInfo(@RequestBody TradeInfo tradeInfo) {
		tradeInfo.setRecordSource(TradeInfo.RecordSource.MANUAL.getValue());
		tradeInfo.setCreateTime(new Date());
		tradeInfoService.save(tradeInfo);
	}

	@PostMapping("/update")
	public void updateTradeInfo(@RequestBody TradeInfo tradeInfo) {
		tradeInfoService.updateById(tradeInfo);
	}

	@PostMapping("/delete")
	public void deleteTradeInfo(@RequestBody TradeInfo tradeInfo) {
		tradeInfoService.removeById(tradeInfo.getId());
	}

	@GetMapping("/incomeExpenditureByAllMonth")
	public List<TradeIncomeExpenditure> getIncomeExpenditureByAllMonth(){
		return tradeInfoService.getIncomeExpenditureByAllMonth();
	}

}
