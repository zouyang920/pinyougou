package com.itheima.service.impl;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.springframework.util.StringUtils;

/**
 * Created by crowndint on 2018/11/4.
 */
public class UserServiceImpl implements IUserService {

    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {

            return null;
        }

        return this.userDao.findUserByUsernameAndPassword(username, password);
    }




}
