package com.lrz.ChessSon;

import com.lrz.pojo.Chess;

import java.awt.*;

/**
 * @version 1.0
 * @auther lrz
 * @time 2023/1/7 10:29
 */
public class Siling extends Chess {

    public Siling(String name, String color) {
        super("司令", color, 9);
    }
    public Siling(String name, String color, Point p, Boolean show) {
        super("司令", color, p, show);
        this.setLevel(9);
    }
}
