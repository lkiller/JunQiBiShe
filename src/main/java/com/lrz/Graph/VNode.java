package com.lrz.Graph;

import javafx.scene.shape.Arc;

import java.io.Serializable;

/**
 * 顶点表节点
 * @version 1.0
 * @auther lrz
 * @time 2023/1/10 20:37
 */
public class VNode implements Serializable {
    ArcNode first = null;
    int id;

    public VNode(int id) {
        this.id = id;
    }

    /**
     * 给边表节点插入顶点
     * @param num 插入顶点的编号
     */
    public void insert(int num){
        ArcNode temp;
        //如果发现没有first
        if(this.first == null){
            this.first = new ArcNode(num);
            this.first.next = null;
        }else{//找到最后一个节点
            temp = this.first;
            while(temp.next != null){
                temp = temp.next;
            }//循环结束，此时temp为最后一个节点
            temp.next = new ArcNode(num);
            temp.next.next = null;
        }
    }
}
