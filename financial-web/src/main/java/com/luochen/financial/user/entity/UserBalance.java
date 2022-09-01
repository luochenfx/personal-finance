package com.luochen.financial.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

/**
 * <p>
 * UserBalance
 * </p>
 *
 * @author luochen
 * @since 2022-07-12
 */
@ApiModel
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_balance")
public class UserBalance implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Long userId;

    /**
     * 平台
     */
    @ApiModelProperty("平台")
    @TableField("platfrom")
    private String platfrom;

    /**
     * 总金额
     */
    @ApiModelProperty("总金额")
    @TableField("total_amount")
    private BigDecimal totalAmount;

    /**
     * 可用余额
     */
    @ApiModelProperty("可用余额")
    @TableField("available_amount")
    private BigDecimal availableAmount;

    /**
     * 冻结金额
     */
    @ApiModelProperty("冻结金额")
    @TableField("freeze_amount")
    private BigDecimal freezeAmount;

    /**
     * 未结算金额
     */
    @ApiModelProperty("未结算金额")
    @TableField("settle_amount")
    private BigDecimal settleAmount;

    @ApiModelProperty("欠款金额")
    @TableField("arrears")
    private BigDecimal arrears;

    public void init(){
        if(this.totalAmount == null){
            this.totalAmount = BigDecimal.ZERO;
        }
        if(this.availableAmount == null){
            this.availableAmount = BigDecimal.ZERO;
        }
        if(this.freezeAmount == null){
            this.freezeAmount = BigDecimal.ZERO;
        }
        if(this.settleAmount == null){
            this.settleAmount = BigDecimal.ZERO;
        }
    }

    /**
     * 中文显示
     */
    public void parseView(){
        DefaultPlatFrom defaultPlatFrom = DefaultPlatFrom.findAny(this.platfrom);
        if (defaultPlatFrom != null) {
            this.platfrom = defaultPlatFrom.getName();
        }
    }


    /**
     * 预设平台
     */
    public enum DefaultPlatFrom{
        /**
         * 微信
         */
        WECHAT("wechat","微信"),
        /**
         * 支付宝
         */
        ALIPAY("alipay","支付宝"),
        /**
         * 银行卡
         */
        BANK("bank","银行卡"),
        /**
         * 现金
         */
        CASH("cash", "现金")
        ;
        private final String value;
        private final String name;
        DefaultPlatFrom(String value, String name){
            this.value = value;
            this.name = name;
        }
        public String getValue() {
            return value;
        }

        public String getName() {
            return name;
        }

        public static DefaultPlatFrom findAny(String value) {
            return Arrays.stream(DefaultPlatFrom.values())
                    .filter(platFrom -> Objects.equals(platFrom.getValue(), value))
                    .findAny()
                    .orElse(null);
        }
    }
}
