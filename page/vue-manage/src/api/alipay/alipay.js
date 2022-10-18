import request from '@/utils/request'

const alipay = '/trade/alipay-transaction-record'

export function spendingLastMonth() {
  return request({
    url: alipay + '/spendingLastMonth',
    method: 'get'
  })
}

export function incomeExpenditureByLastMonth() {
  return request({
    url: alipay + '/incomeExpenditureByLastMonth',
    method: 'get'
  })
}
