package com.luochen.financial.trade.controller;


import com.luochen.financial.trade.entity.TradeIncomeExpenditure;
import com.luochen.financial.trade.entity.TradeInfo;
import com.luochen.financial.trade.service.ITradeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luochen
 * @since 2022-07-12
 */
@Api(tags = "交易信息")
@RestController
@RequestMapping("/trade/trade-info")
public class TradeInfoController {

	@Autowired
	private ITradeInfoService tradeInfoService;

	@ApiOperation(value = "所有交易信息")
	@GetMapping("/all")
	public List<TradeInfo> all() {
		return tradeInfoService.list();
	}


	@ApiOperation(value = "获取交易信息列表")
	@GetMapping("/list")
	public List<TradeInfo> list(TradeInfo tradeInfo) {
		return tradeInfoService.list(tradeInfo);
	}


	/**
	 * 保存交易信息
	 * @param tradeInfo 交易信息
	 */
	@ApiOperation(value = "保存交易信息")
	@PostMapping("/save")
	public void addTradeInfo(@RequestBody TradeInfo tradeInfo) {
		tradeInfoService.addTradeInfo(tradeInfo);
	}

	/**
	 * 修改交易信息
	 * @param tradeInfo 交易信息
	 */
	@ApiOperation(value = "修改交易信息")
	@PostMapping("/update")
	public void updateTradeInfo(@RequestBody TradeInfo tradeInfo) {
		tradeInfoService.updateById(tradeInfo);
	}

	/**
	 * 删除交易信息
	 * @param tradeInfo 交易信息
	 */
	@ApiOperation(value = "删除交易信息")
	@PostMapping("/delete")
	public void deleteTradeInfo(@RequestBody TradeInfo tradeInfo) {
		tradeInfoService.removeById(tradeInfo.getId());
	}

	@ApiOperation(value = "月收支统计")
	@GetMapping("/incomeExpenditureByAllMonth")
	public List<TradeIncomeExpenditure> getIncomeExpenditureByAllMonth(){
		return tradeInfoService.getIncomeExpenditureByAllMonth();
	}

	/**
	 * 获取本月消费金额
	 * @return 本月消费金额
	 */
	@ApiOperation(value = "获取本月消费金额")
	@GetMapping("/spendingThisMonth")
	public double spendingThisMonth(){
		return tradeInfoService.spendingThisMonth();
	}

}
