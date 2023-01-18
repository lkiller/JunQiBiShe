package com.lrz.Queue;

import org.junit.Test;

/**
 * @version 1.0
 * @auther lrz
 * @time 2023/1/13 23:28
 */
public class MyQueue {
    int num = 32;
    int front = 0, rear = 0;
    int[] numbers = new int[num];

    /**
     * 进队
     * @param num
     */
    public void Enqueue(int num){
        this.numbers[rear++] = num;
    }

    /**
     * 出队
     * @return
     */
    public int Dequeue(){
        if(front >= rear){
            System.out.println("已经为空，无法出队");
            return -1;
        }
        return this.numbers[front++];
    }

    public void print(){
        for (int i = front; i < rear; i++) {
            System.out.print(this.numbers[i] + " ");
        }
    }
    public boolean isEmpty(){
        if(rear == front)
            return true;
        return false;
    }
    @Test
    public void test(){
        Enqueue(1);
        Enqueue(11);
        Dequeue();
        Dequeue();
        Dequeue();
        System.out.println(isEmpty());



        print();
    }
}
