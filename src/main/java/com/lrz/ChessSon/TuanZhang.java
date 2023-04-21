package com.lrz.ChessSon;

import com.lrz.pojo.Chess;
import com.lrz.Movable;

import java.awt.*;

/**
 * @version 1.0
 * @auther lrz
 * @time 2023/1/7 10:38
 */
public class TuanZhang extends Chess implements Movable {
    public TuanZhang(String name, String color) {
        super("团长", color, 5);
    }
    public TuanZhang(String name, String color, Point p, Boolean show) {
        super("团长", color, p, show);
        this.setLevel(5);
    }


}
