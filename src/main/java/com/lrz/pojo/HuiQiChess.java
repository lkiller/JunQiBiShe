/**
 * \* Created with IntelliJ IDEA.
 * \* Author: 土豆
 * \* Date: 2023/2/6
 * \* Time: 22:22
 * \* Description:
 * \
 */
package com.lrz.pojo;

import com.lrz.Chess;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.awt.*;

public class HuiQiChess {
    private int step;
    private String player;//阵营
    private Point startP;
    private Point endP;
    private Chess moveChess;
    private Chess eatedChess;
    private boolean canHuiQi;

    @Override
    public String toString() {
        return "HuiQiChess{" +
                "step=" + step +
                ", player='" + player + '\'' +
                ", startP=" + startP +
                ", endP=" + endP +
                ", moveChess=" + moveChess +
                ", eatedChess=" + eatedChess +
                ", canHuiQi=" + canHuiQi +
                '}';
    }

    public HuiQiChess(int step, String player, Point startP, Point endP, Chess moveChess, Chess eatedChess, boolean canHuiQi) {
        this.step = step;
        this.player = player;
        this.startP = startP;
        this.endP = endP;
        this.moveChess = moveChess;
        this.eatedChess = eatedChess;
        this.canHuiQi = canHuiQi;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Point getStartP() {
        return startP;
    }

    public void setStartP(Point startP) {
        this.startP = startP;
    }

    public Point getEndP() {
        return endP;
    }

    public void setEndP(Point endP) {
        this.endP = endP;
    }

    public Chess getMoveChess() {
        return moveChess;
    }

    public void setMoveChess(Chess moveChess) {
        this.moveChess = moveChess;
    }

    public Chess getEatedChess() {
        return eatedChess;
    }

    public void setEatedChess(Chess eatedChess) {
        this.eatedChess = eatedChess;
    }

    public boolean isCanHuiQi() {
        return canHuiQi;
    }

    public void setCanHuiQi(boolean canHuiQi) {
        this.canHuiQi = canHuiQi;
    }
}