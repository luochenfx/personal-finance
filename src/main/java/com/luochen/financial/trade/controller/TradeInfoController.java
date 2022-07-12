package com.luochen.financial.trade.controller;


import com.luochen.financial.trade.entity.TradeInfo;
import com.luochen.financial.trade.service.ITradeInfoService;
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

}
