package com.lrz;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * @version 1.0
 * @auther lrz
 * @time 2023/1/4 21:26
 */
public class Chess implements Movable{
    private static final int SIZEX = 100;
    private static final int SIZEY = 50;
    private static final int MARGIN = 40;//边距
    private static final int SPACEX = 145;//X轴间距
    private static final int SPACEY = 70;//Y轴间距
    private String name;//名称
    private int level;//棋子大小
    private String color;//阵营
    private boolean show;//是否展示
    private int x, y;//真实坐标
    private Point p;//相对坐标

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public int getX() {
            return MARGIN + (p.x - 1) * SPACEX;
    }

    /**
     * 通过点击的像素位置获取棋子坐标
     * @param x
     * @param y
     * @return
     */
    public static Point getPointFromXY(int x, int y){
        Point p = new Point();
        p.x  = (x - MARGIN) / SPACEX + 1;
        if(y < 584){
            p.y  = (y - MARGIN) / SPACEY + 1;
        }else{
            p.y = (y - MARGIN + 30) / SPACEY + 1;
        }
        return p;
    }

    /**
     * 绘制点击棋子的边框
     * @param g
     */
    public void drawMargin(Graphics g){
        g.fill3DRect(this.getX(), this.getY(), SIZEX/4, SIZEY/4,true);
    }

    /**
     * 通过坐标获取棋子
     * @param p
     * @param chessList
     * @return
     */
    public static Chess getChessByPoint(Point p, ArrayList<Chess> chessList){
        for (Chess chess : chessList) {
            if(p.x == chess.getP().x && p.y == chess.getP().y){
                return chess;
            }
        }
       return null;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        if(p.y < 7)
            return MARGIN + (p.y - 1) * SPACEY;
        else
            return MARGIN - 15 + (p.y - 1) * SPACEY;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }

    public Chess(String name, String color, int level) {
        this.name = name;
        this.color = color;
        this.level = level;
    }

    /**
     * 画出棋子
     * @param g
     * @param jPanel
     */
    public void draw(Graphics g, JPanel jPanel){
        String path = "lib\\" + color + this.name + ".png";
        Image image = Toolkit.getDefaultToolkit().getImage(path);
        g.drawImage(image, getX(), getY(), SIZEX, SIZEY, jPanel);
    }

    /**
     * 画棋子背面
     * @param g
     * @param jPanel
     */
    public void drawUnknown(Graphics g, JPanel jPanel){
        String path = "lib\\" + "Unknown.png";
        Image image = Toolkit.getDefaultToolkit().getImage(path);
        g.drawImage(image, getX(), getY(), SIZEX, SIZEY, jPanel);
    }

    /**
     * 是否只能上下左右移动
     * @param startP
     * @param endP
     * @return
     */
    public static boolean justUpDownLeftRight(Point startP, Point endP){
        return (Math.abs(startP.getX() - endP.getX()) + Math.abs(startP.getY() - endP.getY())) == 1;
    }

    /**
     * 行营中的棋子移动范围
     * @param startP
     * @param endP
     * @return
     */
    public static boolean xingYing(Point startP, Point endP){
        return Math.abs(startP.getX() - endP.getX()) == 1 || Math.abs(startP.getY() - endP.getY() ) == 1;
    }

    /**
     * 在棋盘上可移动的位置
     * 供司令、军长、师长、旅长、团长、营长、连长、排长、炸弹使用，
     * 地雷、军旗不可动
     * 工兵需要重写
     * @param startP
     * @param endP
     * @return
     */
    @Override
    public boolean isAbleMove(Point startP, Point endP) {
        //行营
        if((startP.getX() == 2 && startP.getY() == 3) || (startP.getX() == 4 && startP.getY() == 3)||
                (startP.getX() == 3 && startP.getY() == 4) ||
                (startP.getX() == 2 && startP.getY() == 5) || (startP.getX() == 4 && startP.getY() == 5)||
                (startP.getX() == 2 && startP.getY() == 10) || (startP.getX() == 4 && startP.getY() == 10)||
                (startP.getX() == 3 && startP.getY() == 11) ||
                (startP.getX() == 2 && startP.getY() == 12) || (startP.getX() == 4 && startP.getY() == 12)){
            return xingYing(startP, endP);
        }
        //第一行以及最后一行
        if (startP.getY() == 1 || startP.getY() == 14) {
            return Chess.justUpDownLeftRight(startP, endP);
        }
        //第二行不带行营
        if (startP.getY() == 2) {
            //第二行第一个
            if (startP.getX() == 1) {
                //目标在第二行都可以移动
                if (endP.getY() == 2 && endP.getX() != 1) {
                    return true;
                }
                //目标在第一列 第二到第六行 第九到第十三行都可以移动
                if (endP.getX() == 1 && ((endP.getY() <= 6 && endP.getY() >= 2)
                        ||
                        (endP.getY() >= 9 && endP.getY() <= 13))) {
                    return true;
                }
                //目标行营或者1、1
                if ((endP.getX() == 2 && endP.getY() == 3) || (endP.getX() == 1 && endP.getY() == 1))
                    return true;
            }
            //第二行  第二个
            else if(startP.getX() == 2) {
                //目标位置在第二行都可以
                if(endP.getY() ==2 && endP.getX() != 2){
                    return true;
                }
                //左边一个  下面一个 上面一个可以
                if((endP.getX() == 2 && endP .getY() == 3)|| (endP.getX() == 2 && endP .getY() == 1)){
                    return true;
                }
            }
            //第二行  第四个
            else if(startP.getX() == 4) {
                //目标位置在第二行都可以
                if(endP.getY() ==2 && endP.getX() != 4){
                    return true;
                }
                //上面一个 下面一个可以
                if((endP.getX() == 4 && endP .getY() == 1) || (endP.getX() == 4 && endP .getY() == 3)){
                    return true;
                }
            }
            //第二行 第三个
            else if (startP.getX() == 3) {
                //目标在上下左右以及两个行营
                if (Math.abs(startP.getX() - endP.getX()) + Math.abs(startP.getY() - endP.getY()) == 1)
                    return true;
                if ((endP.getY() == 3 && endP.getX() == 2) || (endP.getY() == 3 && endP.getX() == 4)) {
                    return true;
                }
            }
            //第二行第五个
            else if (startP.getX() == 5) {
                //目标在第二行都可以移动
                if (endP.getY() == 2 && endP.getX() != 5) {
                    return true;
                }
                //目标在第一列 第二到第六行 第九到第十三行都可以移动
                if (endP.getX() == 5 && ((endP.getY() <= 6 && endP.getY() >= 2)
                        ||
                        (endP.getY() >= 9 && endP.getY() <= 13))) {
                    return true;
                }
                //目标行营或者5、1
                if ((endP.getX() == 4 && endP.getY() == 3) || (endP.getX() == 5 && endP.getY() == 1))
                    return true;
            }
        }
        //第十三行不带行营
        if (startP.getY() == 13) {
            //第十三行第一个
            if (startP.getX() == 1) {
                //目标在第十三行都可以移动
                if (endP.getY() == 13 && endP.getX() != 1) {
                    return true;
                }
                //目标在第一列 第二到第六行 第九到第十三行都可以移动
                if (endP.getX() == 1 && ((endP.getY() <= 6 && endP.getY() >= 2)
                        ||
                        (endP.getY() >= 9 && endP.getY() <= 13))) {
                    return true;
                }
                //目标行营或者14、1
                if ((endP.getX() == 2 && endP.getY() == 12) || (endP.getX() == 1 && endP.getY() == 14))
                    return true;
            }
            //第十三行  第二个
            else if(startP.getX() == 2) {
                //目标位置在第二行都可以
                if(endP.getY() == 13 && endP.getX() != 2){
                    return true;
                }
                //左边一个  上面一个 下面一个可以
                if((endP.getX() == 2 && endP .getY() == 12) || (endP.getX() == 2 && endP .getY() == 14)){
                    return true;
                }
            }
            //第十三行  第四个
            else if(startP.getX() == 4) {
                //目标位置在第二行都可以
                if(endP.getY() == 13 && endP.getX() != 4){
                    return true;
                }
                //上面一个 下面一个可以
                if((endP.getX() == 4 && endP .getY() == 12) || (endP.getX() == 4 && endP .getY() == 14)){
                    return true;
                }
            }
            //第十三行 第三个
            else if (startP.getX() == 3) {
                //目标在上下左右以及两个行营
                if (Math.abs(startP.getX() - endP.getX()) + Math.abs(startP.getY() - endP.getY()) == 1)
                    return true;
                if ((endP.getY() == 12 && endP.getX() == 2) || (endP.getY() == 12 && endP.getX() == 4)) {
                    return true;
                }
            }
            //第十三行第五个
            else if (startP.getX() == 5) {
                //目标在第十三行都可以移动
                if (endP.getY() == 13 && endP.getX() != 5) {
                    return true;
                }
                //目标在第五列 第二到第六行 第九到第十三行都可以移动
                if (endP.getX() == 5 && ((endP.getY() <= 6 && endP.getY() >= 2)
                        ||
                        (endP.getY() >= 9 && endP.getY() <= 13))) {
                    return true;
                }
                //目标行营或者5、14
                if ((endP.getX() == 4 && endP.getY() == 12) || (endP.getX() == 5 && endP.getY() == 14))
                    return true;
            }
        }

        //第三行不带行营
        if(startP.getY() == 3){
            //第三行第三列
            if(startP.getX() == 3){
                return Chess.justUpDownLeftRight(startP, endP);
            }
            //第三行第一列
            if(startP.getX() == 1){
                if((endP.getX() == 1 && endP.getY() <= 6 && endP.getY() >= 2) ||
                        (endP.getX() == 1 && endP.getY() <= 13 && endP.getY() >= 9)){
                    return true;
                }
                if(endP.getY() == 3 && endP.getX() == 2){
                    return true;
                }
            }
            //第三行第五列
            if(startP.getX() == 5){
                if((endP.getX() == 5 && endP.getY() <= 6 && endP.getY() >= 2) ||
                        (endP.getX() == 5 && endP.getY() <= 13 && endP.getY() >= 9)){
                    return true;
                }
                if(endP.getY() == 3 && endP.getX() == 4){
                    return true;
                }
            }
        }
        //第十二行不带行营
        if(startP.getY() == 12){
            //第十二行第三列
            if(startP.getX() == 3){
                return Chess.justUpDownLeftRight(startP, endP);
            }
            //第十二行第一列
            if(startP.getX() == 1){
                //可以在一列上行动
                if((endP.getX() == 1 && endP.getY() <= 6 && endP.getY() >= 2) ||
                        (endP.getX() == 1 && endP.getY() <= 13 && endP.getY() >= 9)){
                    return true;
                }
                //可进行营
                if(endP.getY() == 12 && endP.getX() == 2){
                    return true;
                }
            }
            //第十二行第五列
            if(startP.getX() == 5){
                if((endP.getX() == 1 && endP.getY() <= 6 && endP.getY() >= 2) ||
                        (endP.getX() == 1 && endP.getY() <= 13 && endP.getY() >= 9)){
                    return true;
                }
                if(endP.getY() == 12 && endP.getX() == 4){
                    return true;
                }
            }
        }

        //第四行不带行营
        if(startP.getY() == 4){
            //第四行第一列
            if((startP.getX() == 1)){
                if((endP.getX() == 1 && endP.getY() <= 6 && endP.getY() >= 2) ||
                        (endP.getX() == 1 && endP.getY() <= 13 && endP.getY() >= 9)){
                    return true;
                }
                //可进上下两个斜着的行营
                if((endP.getY() == 3 || endP.getY() == 5) && endP.getX() == 2){
                    return true;
                }
            }
            //第四行 第二列第四列
            if(startP.getX() == 2 || startP.getX() == 4){
                return Chess.justUpDownLeftRight(startP, endP);
            }
            //第四行第五列
            if(startP.getX() == 5){
                if((endP.getX() == 5 && endP.getY() <= 6 && endP.getY() >= 2) ||
                        (endP.getX() == 5 && endP.getY() <= 13 && endP.getY() >= 9)){
                    return true;
                }
                //可进上下两个斜着的行营
                if((endP.getY() == 3 || endP.getY() == 5) && endP.getX() == 4){
                    return true;
                }
            }
        }
        //第十一行不带行营
        if(startP.getY() == 11){
            //第十一行第一列
            if((startP.getX() == 1)){
                if((endP.getX() == 1 && endP.getY() <= 6 && endP.getY() >= 2) ||
                        (endP.getX() == 1 && endP.getY() <= 13 && endP.getY() >= 9)){
                    return true;
                }
                //可进上下两个斜着的行营
                if((endP.getY() == 10 || endP.getY() == 12) && endP.getX() == 2){
                    return true;
                }
            }
            //第十一行 第二列第四列
            if(startP.getX() == 2 || startP.getX() == 4){
                return Chess.justUpDownLeftRight(startP, endP);
            }
            //第十一行第五列
            if(startP.getX() == 5){
                if((endP.getX() == 5 && endP.getY() <= 6 && endP.getY() >= 2) ||
                        (endP.getX() == 5 && endP.getY() <= 13 && endP.getY() >= 9)){
                    return true;
                }
                //可进上下两个斜着的行营
                if((endP.getY() == 10 || endP.getY() == 12) && endP.getX() == 4){
                    return true;
                }
            }
        }


        //第五行不带行营
        if (startP.getY() == 5){
            //第五行第三列
            if(startP.getX() == 3){
                return Chess.justUpDownLeftRight(startP,endP);
            }
            //第五行第一列
            if(startP.getX() == 1){
                if((endP.getX() == 1 && endP.getY()<= 13 && endP.getY() >= 9)||
                        (endP.getX() == 1 && endP.getY()<= 6 && endP.getY() >=2)){
                    return true;
                }
                //可进行营
                if(endP.getY() == 5 && endP.getX() == 2){
                    return true;
                }
            }
            //第五行第五列
            if(startP.getX() == 5){
                if((endP.getX() == 5 && endP.getY() <= 6 && endP.getY() >= 2) ||
                        (endP.getX() == 5 && endP.getY() <= 13 && endP.getY() >= 9)){
                    return true;
                }
                //可进行营
                if(endP.getY() == 5 && endP.getX() == 4){
                    return true;
                }
            }
        }
        //第十行不带行营
        if (startP.getY() == 10){
            //第十行第三列
            if(startP.getX() == 3){
                return Chess.justUpDownLeftRight(startP,endP);
            }
            //第十行第一列
            if(startP.getX() == 1){
                if((endP.getX() == 1 && endP.getY()<= 13 && endP.getY() >= 9)||
                        (endP.getX() == 1 && endP.getY()<= 6 && endP.getY() >=2)){
                    return true;
                }
                //可进行营
                if(endP.getY() == 10 && endP.getX() == 2){
                    return true;
                }
            }
            //第十行第五列
            if(startP.getX() == 5){
                if((endP.getX() == 5 && endP.getY() <= 6 && endP.getY() >= 2) ||
                        (endP.getX() == 5 && endP.getY() <= 13 && endP.getY() >= 9)){
                    return true;
                }
                //可进行营
                if(endP.getY() == 10 && endP.getX() == 4){
                    return true;
                }
            }
        }

        //第六行不带行营
        if(startP.getY() == 6){
            //第六行第一列
            if(startP.getX() == 1){
                if((endP.getX() == 1 && endP.getY() >= 2 && endP.getY() <= 5)  ||
                        (endP.getX() == 1 && endP.getY() >= 9 && endP.getY() <= 13))
                    return true;
                if(endP.getY() == 6 && endP.getX() >= 2 && endP.getX() <= 5 ){
                    return true;
                }
                if(endP.getX() == 2 && endP.getY() == 5){
                    return true;
                }
            }
            //第六行第二列{
            if(startP.getX() == 2){
                //可进行营和左边一个
                if((endP.getX() == 2 && endP.getY() == 5) || (endP.getX() == 1 && endP.getY() == 6)){
                    return true;
                }
                //可向右
                if(endP.getY() == 6 && endP.getX() >= 2 && endP.getX() <= 5){
                    return true;
                }
            }
            //第六行第三列
            if(startP.getX() == 3){
                //可进行营
                if((endP.getX() == 2 && endP.getY() == 5) || (endP.getX() == 4 && endP.getY() == 5)) {
                    return true;
                }
                //可向左向右
                if(endP.getY() == 6 && (endP.getX() == 1 || endP.getX() == 2 || endP.getX() == 4 ||endP.getX() == 5)){
                    return true;
                }
                //可向上
                if(endP.getY() == 9 && endP.getX() == 3){
                    return true;
                }
            }
            //第六行第四列{
            if(startP.getX() == 4){
                //可进行营和右边一个
                if((endP.getX() == 4 && endP.getY() == 5) || (endP.getX() == 5 && endP.getY() == 6)){
                    return true;
                }
                //可向左三个
                if(endP.getY() == 6 && endP.getX() >= 1 && endP.getX() <= 3){
                    return true;
                }
            }
            //第六行第五列
            if(startP.getX() == 5){
                //可以向上向下
                if((endP.getX() == 5 && endP.getY() >= 2 && endP.getY() <= 5)  ||
                        (endP.getX() == 5 && endP.getY() >= 9 && endP.getY() <= 13))
                    return true;
                //可以向左向右
                if(endP.getY() == 6 && endP.getX() >= 1 && endP.getX() <= 4 ){
                    return true;
                }
                //可进行营
                if(endP.getX() == 4 && endP.getY() == 5){
                    return true;
                }
            }
        }
        //第九行不带行营
        if(startP.getY() == 9){
            //第九行第一列
            if(startP.getX() == 1){
                //可向上向下
                if((endP.getX() == 1 && endP.getY() >= 2 && endP.getY() <= 6)  ||
                        (endP.getX() == 1 && endP.getY() >= 10 && endP.getY() <= 13))
                    return true;
                //可向右
                if(endP.getY() == 9 && endP.getX() >= 2 && endP.getX() <= 5 ){
                    return true;
                }
                //可进行营
                if(endP.getX() == 2 && endP.getY() == 10){
                    return true;
                }
            }
            //第九行第二列{
            if(startP.getX() == 2){
                //可进行营和左边一个
                if((endP.getX() == 2 && endP.getY() == 10) || (endP.getX() == 1 && endP.getY() == 9)){
                    return true;
                }
                //可向右
                if(endP.getY() == 9 && endP.getX() >= 2 && endP.getX() <= 5){
                    return true;
                }
            }
            //第九行第三列
            if(startP.getX() == 3){
                //可进行营
                if((endP.getX() == 2 && endP.getY() == 10) || (endP.getX() == 4 && endP.getY() == 10)) {
                    return true;
                }
                //可向左向右
                if(endP.getY() == 9 && (endP.getX() == 1 || endP.getX() == 2 || endP.getX() == 4 ||endP.getX() == 5)){
                    return true;
                }
                //可向上
                if(endP.getY() == 6 && endP.getX() == 3){
                    return true;
                }
            }
            //第九行第四列{
            if(startP.getX() == 4){
                //可进行营和右边一个
                if((endP.getX() == 4 && endP.getY() == 10) || (endP.getX() == 5 && endP.getY() == 10)){
                    return true;
                }
                //可向左三个
                if(endP.getY() == 9 && endP.getX() >= 1 && endP.getX() <= 3){
                    return true;
                }
            }
            //第九行第五列
            if(startP.getX() == 5){
                //可以向上向下
                if((endP.getX() == 5 && endP.getY() >= 2 && endP.getY() <= 6)  ||
                        (endP.getX() == 5 && endP.getY() >= 10 && endP.getY() <= 13))
                    return true;
                //可以向左向右
                if(endP.getY() == 9 && endP.getX() >= 1 && endP.getX() <= 4 ){
                    return true;
                }
                //可进行营
                if(endP.getX() == 4 && endP.getY() == 10){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断移动或吃子的过程中，是否有其他棋子遮挡
     * 供司令、军长、师长、旅长、团长、营长、连长、排长、炸弹使用
     * 工兵需要重写
     * @param startP
     * @param endP
     * @param myPanel
     * @return
     */
    public boolean hasNoOtherChess(Point startP, Point endP, MyPanel myPanel){
        int startX = (int) startP.getX();
        int startY = (int) startP.getY();
        int endX = (int) endP.getX();
        int endY = (int) endP.getY();
        boolean flag = true;//表示没有棋子遮挡
        //在y轴从上往下移动
        if(startX == endX && startY < endY){
            for (int i = startY + 1; i < endY; i++){
                //中间有棋子
                if(Chess.getChessByPoint(new Point(startX, i), myPanel.chessList) != null){
                    flag = false;
                    break;
                }
            }
        }
        //在y轴从下往上移动
        if(startX == endX && startY > endY){
            for (int i = startY -1 ; i > endY; i--){
                //中间有棋子
                if(Chess.getChessByPoint(new Point(startX, i), myPanel.chessList) != null){
                    flag = false;
                    break;
                }
            }
        }
        //在x轴从左向右移动
        if(startY == endY && startX < endX){
            for (int i = startX + 1; i < endX; i++){
                if(Chess.getChessByPoint(new Point(i, startY), myPanel.chessList) != null){
                    flag = false;
                    break;
                }
            }
        }
        //在x轴从右向做移动
        if(startY == endY && startX > endX){
            for(int i = startX - 1; i > endX; i--){
                if(Chess.getChessByPoint(new Point(i, startY), myPanel.chessList) != null){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    /**
     * 判断棋子是否在行营中
     * @param chess
     * @return
     */
    public static boolean isAtXingYing(Chess chess){
        Point p = Chess.getPointFromXY(chess.getX(), chess.getY());
        int X  = p.x;
        int Y  = p.y;
        if(X == 2 && Y == 3){
            return true;
        }
        if(X == 4 && Y == 3){
            return true;
        }
        if(X == 2 && Y == 5){
            return true;
        }
        if(X == 4 && Y == 5){
            return true;
        }
        if(X == 2 && Y == 10){
            return true;
        }
        if(X == 2 && Y == 12){
            return true;
        }
        if(X == 4 && Y == 10){
            return true;
        }
        if(X == 4 && Y == 12){
            return true;
        }
        if(X == 3 && Y == 11){
            return true;
        }
        return false;
    }
}
