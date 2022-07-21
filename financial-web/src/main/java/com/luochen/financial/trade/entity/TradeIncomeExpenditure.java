package com.luochen.financial.trade.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author luochenfx
 */
@Data
public class TradeIncomeExpenditure {
	private String date;
	private BigDecimal income;
	private BigDecimal expenditure;
}
