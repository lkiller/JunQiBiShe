package com.lrz.ChessSon;

import com.lrz.Chess;
import com.lrz.Graph.ALGraph;
import com.lrz.Movable;
import com.lrz.MyPanel;
import com.sun.xml.internal.bind.v2.TODO;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

/**
 * @version 1.0
 * @auther lrz
 * @time 2023/1/7 10:41
 */
public class GongBing extends Chess implements Movable {
    ALGraph alGraph;
    public GongBing(String name, String color) {
        super("工兵", color, 1);
    }

    @Override
    public boolean isAbleMove(Point startP, Point endP) {
        //起始和结束位置相等，不能移动
        if(startP.x == endP.x && startP.y == endP.y){
            return false;
        }else{
            //起始位置和结束位置不相等了
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
            //与行营交叉的地方
            if((startP.getX() == 2 && startP.getY() == 4) ||
                    (startP.getX() == 3 && startP.getY() == 3)||
                    (startP.getX() == 4 && startP.getY() == 4) ||
                    (startP.getX() == 3 && startP.getY() == 5) ||

                    (startP.getX() == 3 && startP.getY() == 10) ||
                    (startP.getX() == 2 && startP.getY() == 11) ||
                    (startP.getX() == 4 && startP.getY() == 11) ||
                    (startP.getX() == 3 && startP.getY() == 12) ){
                return Chess.justUpDownLeftRight(startP, endP);
            }
            //第二行
            if(startP.getY() == 2){
                //第二行第一个
                if (startP.getX() == 1) {
                    //目标行营或者1、1
                    if ((endP.getX() == 2 && endP.getY() == 3) || (endP.getX() == 1 && endP.getY() == 1))
                        return true;
                    return isAtRail(endP);
                }
                //第二行第二个
                if (startP.getX() == 2) {
                    //目标行营或者2、1
                    if ((endP.getX() == 2 && endP.getY() == 3) || (endP.getX() == 2 && endP.getY() == 1))
                        return true;
                    return isAtRail(endP);
                }
                //第二行第三个
                if (startP.getX() == 3) {
                    //目标行营或者3、1
                    if ((endP.getX() == 2 && endP.getY() == 3) || (endP.getX() == 3 && endP.getY() == 1) ||
                    (endP.getX() == 4 && endP.getY() == 3))
                        return true;
                    return isAtRail(endP);
                }
                //第二行第四个
                if (startP.getX() == 4) {
                    //目标行营或者4、1
                    if ((endP.getX() == 4 && endP.getY() == 3) || (endP.getX() == 4 && endP.getY() == 1))
                        return true;
                    return isAtRail(endP);
                }
                //第二行第五个
                if (startP.getX() == 5) {
                    //目标行营或者5、1
                    if ((endP.getX() == 4 && endP.getY() == 3) || (endP.getX() == 5 && endP.getY() == 1))
                        return true;
                    return isAtRail(endP);
                }
            }
            //第十三行
            if(startP.getY() == 13){
                //第十三行第一个
                if (startP.getX() == 1) {
                    //目标行营或者1、14
                    if ((endP.getX() == 2 && endP.getY() == 12) || (endP.getX() == 1 && endP.getY() == 14))
                        return true;
                    return isAtRail(endP);
                }
                //第十三行第二个
                if (startP.getX() == 2) {
                    //目标行营或者2、14
                    if ((endP.getX() == 2 && endP.getY() == 12) || (endP.getX() == 2 && endP.getY() == 14))
                        return true;
                    return isAtRail(endP);
                }
                //第十三行第三个
                if (startP.getX() == 3) {
                    //目标行营或者3、14
                    if ((endP.getX() == 2 && endP.getY() == 12) || (endP.getX() == 4 && endP.getY() == 12) ||
                            (endP.getX() == 3 && endP.getY() == 14))
                        return true;
                    return isAtRail(endP);
                }
                //第十三行第四个
                if (startP.getX() == 4) {
                    //目标行营或者4、14
                    if ((endP.getX() == 4 && endP.getY() == 12) || (endP.getX() == 4 && endP.getY() == 14))
                        return true;
                    return isAtRail(endP);
                }
                //第十三行第四个
                if (startP.getX() == 5) {
                    //目标行营或者5、14
                    if ((endP.getX() == 4 && endP.getY() == 12) || (endP.getX() == 5 && endP.getY() == 14))
                        return true;
                    return isAtRail(endP);
                }
            }

            //第三行
            if(startP.getY() == 3){
                if(startP.getX() == 1){
                    if(endP.getX() == 2 && endP.getY() == 3){
                        return true;
                    }
                    else return isAtRail(endP);
                }
                if(startP.getX() == 5){
                    if(endP.getX() == 4 && endP.getY() ==3){
                        return true;
                    }
                    else return isAtRail(endP);
                }
            }
            //第十二行
            if(startP.getY() == 12){
                if(startP.getX() == 1){
                    if(endP.getX() == 2 && endP.getY() == 12){
                        return true;
                    }
                    else return isAtRail(endP);
                }
                if(startP.getX() == 5){
                    if(endP.getX() == 4 && endP.getY() ==12){
                        return true;
                    }
                    else return isAtRail(endP);
                }
            }

            //第四行
            if(startP.getY() == 4){
                if(startP.getX() == 1){
                    if((endP.getX() == 2 && endP.getY() == 3) || (endP.getX() == 2 && endP.getY() == 5)
                ||(endP.getX() == 2 && endP.getY() == 4)){
                        return true;
                    }
                    else return isAtRail(endP);
                }
                if(startP.getX() == 5){
                    if((endP.getX() == 4 && endP.getY() ==3) || (endP.getX() == 4 && endP.getY() == 5)
                    ||(endP.getX() == 4 && endP.getY() ==4)){
                        return true;
                    }
                    else return isAtRail(endP);
                }
            }
            //第十一行
            if(startP.getY() == 11){
                if(startP.getX() == 1){
                    if((endP.getX() == 2 && endP.getY() == 10) || (endP.getX() == 2 && endP.getY() == 12) ||
                            (endP.getX() == 2 && endP.getY() == 11)){
                        return true;
                    }
                    else return isAtRail(endP);
                }
                if(startP.getX() == 5){
                    if((endP.getX() == 4 && endP.getY() == 10) || (endP.getX() == 4 && endP.getY() == 12) ||
                            (endP.getX() == 4 && endP.getY() ==11)){
                        return true;
                    }
                    else return isAtRail(endP);
                }
            }

            //第五行
            if(startP.getY() == 5){
                if(startP.getX() == 1){
                    if(endP.getX() == 2 && endP.getY() == 5){
                        return true;
                    }
                    else return isAtRail(endP);
                }
                if(startP.getX() == 5){
                    if(endP.getX() == 4 && endP.getY() ==5){
                        return true;
                    }
                    else return isAtRail(endP);
                }
            }
            //第十行
            if(startP.getY() == 10){
                if(startP.getX() == 1){
                    if(endP.getX() == 2 && endP.getY() == 10){
                        return true;
                    }
                    else return isAtRail(endP);
                }
                if(startP.getX() == 5){
                    if(endP.getX() == 4 && endP.getY() == 10){
                        return true;
                    }
                    else return isAtRail(endP);
                }
            }

            //第六行
            if(startP.getY() == 6){
                if(startP.getX() == 1){
                    if(endP.getX() == 2 && endP.getY() == 5){
                        return true;
                    }
                    else return isAtRail(endP);
                }
                if(startP.getX() == 2){
                    if(endP.getX() == 2 && endP.getY() == 5){
                        return true;
                    }
                    else return isAtRail(endP);
                }
                if(startP.getX() == 3){
                    if((endP.getX() == 2 && endP.getY() == 5) || (endP.getX() == 4 && endP.getY() == 5) ){
                        return true;
                    }
                    else return isAtRail(endP);
                }
                if(startP.getX() == 4){
                    if(endP.getX() == 4 && endP.getY() == 5){
                        return true;
                    }
                    else return isAtRail(endP);
                }
                if(startP.getX() == 5){
                    if(endP.getX() == 4 && endP.getY() == 5){
                        return true;
                    }
                    else return isAtRail(endP);
                }
            }
            //第九行
            if(startP.getY() == 9){
                if(startP.getX() == 1){
                    if(endP.getX() == 2 && endP.getY() == 10){
                        return true;
                    }
                    else return isAtRail(endP);
                }
                if(startP.getX() == 2){
                    if(endP.getX() == 2 && endP.getY() == 10){
                        return true;
                    }
                    else return isAtRail(endP);
                }
                if(startP.getX() == 3){
                    if((endP.getX() == 2 && endP.getY() == 10) || (endP.getX() == 4 && endP.getY() == 10) ){
                        return true;
                    }
                    else return isAtRail(endP);
                }
                if(startP.getX() == 4){
                    if(endP.getX() == 4 && endP.getY() == 10){
                        return true;
                    }
                    else return isAtRail(endP);
                }
                if(startP.getX() == 5){
                    if(endP.getX() == 4 && endP.getY() == 10){
                        return true;
                    }
                    else return isAtRail(endP);
                }
            }
        }
        return false;
    }

    /**
     * 判断结束点是否在铁路上
     * @param endP
     * @return
     */
    public boolean isAtRail(Point endP){
        //目标在第二行表示都在铁路上
        if (endP.getY() == 2) {
            return true;
        }
        //目标在第六行表示都在铁路上
        if (endP.getY() == 6) {
            return true;
        }
        //目标在第九行表示都在铁路上
        if (endP.getY() == 9) {
            return true;
        }
        //目标在第十三行表示都在铁路上
        if (endP.getY() == 13) {
            return true;
        }
        //目标在第一列 第二到第六行 第九到第十三行表示都在铁路上
        if (endP.getX() == 1 && ((endP.getY() <= 6 && endP.getY() >= 2)
                ||
                (endP.getY() >= 9 && endP.getY() <= 13))) {
            return true;
        }
        //目标在第五列 第二到第六行 第九到第十三行表示都在铁路上
        if (endP.getX() == 5 && ((endP.getY() <= 6 && endP.getY() >= 2)
                ||
                (endP.getY() >= 9 && endP.getY() <= 13))) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasNoOtherChess(Point startP, Point endP, MyPanel myPanel) {
        //到工兵走时，每次都会根据场上棋子创建一个图，
        // 然后根据起始点和结束点判断是否能够移动，移除起始点创建图
        createGraph(myPanel, startP);
        int A = 0, B = 0;
        if(startP.y == 1 || startP.y == 14) return true;
        if(startP.y == 3){
            if(startP.x == 2 || startP.x == 3 || startP.x == 4) return true;
        }
        if(startP.y == 4){
            if(startP.x == 2 || startP.x == 3 || startP.x == 4) return true;
        }
        if(startP.y == 5){
            if(startP.x == 2 || startP.x == 3 || startP.x == 4) return true;
        }
        if(startP.y == 10){
            if(startP.x == 2 || startP.x == 3 || startP.x == 4) return true;
        }
        if(startP.y == 11){
            if(startP.x == 2 || startP.x == 3 || startP.x == 4) return true;
        }
        if(startP.y == 12){
            if(startP.x == 2 || startP.x == 3 || startP.x == 4) return true;
        }
        else   {
            //替换A
            {
             if(startP.x == 1){
                    if(startP.y == 2) A = 0;
                    if(startP.y == 3) A = 15;
                    if(startP.y == 4) A = 14;
                    if(startP.y == 5) A = 13;
                    if(startP.y == 6) A = 12;
                    //if(p.y == 7) A =13);
                    //if(p.y == 8) A =13);
                    if(startP.y == 9) A = 16;
                    if(startP.y == 10) A = 31;
                    if(startP.y == 11) A = 30;
                    if(startP.y == 12) A = 29;
                    if(startP.y == 13) A = 28;
                }
                if(startP.x == 2){
                    if(startP.y == 2) A = 1;
                    if(startP.y == 6) A = 11;
                    if(startP.y == 9) A = 17;
                    if(startP.y == 13) A = 27;
                }
                if(startP.x == 3){
                    if(startP.y == 2) A = 2;
                    if(startP.y == 6) A = 10;
                    if(startP.y == 9) A = 18;
                    if(startP.y == 13) A = 26;
                }
                if(startP.x == 4){
                    if(startP.y == 2) A = 3;
                    if(startP.y == 6) A = 9;
                    if(startP.y == 9) A = 19;
                    if(startP.y == 13) A = 25;
                }
                if(startP.x == 5){
                    if(startP.y == 2) A = 4;
                    if(startP.y == 3) A = 5;
                    if(startP.y == 4) A = 6;
                    if(startP.y == 5) A = 7;
                    if(startP.y == 6) A = 8;
                    //if(p.y == 7) A =13);
                    //if(p.y == 8) A =13);
                    if(startP.y == 9) A = 20;
                    if(startP.y == 10) A = 21;
                    if(startP.y == 11) A = 22;
                    if(startP.y == 12) A = 23;
                    if(startP.y == 13) A = 24;
                }
            }
            //替换B
            {
                if (endP.x == 1) {
                    if (endP.y == 2) B = 0;
                    if (endP.y == 3) B = 15;
                    if (endP.y == 4) B = 14;
                    if (endP.y == 5) B = 13;
                    if (endP.y == 6) B = 12;
                    //if(p.y == 7) B =13);
                    //if(p.y == 8) B =13);
                    if (endP.y == 9) B = 16;
                    if (endP.y == 10) B = 31;
                    if (endP.y == 11) B = 30;
                    if (endP.y == 12) B = 29;
                    if (endP.y == 13) B = 28;
                }
                if (endP.x == 2) {
                    if (endP.y == 2) B = 1;
                    if (endP.y == 6) B = 11;
                    if (endP.y == 9) B = 17;
                    if (endP.y == 13) B = 27;
                }
                if (endP.x == 3) {
                    if (endP.y == 2) B = 2;
                    if (endP.y == 6) B = 10;
                    if (endP.y == 9) B = 18;
                    if (endP.y == 13) B = 26;
                }
                if (endP.x == 4) {
                    if (endP.y == 2) B = 3;
                    if (endP.y == 6) B = 9;
                    if (endP.y == 9) B = 19;
                    if (endP.y == 13) B = 25;
                }
                if (endP.x == 5) {
                    if (endP.y == 2) B = 4;
                    if (endP.y == 3) B = 5;
                    if (endP.y == 4) B = 6;
                    if (endP.y == 5) B = 7;
                    if (endP.y == 6) B = 8;
                    //if(p.y == 7) B =13);
                    //if(p.y == 8) B =13);
                    if (endP.y == 9) B = 20;
                    if (endP.y == 10) B = 21;
                    if (endP.y == 11) B = 22;
                    if (endP.y == 12) B = 23;
                    if (endP.y == 13) B = 24;
                }
            }
            if(isAtRail(startP) && isAtRail(endP)){
                return alGraph.isExist(alGraph, A, B);
            }else{
                return true;
            }
        }
        return true;
    }

    /**
     * 根据场上棋子创建图
     * @param myPanel
     */
    public void createGraph(MyPanel myPanel, Point startP){
        alGraph = new ALGraph();
        alGraph.Init();//初始化图

        Point p;
        ArrayList<Chess> chessList = myPanel.chessList;
        for (Chess chess : chessList) {
            p = chess.getP();
            //不删除本身的点，否则报空指针异常？找了好久的bug
            if(isAtRail(p) && (p.x != startP.x && p.y != startP.y)){
                deletePoint(p, alGraph);
            }
        }
    }

    /**
     * 根据铁路上棋子删除图的顶点
     * @param p
     * @param graph
     */
    private void deletePoint(Point p, ALGraph graph) {
        if(p.x == 1){
            if(p.y == 2) graph.delete(0);
            if(p.y == 3) graph.delete(15);
            if(p.y == 4) graph.delete(14);
            if(p.y == 5) graph.delete(13);
            if(p.y == 6) graph.delete(12);
            //if(p.y == 7) graph.delete(13);
            //if(p.y == 8) graph.delete(13);
            if(p.y == 9) graph.delete(16);
            if(p.y == 10) graph.delete(31);
            if(p.y == 11) graph.delete(30);
            if(p.y == 12) graph.delete(29);
            if(p.y == 13) graph.delete(28);
        }
        if(p.x == 2){
            if(p.y == 2) graph.delete(1);
            if(p.y == 6) graph.delete(11);
            if(p.y == 9) graph.delete(17);
            if(p.y == 13) graph.delete(27);
        }
        if(p.x == 3){
            if(p.y == 2) graph.delete(2);
            if(p.y == 6) graph.delete(10);
            if(p.y == 9) graph.delete(18);
            if(p.y == 13) graph.delete(26);
        }
        if(p.x == 4){
            if(p.y == 2) graph.delete(3);
            if(p.y == 6) graph.delete(9);
            if(p.y == 9) graph.delete(19);
            if(p.y == 13) graph.delete(25);
        }
        if(p.x == 5){
            if(p.y == 2) graph.delete(4);
            if(p.y == 3) graph.delete(5);
            if(p.y == 4) graph.delete(6);
            if(p.y == 5) graph.delete(7);
            if(p.y == 6) graph.delete(8);
            //if(p.y == 7) graph.delete(13);
            //if(p.y == 8) graph.delete(13);
            if(p.y == 9) graph.delete(20);
            if(p.y == 10) graph.delete(21);
            if(p.y == 11) graph.delete(22);
            if(p.y == 12) graph.delete(23);
            if(p.y == 13) graph.delete(24);
        }
    }

}
