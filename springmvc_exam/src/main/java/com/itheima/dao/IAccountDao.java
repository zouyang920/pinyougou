package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {

    List<Account> findAll();

    void update(Account account);

    Account findById(Integer id);

    void add(Account account);

    void delete(Integer id);
}
