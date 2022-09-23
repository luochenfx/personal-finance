package com.luochen.financial.trade.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luochen.financial.trade.entity.TradeIncomeExpenditure;
import com.luochen.financial.trade.entity.WxTransactionRecord;

import java.util.List;

/**
 * <p>
 * 微信账单 服务类
 * </p>
 *
 * @author luochen
 * @since 2022-07-26
 */
public interface IWxTransactionRecordService extends IService<WxTransactionRecord> {

    /**
     * 获取月度收支信息
     * @return 收支列表
     */
    List<TradeIncomeExpenditure> getIncomeExpenditureByAllMonth();

    /**
     * 查询所有转账记录
     * @param wxTransactionRecord 微信账单实体
     * @return boolean
     */
    List<WxTransactionRecord> list(WxTransactionRecord wxTransactionRecord);

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
}
