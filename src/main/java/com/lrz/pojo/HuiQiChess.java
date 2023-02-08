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
    private String moveChessC;
    private String eatedChessC;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public HuiQiChess(int step, String player, Point startP, Point endP, Chess moveChess, Chess eatedChess, Boolean canHuiQi) {
        this.step = step;
        this.player = player;
        this.startP = startP;
        this.endP = endP;
        this.moveChess = moveChess;
        this.eatedChess = eatedChess;
        this.canHuiQi = canHuiQi;
    }

    public HuiQiChess(int step, String player, int startX,int startY, int  endX,int endY, String moveChessC, String eatedChessC,boolean canHuiQi ) {
        this.step = step;
        this.player = player;
        this.startP = new Point(startX, startY);
        this.endP = new Point(endX, endY);
        this.canHuiQi = canHuiQi;
        this.moveChessC = moveChessC;
        this.eatedChessC = eatedChessC;
    }

    public void setMoveChessC(String moveChessC) {
        this.moveChessC = moveChessC;
    }

    public void setEatedChessC(String eatedChessC) {
        this.eatedChessC = eatedChessC;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

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
                ", moveChessC='" + moveChessC + '\'' +
                ", eatedChessC='" + eatedChessC + '\'' +
                ", startX=" + startX +
                ", startY=" + startY +
                ", endX=" + endX +
                ", endY=" + endY +
                '}';
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

    public String getMoveChess() {
        if (moveChess != null) {
            return moveChess.getColor() + moveChess.getName();
        }
        return "空";
    }

    public String getMoveChessC() {
        return moveChessC;
    }

    public void setMoveChess(Chess moveChess) {
        this.moveChess = moveChess;
    }

    public String getEatedChess() {
        //return eatedChess;
        if (eatedChess != null) {
            return eatedChess.getColor() + eatedChess.getName();
        }
        return "空";
    }

    public String getEatedChessC() {
        return eatedChessC;
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

    public int getStartPx() {
        if (startP != null) {
            return startP.x;
        }
        return -1;
    }

    public int getEndPx() {
        if (endP != null) {
            return endP.x;
        }
        return -1;
    }

    public int getStartPy() {
        if (startP != null) {
            return startP.y;
        }
        return -1;
    }

    public int getEndPy() {
        if (endP != null) {
            return endP.y;
        }
        return -1;
    }

}
