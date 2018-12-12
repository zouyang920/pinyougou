package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;

import java.util.List;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao iAccountDao;

    public void setiAccountDao(IAccountDao iAccountDao) {
        this.iAccountDao = iAccountDao;
    }

    @Override
    public List<Account> findAll() {
        return iAccountDao.findAll();
    }

    @Override
    public void update(Account account) {

        iAccountDao.update(account);
    }

    @Override
    public Account findById(Integer id) {
        return iAccountDao.findById(id);
    }

    @Override
    public void add(Account account) {

        iAccountDao.add(account);
    }

    @Override
    public void delete(Integer id) {

        iAccountDao.delete(id);
    }
}
