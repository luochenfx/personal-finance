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
 * @since 2022-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("trade_info")
public class TradeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 交易来源
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
     * 备注
     */
    @TableField("memo")
    private String memo;

    /**
     * 资金状态
     */
    @TableField("fund_status")
    private String fundStatus;

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


}
