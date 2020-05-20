package com.example.demo59.test;

import com.example.demo59.entity.*;
import com.example.demo59.utils.MD5Util;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
//        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
////        String statement = "com.example.demo59.mapper.UserMapper.save";
////        User user = new User("zhangsan","18995566288","420102200009097890","79877");
////        sqlSession.insert(statement,user);
//        sqlSession.commit();//必须要提交事务
//        sqlSession.close();
//        System.out.println(MD5Util.generatePassword("lishilong"));
//        System.out.println(MD5Util.generatePassword("nieqiushi"));
        System.out.println(MD5Util.generatePassword("password"));

    }
}
