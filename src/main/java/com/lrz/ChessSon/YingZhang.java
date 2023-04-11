package com.lrz.ChessSon;

import com.lrz.Movable;
import com.lrz.Chess;

import java.awt.*;

/**
 * @version 1.0
 * @auther lrz
 * @time 2023/1/7 10:39
 */
public class YingZhang extends Chess implements Movable {
    public YingZhang(String name, String color) {
        super("营长", color, 4);
    }
    public YingZhang(String name, String color, Point p, Boolean show) {
        super("营长", color, p, show);
        this.setLevel(4);
    }


}
