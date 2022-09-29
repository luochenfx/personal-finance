import request from '@/utils/request'

const wx = '/trade/wx'

export function spendingLastMonth() {
  return request({
    url: wx + '/spendingLastMonth',
    method: 'get'
  })
}

