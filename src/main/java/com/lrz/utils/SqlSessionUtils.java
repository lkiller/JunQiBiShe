/**
 * \* Created with IntelliJ IDEA.
 * \* Author: 土豆
 * \* Date: 2023/2/7
 * \* Time: 9:23
 * \* Description:
 * \
 */
package com.lrz.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionUtils{
    private  SqlSessionUtils(){}
    static SqlSessionFactory build = null;
    static{
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            build = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static SqlSession openSession(){
        return build.openSession();
    }
}
