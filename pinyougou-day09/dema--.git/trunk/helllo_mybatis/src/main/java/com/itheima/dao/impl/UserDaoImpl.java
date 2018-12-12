package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by crowndint on 2018/10/26.
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public List<User> findAll() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("com.itheima.dao.UserDao.findAll");
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void update(QueryVo queryVo) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User findUserById(int id) {
        return null;
    }

    @Override
    public List<User> findUserByUserName(String username) {
        return null;
    }


}
