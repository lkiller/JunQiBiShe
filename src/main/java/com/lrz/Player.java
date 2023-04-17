package com.lrz;

import java.io.Serializable;

/**
 * @version 1.0
 * @auther lrz
 * @time 2023/1/9 11:46
 */
public class Player implements Serializable {
    private int i;//表示玩家几
    private String color;
    private boolean isDefine = false;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public boolean isDefine() {
        return isDefine;
    }

    public void setDefine(boolean define) {
        isDefine = define;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Player(String color) {
        this.color = color;
    }
    public Player() {
    }

    public Player(int i) {
        this.i = i;
    }

    /*@Override
    public String toString() {
        return "Player{" +
                "i=" + i +
                ", color='" + color + '\'' +
                ", isDefine=" + isDefine +
                '}';
    }*/
}
