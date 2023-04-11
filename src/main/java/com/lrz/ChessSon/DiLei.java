package com.lrz.ChessSon;

import com.lrz.Chess;
import com.lrz.Movable;

import java.awt.*;

/**
 * @version 1.0
 * @auther lrz
 * @time 2023/1/7 10:42
 */
public class DiLei extends Chess implements Movable {
    public DiLei(String name, String color) {
        super("地雷", color, 0);
    }
    public DiLei(String name, String color, Point p, Boolean show) {
        super("地雷", color, p, show);
        this.setLevel(0);
    }

    @Override
    //地雷不可移动
    public boolean isAbleMove(Point startP, Point endP) {
        return false;
    }
}
