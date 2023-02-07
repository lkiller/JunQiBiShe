/**
 * \* Created with IntelliJ IDEA.
 * \* Author: 土豆
 * \* Date: 2023/2/7
 * \* Time: 9:35
 * \* Description:
 * \
 */
package com.lrz.dao;

import com.lrz.Chess;
import com.lrz.pojo.HuiQiChess;
import com.lrz.utils.SqlSessionUtils;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

public class ChessDao implements ChessImpl{

    Chess chess = null;
    @Override
    public void insert(String name, HuiQiChess huiQiChess) {
        SqlSession sqlSession =SqlSessionUtils.openSession();
        int insert = sqlSession.insert(name, huiQiChess);
        sqlSession.commit();
        System.out.println("chessDao插入数据库" + insert + "条记录");

    }

    @Override
    public Chess selectStep() {
        return null;
    }
    public void start(){
        SqlSession sqlSession =SqlSessionUtils.openSession();
       sqlSession.select("start", (ResultHandler) chess);
        sqlSession.commit();
    }
}
