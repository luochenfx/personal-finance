package com.luochen.financial.trade.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.luochen.financial.trade.entity.AlipayTransactionRecord;
import com.luochen.financial.trade.entity.TradeIncomeExpenditure;
import com.luochen.financial.trade.service.IAlipayTransactionRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luochen
 * @since 2022-07-19
 */
@Api(tags = "支付宝交易记录")
@RestController
@RequestMapping("/trade/alipay-transaction-record")
public class AlipayTransactionRecordController {

	@Autowired
	private IAlipayTransactionRecordService alipayTransactionRecordService;

	@ApiOperation(value = "所有支付宝交易记录")
	@GetMapping("/all")
	public List<AlipayTransactionRecord> all() {
		return alipayTransactionRecordService.list();
	}

	@ApiOperation(value = "支付宝收入记录")
	@GetMapping("/income")
	public List<AlipayTransactionRecord> getIncome(){
		LambdaQueryWrapper<AlipayTransactionRecord> query = Wrappers.lambdaQuery();
		query.eq(AlipayTransactionRecord::getIncomeExpenditure, AlipayTransactionRecord.IncomeExpenditure.INCOME.getValue());
		query.orderByDesc(AlipayTransactionRecord::getPayTime);
		return alipayTransactionRecordService.list(query);
	}

	@ApiOperation(value = "支付宝支出记录")
	@GetMapping("/expenditure")
	public List<AlipayTransactionRecord> getExpenditure(){
		LambdaQueryWrapper<AlipayTransactionRecord> query = Wrappers.lambdaQuery();
		query.eq(AlipayTransactionRecord::getIncomeExpenditure, AlipayTransactionRecord.IncomeExpenditure.EXPENDITURE.getValue());
		query.orderByDesc(AlipayTransactionRecord::getPayTime);
		return alipayTransactionRecordService.list(query);
	}

	@ApiOperation(value = "支付宝本月收支统计")
	@GetMapping("/incomeExpenditureByAllMonth")
	public List<TradeIncomeExpenditure> getIncomeExpenditureByAllMonth(){
		return alipayTransactionRecordService.getIncomeExpenditureByAllMonth();
	}

	/**
	 * 查询所有的转账记录
	 * @return 转账记录列表
	 */
	@ApiOperation(value = "查询所有的转账记录")
	@GetMapping("/fundTransferOfAll")
	public List<AlipayTransactionRecord> fundTransferOfAll(){
		return alipayTransactionRecordService.fundTransferOfAll();
	}



	@ApiOperation(value = "资金转移状态统计")
	@GetMapping("/statisticsByFundStatus")
	public List<Map<String, Object>> statisticsByFundStatus(){
		return alipayTransactionRecordService.statisticsByFundStatus();
	}

	@ApiOperation(value = "获取本月消费金额")
	@GetMapping("/spendingThisMonth")
	public double spendingThisMonth(){
		return alipayTransactionRecordService.spendingThisMonth();
	}

	@ApiOperation(value = "账单上传")
	@PostMapping("/upload")
	public void uploadFile(String fileName, MultipartFile file){

	}

//	private List<TemplateEntity> getTemplateEntities(MultipartFile file) throws IOException {
//		TemplateListener listener = new TemplateListener();	// 定义的 listener
//		EasyExcel.read(file.getInputStream(), TemplateEntity.class, listener).sheet().doRead();
//
//		// 返回 所有数据
//		return listener.getData();
//	}

}
