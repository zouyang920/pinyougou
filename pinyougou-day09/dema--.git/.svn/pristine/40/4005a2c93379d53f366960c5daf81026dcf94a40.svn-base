package com.itheima.factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by crowndint on 2018/10/31.
 */
public class DaoFactory {

    private Class daoClass;

    public DaoFactory(Class daoClass) {
        this.daoClass = daoClass;
    }

    public Object createDao() {

        try {
            InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            SqlSession session = factory.openSession(true);
            return session.getMapper(daoClass);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
