package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by crowndint on 2018/10/26.
 */
public class AppTest {

    @Test
    public void test1() throws IOException {

        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapperConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();

    }


    @Test
    public void test2() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();



       User user = new User.Builder().setUsername("小泽").setSex("女").setAddress("日本")
                .setBirthday(new Date()).build();
        sqlSession.insert("com.itheima.dao.UserDao.add", user);

        System.out.println(user.getId() +"   "+user.getSex() +"   "+user.getAddress());

//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        userDao.add(user);

        sqlSession.commit();
    }


    @Test
    public void test3() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User.Builder().setUsername("小室友里").setSex("0").setAddress("日本")
                .setBirthday(new Date()).setId(104).build();

        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user);

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.update(queryVo);

        //sqlSession.update("com.itheima.dao.UserDao.update", /*user*/queryVo);
        sqlSession.commit();
    }


    @Test
    public void test4() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.delete(114);

        //User user = new User.Builder().setId(109).build();
        //sqlSession.delete("com.itheima.dao.UserDao.delete", 108);

        sqlSession.commit();
    }


    @Test
    public void test5() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findUserById(104);

        //User user = sqlSession.selectOne("com.itheima.dao.UserDao.findUserById", 107);
        System.out.println(user);

        sqlSession.commit();
    }


    @Test
    public void test6() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findUserByUserName("小");

        //List<User> users = sqlSession.selectList("com.itheima.dao.UserDao.findUserByUserName", "小");
        for (User user : users) {
            System.out.println(user);
        }


        sqlSession.commit();
    }

    @Test
    public void test7() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int total = sqlSession.selectOne("com.itheima.dao.UserDao.findTotal");
        System.out.println(total);


        sqlSession.commit();
    }



}
