package com.lrz.ChessSon;

import com.lrz.pojo.Chess;
import com.lrz.Movable;

import java.awt.*;

/**
 * @version 1.0
 * @auther lrz
 * @time 2023/1/7 10:41
 */
public class LianZhang extends Chess implements Movable {
    public LianZhang(String name, String color) {
        super("连长", color, 3);
    }
    public LianZhang(String name, String color, Point p, Boolean show) {
        super("连长", color, p, show);
        this.setLevel(3);
    }


}
