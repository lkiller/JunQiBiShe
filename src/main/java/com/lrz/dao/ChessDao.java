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
    static SqlSession sqlSession =SqlSessionUtils.openSession();
    Chess chess = null;
    @Override
    public void insert(String name, HuiQiChess huiQiChess) {
        int insert = sqlSession.insert(name, huiQiChess);
        sqlSession.commit();
        System.out.println("chessDao插入数据库" + insert + "条记录");

    }

    @Override
    public HuiQiChess selectStep(int step) {
        Object selectByStep = sqlSession.selectOne("selectByStep",step);
        return (HuiQiChess)selectByStep;
    }

    @Override
    public int deleteById(int step) {
        int count = sqlSession.delete("deleteById", step);
        System.out.println("ChessDao删除" + count + "条记录");
        sqlSession.commit();
        return count;
    }


    public void start(){
        sqlSession.delete("start");
        sqlSession.commit();
    }
}
