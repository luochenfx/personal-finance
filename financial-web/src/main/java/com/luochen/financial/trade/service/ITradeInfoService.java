package com.luochen.financial.trade.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luochen.financial.trade.entity.TradeIncomeExpenditure;
import com.luochen.financial.trade.entity.TradeInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author luochen
 * @since 2022-07-12
 */
public interface ITradeInfoService extends IService<TradeInfo> {

    /**
     *  列表查询
     * @param tradeInfo 交易信息
     * @return 交易信息列表
     */
    List<TradeInfo> list(TradeInfo tradeInfo);

    List<TradeIncomeExpenditure> getIncomeExpenditureByAllMonth();

    /**
     * 获取本月消费金额
     * @return 本月消费金额
     */
    double spendingThisMonth();

    /**
     * 获取上个月消费金额
     * @return 上个月消费金额
     */
    double spendingLastMonth();

    /**
     * 添加交易信息
     *
     * @param tradeInfo 交易信息
     */
    void addTradeInfo(TradeInfo tradeInfo);
}
