package com.luochen.financial.trade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luochen.financial.trade.entity.TradeIncomeExpenditure;
import com.luochen.financial.trade.entity.WxTransactionRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 微信账单 Mapper 接口
 * </p>
 *
 * @author luochen
 * @since 2022-07-26
 */
@Mapper
public interface WxTransactionRecordMapper extends BaseMapper<WxTransactionRecord> {

    /**
     * 获取月度收支信息
     * @return 收支列表
     */
    List<TradeIncomeExpenditure> getIncomeExpenditureByAllMonth();

    /**
     * 获取本月消费金额
     * @return 本月消费金额
     */
    double spendingThisMonth();

    /**
     * 上个月消费金额
     * @return 消费金额总数
     */
    double spendingLastMonth();
}
