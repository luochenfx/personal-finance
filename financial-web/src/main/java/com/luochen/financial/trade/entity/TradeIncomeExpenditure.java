package com.luochen.financial.trade.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author luochenfx
 */
@ApiModel
@Data
public class TradeIncomeExpenditure {

    @ApiModelProperty("日期")
    private String date;

    @ApiModelProperty("收入")
    private BigDecimal income;

    @ApiModelProperty("支出")
    private BigDecimal expenditure;
}
