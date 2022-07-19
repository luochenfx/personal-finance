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
 * 
 * </p>
 *
 * @author luochen
 * @since 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("alipay_transaction_record")
public class AlipayTransactionRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 交易号
     */
    @TableId(value = "trade_no", type = IdType.ASSIGN_ID)
    private String tradeNo;

    /**
     * 商家订单号
     */
    @TableField("out_trade_no")
    private String outTradeNo;

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

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 交易来源地
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
     * 交易状态
     */
    @TableField("trade_status")
    private String tradeStatus;

    /**
     * 服务费
     */
    @TableField("service_money")
    private BigDecimal serviceMoney;

    /**
     * 成功退款
     */
    @TableField("refund")
    private String refund;

    /**
     * 备注
     */
    @TableField("memo")
    private String memo;

    /**
     * 资金状态
     */
    @TableField("fund_status")
    private String fundStatus;


}
