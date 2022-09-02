package com.luochen.financial.trade.controller;


import com.luochen.financial.trade.entity.TradeIncomeExpenditure;
import com.luochen.financial.trade.entity.WxTransactionRecord;
import com.luochen.financial.trade.service.IWxTransactionRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 微信账单 前端控制器
 * </p>
 *
 * @author luochen
 * @since 2022-07-26
 */
@Api(value = "微信交易记录", tags = "微信")
@RestController
@RequestMapping("/trade/wx")
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class WxTransactionRecordController {


    private final IWxTransactionRecordService wxTransactionRecordService;

    @ApiOperation(value = "所有微信交易记录")
    @GetMapping("/all")
    public List<WxTransactionRecord> all() {
        return wxTransactionRecordService.list();
    }


    @ApiOperation(value = "查询所有转账记录")
    @GetMapping("/list")
    public List<WxTransactionRecord> list(WxTransactionRecord wxTransactionRecord) {
        return wxTransactionRecordService.list(wxTransactionRecord);
    }

    @ApiOperation(value = "获取月度收支信息")
    @GetMapping("/incomeExpenditureByAllMonth")
    public List<TradeIncomeExpenditure> getIncomeExpenditureByAllMonth(){
        return wxTransactionRecordService.getIncomeExpenditureByAllMonth();
    }



    @ApiOperation(value = "获取本月消费金额")
    @GetMapping("/spendingThisMonth")
    public double spendingThisMonth(){
        return wxTransactionRecordService.spendingThisMonth();
    }


}
