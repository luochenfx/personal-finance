package com.luochen.financial.trade.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luochen.financial.trade.entity.AlipayTransactionRecord;
import com.luochen.financial.trade.entity.TradeIncomeExpenditure;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author luochen
 * @since 2022-07-19
 */
@Mapper
public interface AlipayTransactionRecordMapper extends BaseMapper<AlipayTransactionRecord> {

	/**
	 * 按月份查询收支情况
	 * @return 月份和收支
	 */
	List<TradeIncomeExpenditure> getIncomeExpenditureByAllMonth();
}
