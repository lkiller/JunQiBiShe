package com.lrz.ChessSon;

import com.lrz.Chess;
import com.lrz.Movable;

import java.awt.*;

/**
 * @version 1.0
 * @auther lrz
 * @time 2023/1/7 10:36
 */
public class JunZhang extends Chess implements Movable {
    public JunZhang(String name, String color) {
        super("军长", color, 8);
    }
    public JunZhang(String name, String color, Point p, Boolean show) {
        super("军长", color, p, show);
        this.setLevel(8);
    }

}