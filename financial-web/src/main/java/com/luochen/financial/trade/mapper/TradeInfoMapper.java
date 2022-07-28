package com.luochen.financial.trade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luochen.financial.trade.entity.TradeIncomeExpenditure;
import com.luochen.financial.trade.entity.TradeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author luochen
 * @since 2022-07-12
 */
@Mapper
public interface TradeInfoMapper extends BaseMapper<TradeInfo> {

	List<TradeIncomeExpenditure> getIncomeExpenditureByAllMonth();
}
