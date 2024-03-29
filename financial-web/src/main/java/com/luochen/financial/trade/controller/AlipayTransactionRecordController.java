package com.luochen.financial.trade.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.luochen.financial.base.Response;
import com.luochen.financial.filter.ResponseResult;
import com.luochen.financial.trade.entity.AlipayTransactionRecord;
import com.luochen.financial.trade.entity.TradeIncomeExpenditure;
import com.luochen.financial.trade.service.IAlipayTransactionRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
@Slf4j
@Api(value = "支付宝交易记录", tags = "支付宝")
@RestController
@RequestMapping("/trade/alipay-transaction-record")
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class AlipayTransactionRecordController {

    private final IAlipayTransactionRecordService alipayTransactionRecordService;

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

    @ApiOperation(value = "支付宝上月收支统计", notes = "按月份查询收支情况")
    @GetMapping("/incomeExpenditureByLastMonth")
    public List<TradeIncomeExpenditure> getIncomeExpenditureByLastMonth(){
        return alipayTransactionRecordService.getIncomeExpenditureByLastMonth();
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

    @ApiOperation(value = "获取上个月消费金额")
    @GetMapping("/spendingLastMonth")
    public double spendingLastMonth(){
        return alipayTransactionRecordService.spendingLastMonth();
    }

    @ApiOperation(value = "账单上传")
    @PostMapping("/upload")
    @ResponseResult
    public Response uploadFile(@RequestParam("file") MultipartFile file){
        try {
            alipayTransactionRecordService.fileRead(file);
            return Response.success();
        } catch (IOException e) {
            return Response.fail(e.getMessage());
        }
    }



}
