package com.lrz.dao;

import com.lrz.Chess;
import com.lrz.pojo.HuiQiChess;

public interface ChessImpl {
    void insert(String name, HuiQiChess huiQiChess);
    Chess selectStep();
}
