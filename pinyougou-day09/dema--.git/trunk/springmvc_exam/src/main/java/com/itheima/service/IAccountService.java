package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

/**
 * 账户业务层的接口
 */
public interface IAccountService {

    /**
     * 模拟保存账户
     */
    List<Account> findAll();

    void update(Account account);

    Account findById(Integer id);

    void add(Account account);

    void delete(Integer id);
}
