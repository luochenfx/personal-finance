import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/vue-admin-template/table/list',
    method: 'get',
    params
  })
}

export function getDetail(id) {
  return request({
    url: '/sys/baseOrg/detail',
    method: 'get',
    params: { id }
  })
}
