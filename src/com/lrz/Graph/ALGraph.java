package com.lrz.Graph;

import com.lrz.Queue.MyQueue;
import javafx.scene.shape.Arc;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Queue;

/**
 * 无向图
 * @version 1.0
 * @auther lrz
 * @time 2023/1/10 20:38
 */
public class ALGraph {
    int vNum = 32;//顶点个数
    int nowNum = 32;
    int eNum;//边个数
    VNode[] vertics = new VNode[vNum];//顶点表数组
    ArcNode[] acrNode = new ArcNode[vNum];//边表数组
    int[] nums = new int[32];
    @Test
    public void Init(){
        //给数组赋初值
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        for (int i = 0; i < vNum ; i++) {
            vertics[i] = new VNode(i);//创建顶点表
            acrNode[i] = new ArcNode(i);//创建边表
        }
        allInsert();
    }

    /**
     * 只有两个相邻接点的结点进行快速插入
     * @param i 某个节点
     */
    public void fastInsert(int i){
        vertics[i].insert(i - 1);
        vertics[i].insert(i + 1);
    }

    /**
     * 进行所有节点的插入
     */
    public void allInsert(){
        vertics[0].insert(1);
        vertics[0].insert(15);
        fastInsert(1);
        fastInsert(2);
        fastInsert(3);
        fastInsert(4);
        fastInsert(5);
        fastInsert(6);
        fastInsert(7);//fastInsert(8);
        vertics[8].insert(7);
        vertics[8].insert(9);
        vertics[8].insert(20);
        fastInsert(9);//fastInsert(10);
        vertics[10].insert(9);
        vertics[10].insert(18);
        vertics[10].insert(11);
        fastInsert(11);//fastInsert(12);
        vertics[12].insert(11);
        vertics[12].insert(13);
        vertics[12].insert(16);
        fastInsert(13);
        fastInsert(14);//fastInsert(15);fastInsert(16);
        vertics[15].insert(0);
        vertics[15].insert(14);
        vertics[16].insert(12);
        vertics[16].insert(17);
        vertics[16].insert(31);
        fastInsert(17);//fastInsert(18)
        vertics[18].insert(10);
        vertics[18].insert(17);
        vertics[18].insert(19);
        fastInsert(19);//fastInsert(20)
        vertics[20].insert(8);
        vertics[20].insert(19);
        vertics[20].insert(21);
        fastInsert(21);
        fastInsert(22);
        fastInsert(23);
        fastInsert(24);
        fastInsert(25);
        fastInsert(26);
        fastInsert(27);
        fastInsert(28);
        fastInsert(29);
        fastInsert(30);//fastInsert(31);
        vertics[31].insert(30);
        vertics[31].insert(16);
    }

    /**
     * 删除编号为num的结点
     * @param num 结点的编号
     */
    public void delete(int num){
        //删除图中编号为num的结点需要两步
        //首先要删除顶点表中编号为num的结点，将其置为null
        //接着需要遍历所有顶点表，将所有边表节点为num的结点删除
        nowNum--;
        deleteVNode(num);
        deleteArcNode(num);
        System.out.println("AlGraph类第109行，删除了节点" + num);
    }

    /**
     * 删除编号为num的边表节点
     * @param num 边表节点编号
     */
    private void deleteArcNode(int num) {
        ArcNode temp, pTemp;
        for (int i = 0; i < vertics.length; i++) {
            if(vertics[i] != null){
                temp = vertics[i].first;
                if(temp != null){
                    if(temp.id == num){//第一个就是要删除的
                        vertics[i].first = temp.next;
                    }else if(temp.next != null){//第二个以及之后的才是要删除的
                        pTemp = vertics[i].first;
                        temp = temp.next;
                        while(temp.id != num && temp.next != null){
                            pTemp = temp;
                            temp = temp.next;
                        }
                        if(temp.id == num){
                            pTemp.next = temp.next;
                        }
                    }
                }

            }

        }
    }

    /**
     * 删除编号为num的顶点表节点
     * @param num 顶点表编号
     */
    private void deleteVNode(int num) {
        vertics[num] = null;
    }

    /**
     * 打印图的相邻节点
     */
    public void printGraph(){
        for (int i = 0; i < vertics.length; i++) {
            if(vertics[i] != null){
                ArcNode temp = vertics[i].first;
                System.out.print("节点" + vertics[i].id + "能到的点有");
                while(temp != null){
                    System.out.print(temp.id + " ");
                    temp = temp.next;
                }
                System.out.println();
            }
        }
    }

    /**
     * 判断图Graph是否存在结点a到结点b的路径
     * @param A
     * @param B
     * @return
     */
    public boolean isExist(ALGraph graph, int A, int B){
        boolean Exist = false;
        MyQueue myQueue = new MyQueue();
        boolean[] visited = new boolean[32];
        //将visited数组都置为false
        for (int i = 0; i < graph.vNum; i++) {
            visited[i] = false;
        }
        visited[A] = true;
        myQueue.Enqueue(A);
        while(!myQueue.isEmpty() && !Exist){
            int temp = myQueue.Dequeue();
            //System.out.println("出队元素" + temp);
            if(temp == -1){
                System.out.println("AlGraph出错，MyQueue出错，此时队列为空");
            }
            ArcNode arcNode = vertics[temp].first;
            while (arcNode != null && !Exist){
                if(arcNode.id == B){
                    Exist = true;
                }
                if(!visited[arcNode.id]){
                    visited[arcNode.id] = true;
                    myQueue.Enqueue(arcNode.id);
                }
                arcNode = arcNode.next;
            }
        }
        return Exist;
    }
    @Test
    public void test(){
        Init();//初始化图
        //printGraph();
        /*delete(2);
        delete(16);

        System.out.println(isExist(this, 0,31));
        delete(21);
        System.out.println(isExist(this, 0,31));*/
        System.out.println(vertics[9].first.id);
    }
}

