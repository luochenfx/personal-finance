package com.luochen.financial.trade.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 微信账单
 * </p>
 *
 * @author luochen
 * @since 2022-07-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("wx_transaction_record")
public class WxTransactionRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 交易号
     */
    @TableId(value = "trade_no", type = IdType.ASSIGN_ID)
    private String tradeNo;

    /**
     * 交易来源(wx是商户号)
     */
    @TableField("trade_source")
    private String tradeSource;

    /**
     * 类型
     */
    @TableField("type")
    private String type;

    /**
     * 交易方
     */
    @TableField("seller")
    private String seller;

    /**
     * 商品名称
     */
    @TableField("product")
    private String product;

    /**
     * 金额
     */
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 收支
     */
    @TableField("income_expenditure")
    private String incomeExpenditure;

    /**
     * 支付方式
     */
    @TableField("payment_method")
    private String paymentMethod;

    /**
     * 交易状态
     */
    @TableField("trade_status")
    private String tradeStatus;

    /**
     * 交易创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 付款时间
     */
    @TableField("pay_time")
    private Date payTime;


}
