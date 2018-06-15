/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package com.cherry.framework.service.impl;

import com.cherry.framework.dao.UserEntityMapper;
import com.cherry.framework.model.UserEntity;
import com.cherry.framework.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User ServiceImpl
 *
 * @author Leon
 * @version 2018/6/14 17:12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserEntityMapper userEntityMapper;

    /**
     * 新增
     *
     * @param userEntity
     * @return
     */
    @Override
    @Transactional
    public int save(UserEntity userEntity) {
        userEntityMapper.insert(userEntity);
        return userEntity.getUserId();
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public PageInfo<UserEntity> findAllUserList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserEntity> list = userEntityMapper.selectAll();
        PageInfo<UserEntity> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
