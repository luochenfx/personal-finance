package com.luochen.financial.trade.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luochen.financial.file.FileReadListenerImpl;
import com.luochen.financial.trade.entity.AlipayTransactionRecord;
import com.luochen.financial.trade.entity.TradeIncomeExpenditure;
import com.luochen.financial.trade.mapper.AlipayTransactionRecordMapper;
import com.luochen.financial.trade.service.IAlipayTransactionRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luochen
 * @since 2022-07-19
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class AlipayTransactionRecordServiceImpl extends ServiceImpl<AlipayTransactionRecordMapper, AlipayTransactionRecord> implements IAlipayTransactionRecordService {

    @Override
    public List<TradeIncomeExpenditure> getIncomeExpenditureByLastMonth() {
        return baseMapper.getIncomeExpenditureByLastMonth();
    }

    public List<AlipayTransactionRecord> fundTransferOfAll() {
        LambdaQueryWrapper<AlipayTransactionRecord> query = Wrappers.lambdaQuery();
        query.eq(AlipayTransactionRecord::getFundStatus, AlipayTransactionRecord.FundStatus.FUND_TRANS.getValue());
        query.orderByDesc(AlipayTransactionRecord::getPayTime);
        return baseMapper.selectList(query);
    }

    @Override
    public List<Map<String, Object>> statisticsByFundStatus() {
        return baseMapper.statisticsByFundStatus();
    }

    @Override
    public double spendingThisMonth() {
        return baseMapper.spendingThisMonth();
    }

    @Override
    public double spendingLastMonth() {
        return baseMapper.spendingLastMonth();
    }

    @Async
    public void fileRead(MultipartFile file) throws IOException {
        FileReadListenerImpl<AlipayTransactionRecordServiceImpl, AlipayTransactionRecord> listener = new FileReadListenerImpl<>(this);
        EasyExcel.read(file.getInputStream(), AlipayTransactionRecord.class, listener).sheet().doRead();
    }

    @Override
    public boolean saveBatch(Collection<AlipayTransactionRecord> list){
        return saveOrUpdateBatch(list);
    }


}
