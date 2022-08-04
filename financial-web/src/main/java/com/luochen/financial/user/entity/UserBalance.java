package com.luochen.financial.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * UserBalance
 * </p>
 *
 * @author luochen
 * @since 2022-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_balance")
public class UserBalance implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 平台
     */
    @TableField("platfrom")
    private String platfrom;

    /**
     * 总金额
     */
    @TableField("total_amount")
    private BigDecimal totalAmount;

    /**
     * 可用余额
     */
    @TableField("available_amount")
    private BigDecimal availableAmount;

    /**
     * 冻结金额
     */
    @TableField("freeze_amount")
    private BigDecimal freezeAmount;

    /**
     * 未结算金额
     */
    @TableField("settle_amount")
    private BigDecimal settleAmount;

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
        DefaultPlatFrom defaultPlatFrom = DefaultPlatFrom.PLAT_FROM_MAP.get(this.platfrom);
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
        private static final Map<String, DefaultPlatFrom> PLAT_FROM_MAP = new HashMap<>(8);
        static {
            for (DefaultPlatFrom myEnum : values()) {
                PLAT_FROM_MAP.put(myEnum.getValue(), myEnum);
            }
        }
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

        public static DefaultPlatFrom getByValue(String value) {
            return PLAT_FROM_MAP.get(value);
        }
    }
}
