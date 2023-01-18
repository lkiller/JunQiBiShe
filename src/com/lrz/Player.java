package com.lrz;

/**
 * @version 1.0
 * @auther lrz
 * @time 2023/1/9 11:46
 */
public class Player {
    private String color;
    private boolean isDefine = false;

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
}
