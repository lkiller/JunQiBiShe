package com.lrz.ChessSon;

import com.lrz.Chess;
import com.lrz.Movable;

import java.awt.*;

/**
 * @version 1.0
 * @auther lrz
 * @time 2023/1/7 10:37
 */
public class ShiZhang extends Chess implements Movable {
    public ShiZhang(String name, String color) {
        super("师长", color, 7);
    }
    public ShiZhang(String name, String color, Point p, Boolean show) {
        super("师长", color, p, show);
        this.setLevel(7);
    }

}
