package com.testa.usermanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.testa.usermanager.db.entity.User;
import com.testa.usermanager.vo.QueryParam;
import com.testa.usermanager.vo.R;

import java.util.List;

public interface UserService extends IService<User> {
    /**
     * 添加用户
     * @param user
     * @return
     */
    R insertUser(User user);

    /**
     * 删除单个用户
     * @param id 用户编号
     * @return
     */
    R deleteUser(Integer id);

    /**
     * 删除多个用户
     * @param ids 用户编号集合
     * @return
     */
    R deleteUsers(List<Integer> ids);

    /**
     * 编辑用户
     * @param user
     * @return
     */
    R updateUser(User user);

    /**
     * 分页查询用户列表
     * @param index 当前页
     * @param size 每页显示数量
     * @param queryParam 筛选条件对象
     * @return
     */
    R findUserList(Integer index, Integer size, QueryParam queryParam);

    /**
     * 查询单个用户详细信息
     * @param id 用户编号
     * @return
     */
    R getUserInfoById(Integer id);
}
