package com.lrz.ChessSon;

import com.lrz.Chess;
import com.lrz.Movable;

import java.awt.*;

/**
 * @version 1.0
 * @auther lrz
 * @time 2023/1/7 10:38
 */
public class LvZhang extends Chess implements Movable {
    public LvZhang(String name, String color) {
        super("旅长", color, 6);
    }
    public LvZhang(String name, String color, Point p, Boolean show) {
        super("旅长", color, p, show);
        this.setLevel(6);
    }


}