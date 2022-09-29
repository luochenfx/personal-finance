import request from '@/utils/request'

const user_info = '/user/user-info'

export function login(data) {
  return request({
    url: user_info + '/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: user_info + '/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: user_info + '/logout',
    method: 'post'
  })
}
