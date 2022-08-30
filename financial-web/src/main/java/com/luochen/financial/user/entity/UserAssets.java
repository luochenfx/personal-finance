package com.luochen.financial.user.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author luochenfx
 */
@ApiModel
@Getter
@Setter
public class UserAssets {

    @ApiModelProperty("用户平台余额列表")
    List<UserBalance> userBalanceList;

    @ApiModelProperty("总金额")
    private BigDecimal totalAmount;
}
