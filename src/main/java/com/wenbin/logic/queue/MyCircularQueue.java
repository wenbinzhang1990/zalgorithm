package com.wenbin.logic.queue;

/**
 *   循环队列  https://leetcode.cn/problems/design-circular-queue/
 *
 *   @Author wenbin
 */
public class MyCircularQueue {

    int max = 0;
    int front = 0;
    int end = 1;
    int[] num;
    int count = 0;

    public MyCircularQueue(int k) {
        this.max = k;
        num = new int[k];

    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        count++;
        num[getIndex(end++)] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        count--;
        front++;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return num[getIndex(front + 1)];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return num[getIndex(end - 1)];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == max;
    }

    public int getIndex(int index) {
        return (index + max) % max;
    }
}
