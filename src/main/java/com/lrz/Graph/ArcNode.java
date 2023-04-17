package com.lrz.Graph;

import java.io.Serializable;

/**
 * 图数据结构
 * 边表节点
 * @version 1.0
 * @auther lrz
 * @time 2023/1/10 20:36
 */
public class ArcNode implements Serializable {
    ArcNode next;
    int id;

    public ArcNode(int id) {
        this.id = id;
    }
}
