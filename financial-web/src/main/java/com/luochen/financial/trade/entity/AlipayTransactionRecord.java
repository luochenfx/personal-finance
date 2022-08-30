package com.luochen.financial.trade.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

/**
 * <p>
 * 
 * </p>
 *
 * @author luochen
 * @since 2022-07-19
 */
@ApiModel()
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("alipay_transaction_record")
public class AlipayTransactionRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 交易号
     */
    @ApiModelProperty("交易号")
    @TableId(value = "trade_no", type = IdType.ASSIGN_ID)
    private String tradeNo;

    /**
     * 商家订单号
     */
    @ApiModelProperty("商家订单号")
    @TableField("out_trade_no")
    private String outTradeNo;

    /**
     * 交易创建时间
     */
    @ApiModelProperty("交易创建时间")
    @TableField("create_time")
    private Date createTime;

    /**
     * 付款时间
     */
    @ApiModelProperty("付款时间")
    @TableField("pay_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date payTime;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @TableField("update_time")
    private Date updateTime;

    /**
     * 交易来源地
     */
    @ApiModelProperty("交易来源地")
    @TableField("trade_source")
    private String tradeSource;

    /**
     * 类型
     */
    @ApiModelProperty("类型")
    @TableField("type")
    private String type;

    /**
     * 交易方
     */
    @ApiModelProperty("交易方")
    @TableField("seller")
    private String seller;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    @TableField("product")
    private String product;

    /**
     * 金额
     */
    @ApiModelProperty("金额")
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 收支
     */
    @ApiModelProperty("收支")
    @TableField("income_expenditure")
    private String incomeExpenditure;

    /**
     * 交易状态
     */
    @ApiModelProperty("交易状态")
    @TableField("trade_status")
    private String tradeStatus;

    /**
     * 服务费
     */
    @ApiModelProperty("服务费")
    @TableField("service_money")
    private BigDecimal serviceMoney;

    /**
     * 成功退款
     */
    @ApiModelProperty("成功退款")
    @TableField("refund")
    private String refund;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    @TableField("memo")
    private String memo;

    /**
     * 资金状态
     */
    @ApiModelProperty("资金状态")
    @TableField("fund_status")
    private String fundStatus;

    @ApiModelProperty("时间区间")
    @TableField(exist = false)
    private String dateTimeRange;

    /**
     * 收支
     */
    public enum IncomeExpenditure {
        /**
         * 收入
         */
        INCOME("收入"),
        /**
         * 支出
         */
        EXPENDITURE("支出");

        private final String value;

        IncomeExpenditure(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * 根据名称获取信息
     * @param value 收支信息
     * @return FundStatus
     */
    public FundStatus getFundStatusByValue(String value){
        Optional<FundStatus> optional = Arrays.stream(FundStatus.values())
                .filter(p -> Objects.equals(p.getValue(), value))
                .findFirst();
        return optional.orElse(null);
    }

    public enum FundStatus {
        /**
         * 收入
         */
        INCOME("已收入"),
        /**
         * 支出
         */
        EXPENDITURE("已支出"),

        /**
         * 资金转移
         */
        FUND_TRANS("资金转移");

        private final String value;

        FundStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
