package com.lrz.ChessSon;

import com.lrz.Chess;
import com.lrz.Movable;

import java.awt.*;

/**
 * @version 1.0
 * @auther lrz
 * @time 2023/1/7 10:43
 */
public class JunQi extends Chess implements Movable {
    public JunQi(String name, String color) {
        super("军旗", color, -1);
    }
    //军旗不可移动
    @Override
    public boolean isAbleMove(Point startP, Point endP) {
        return false;
    }
}
