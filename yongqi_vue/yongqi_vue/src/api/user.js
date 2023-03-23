import request from '../utils/request'

export default {
    // 添加用户接口
    addUser(user) {
        return request({
            url: '/user',
            method: 'post',
            data: user
        })
    },
     // 删除用户接口
     deleteUser(id) {
        return request({
            url: '/user/' + id,
            method: 'delete'
        })
     },

     // 删除多个用户
     deleteMoreUser(ids) {
        return request({
            url: '/user',
            method: 'delete',
            data: ids
        })
     },

     // 编辑用户接口
     updateUser(user) {
        return request({
            url: '/user',
            method: 'put',
            data: user
        })
     },

     // 查询用户列表
     findUserList(index, size, queryParam) {
        return request({
            url: '/user/' + index + '/' + size,
            method: 'post',
            data: queryParam
        })
     },

     // 根据用户编辑获取用户信息
     getUserInfo(id) {
        return request({
            url: '/user/' + id,
            method: 'get'
        })
     }
}