package com.itheima.service;

import com.itheima.domain.User;

/**
 * Created by crowndint on 2018/11/4.
 */
public interface IUserService {

    public User findUserByUsernameAndPassword(String username, String password);
}
