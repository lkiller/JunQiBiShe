/**
 * \* Created with IntelliJ IDEA.
 * \* Author: 土豆
 * \* Date: 2023/2/11
 * \* Time: 21:22
 * \* Description:
 * \
 */
package com.lrz.pojo;

public class saveChessList {
    private String tableName;
    private int id;//外键
    private int chessId;
    private String chessName;
    private String chessColor;
    private int chessPointX;
    private int chessPointY;
    private boolean chessShow;

    public saveChessList(String tableName,  int id, String chessName, String chessColor, int chessPointX, int chessPointY, boolean chessShow) {
        this.tableName = tableName;
        this.id = id;
        this.chessName = chessName;
        this.chessColor = chessColor;
        this.chessPointX = chessPointX;
        this.chessPointY = chessPointY;
        this.chessShow = chessShow;
    }

    public int getChessId() {
        return chessId;
    }

    public void setChessId(int chessId) {
        this.chessId = chessId;
    }

    @Override
    public String toString() {
        return "saveChessList{" +
                "id=" + id +
                ", name='" + chessName + '\'' +
                ", chessColor='" + chessColor + '\'' +
                ", chessPointX=" + chessPointX +
                ", chessPointY=" + chessPointY +
                ", chessShow=" + chessShow +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChessName() {
        return chessName;
    }

    public void setChessName(String name) {
        this.chessName = name;
    }

    public String getChessColor() {
        return chessColor;
    }

    public void setChessColor(String chessColor) {
        this.chessColor = chessColor;
    }

    public int getChessPointX() {
        return chessPointX;
    }

    public void setChessPointX(int chessPointX) {
        this.chessPointX = chessPointX;
    }

    public int getChessPointY() {
        return chessPointY;
    }

    public void setChessPointY(int chessPointY) {
        this.chessPointY = chessPointY;
    }

    public boolean isChessShow() {
        return chessShow;
    }

    public void setChessShow(boolean chessShow) {
        this.chessShow = chessShow;
    }
}
