package com.lrz.ChessSon;

import com.lrz.Chess;
import com.lrz.Movable;

import java.awt.*;

/**
 * @version 1.0
 * @auther lrz
 * @time 2023/1/7 10:42
 */
public class ZhaDan extends Chess implements Movable {
    public ZhaDan(String name, String color) {
        super("炸弹", color, 10);
    }


}