import request from '@/utils/request'

const alipay = '/trade/alipay-transaction-record'

export function spendingLastMonth() {
  return request({
    url: alipay + '/spendingLastMonth',
    method: 'get'
  })
}

