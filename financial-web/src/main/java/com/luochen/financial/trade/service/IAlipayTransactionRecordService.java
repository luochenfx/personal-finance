package com.luochen.financial.trade.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luochen.financial.trade.entity.AlipayTransactionRecord;
import com.luochen.financial.trade.entity.TradeIncomeExpenditure;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author luochen
 * @since 2022-07-19
 */
public interface IAlipayTransactionRecordService extends IService<AlipayTransactionRecord> {

    /**
     * 按月份查询收支情况
     * @return TradeIncomeExpenditure
     */
    List<TradeIncomeExpenditure> getIncomeExpenditureByAllMonth();

    /**
     * 查询所有转账记录
     * @return List<AlipayTransactionRecord>
     */
    List<AlipayTransactionRecord> fundTransferOfAll();

    /**
     * 查询所有转账记录
     * @return List<AlipayTransactionRecord>
     */
    List<Map<String,Object>> statisticsByFundStatus();

    /**
     * 获取本月消费金额
     * @return 本月消费金额
     */
    double spendingThisMonth();

    void fileRead(MultipartFile file) throws IOException;

}
