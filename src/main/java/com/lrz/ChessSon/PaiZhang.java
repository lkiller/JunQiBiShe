package com.lrz.ChessSon;

import com.lrz.Chess;
import com.lrz.Movable;

/**
 * @version 1.0
 * @auther lrz
 * @time 2023/1/7 10:40
 */
public class PaiZhang extends Chess implements Movable {
    public PaiZhang(String name, String color) {
        super("排长", color,2);
    }


}
