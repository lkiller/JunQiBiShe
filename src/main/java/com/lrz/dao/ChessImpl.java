package com.lrz.dao;

import com.lrz.pojo.HuiQiChess;

public interface ChessImpl {
    void insert(String name, HuiQiChess huiQiChess);
    HuiQiChess selectStep(int step);
    int deleteById(int step);
}
