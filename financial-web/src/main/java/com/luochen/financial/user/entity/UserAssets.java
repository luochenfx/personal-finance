package com.luochen.financial.user.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author luochenfx
 */
@Getter
@Setter
public class UserAssets {
    List<UserBalance> userBalanceList;
    private BigDecimal totalAmount;
}
