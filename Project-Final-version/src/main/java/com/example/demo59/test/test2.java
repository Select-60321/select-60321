package com.example.demo59.test;

import com.example.demo59.entity.*;
import com.example.demo59.mapper.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * 一级缓存
 * 二级缓存
 * 三级缓存
 **/
public class test2 {
    public static void main(String[] args) {
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        CarriagesDao carriagesDao = sqlSession.getMapper(CarriagesDao.class);
//        carriagesDao.selectByPrimaryKey()
//        long start = System.currentTimeMillis();
//        JourneysDao journeysDao = sqlSession.getMapper(JourneysDao.class);
//        List<Journeys> list= journeysDao.selectByTrainNumber("D1");
//        long middle = System.currentTimeMillis();
//        for (Journeys journeys : list) {
//            System.out.println(journeys);
//        }
//        long start2 = System.currentTimeMillis();
//        journeysDao.selectByTrainNumber("G77");
//        long end = System.currentTimeMillis();
//        System.out.println(middle - start);
//        System.out.println(end - start2);
        //获取实现接口的代理对象
//        UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
//        List<User> list = userRepository.findAll();
//        for (User user : list) {
//            System.out.println(user);
//        }
//        CarriagesDao carriages = sqlSession.getMapper(CarriagesDao.class);
//        Carriages carriages1 = carriages.selectByPrimaryKey(new CarriagesKey("D1",1));
//        System.out.println(carriages1);
//        AdminsDao adminsDao = sqlSession.getMapper(AdminsDao.class);
//        Users users = new Users(8,"zhangsan","18995566288",
//                "420102200009097890","79877");
//        adminsDao.insertSelective()
//        int result = adminsDao.deleteUsers(users);
//        sqlSession.commit();
//        System.out.println(result);

        AdminsMapper adminsDao = sqlSession.getMapper(AdminsMapper.class);
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        Users users = new Users();
        users.setUserName("lishilong");
//        usersMapper.selectByPrimaryKey(1);
//        users.setPassword("88992233");
//        users.setPhone_number("18995566288");
//        users.setId_card_num("420102200002134014");
//        adminsDao.insertUser(users);
//        Integer a = 22;
//        System.out.println(adminsDao.selectByPrimaryKey(a));
//        Admin admin = new Admin();
//        admin.setAdmin_id(0);
//        admin.setAdmin_name("nqs");
//        adminsDao.selectByDynamicSearching(admin);
        sqlSession.close();
    }
}
