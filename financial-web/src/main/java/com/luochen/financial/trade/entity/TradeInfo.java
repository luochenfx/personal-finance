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
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author luochen
 * @since 2022-07-12
 */
@ApiModel
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("trade_info")
public class TradeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 交易来源
     */
    @ApiModelProperty("交易来源")
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

    @ApiModelProperty("账单来源")
    @TableField("record_source")
    private String recordSource;

    @ApiModelProperty("时间区间")
	@TableField(exist = false)
	private String dateTimeRange;

    /**
     * 账单来源
     */
    public enum RecordSource{

     	/**
     	 * 支付宝
     	 */
     	ALIPAY("支付宝"),

     	/**
     	 * 微信
     	 */
     	WX("微信"),

        /**
         * 手动
         */
        MANUAL("手动添加");

     	private final String value;

     	RecordSource(String value){
     		this.value = value;
     	}

     	public String getValue(){
     		return value;
     	}
    }


}
