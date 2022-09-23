package com.luochen.financial.trade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luochen.financial.trade.entity.TradeIncomeExpenditure;
import com.luochen.financial.trade.entity.TradeInfo;
import com.luochen.financial.trade.mapper.TradeInfoMapper;
import com.luochen.financial.trade.service.ITradeInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luochen
 * @since 2022-07-12
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class TradeInfoServiceImpl extends ServiceImpl<TradeInfoMapper, TradeInfo> implements ITradeInfoService {


    @Override
    public List<TradeInfo> list(TradeInfo tradeInfo) {
        LambdaQueryWrapper<TradeInfo> query = Wrappers.lambdaQuery(tradeInfo);
        String dateTimeRange = tradeInfo.getDateTimeRange();
        if (StringUtils.hasText(dateTimeRange)) {
            String[] split = tradeInfo.splitDateTimeRange();
            query.between(TradeInfo::getPayTime, split[0], split[1]);
        }
        query.orderByAsc(TradeInfo::getPayTime);
        return list(query);
    }

    @Override
    public List<TradeIncomeExpenditure> getIncomeExpenditureByAllMonth() {
        return baseMapper.getIncomeExpenditureByAllMonth();
    }

    @Override
    public double spendingThisMonth() {
        return baseMapper.spendingThisMonth();
    }

    @Override
    public double spendingLastMonth() {
        return baseMapper.spendingLastMonth();
    }

    public void addTradeInfo(TradeInfo tradeInfo) {
        tradeInfo.setRecordSource(TradeInfo.RecordSource.MANUAL.getValue());
        tradeInfo.setCreateTime(new Date());
        save(tradeInfo);
    }
}
