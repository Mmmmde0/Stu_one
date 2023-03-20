package com.testa.usermanager.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.testa.usermanager.db.entity.User;
import com.testa.usermanager.vo.QueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 查询用户列表
     * @param page 分页对象
     * @param queryParam 筛选条件
     * @return
     */
    IPage<User> findUserList(Page<User> page, QueryParam queryParam);
}
