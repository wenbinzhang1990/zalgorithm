package com.wenbin.logic.skiplist;

/**
 *   1206. 设计跳表 https://leetcode.cn/problems/design-skiplist/
 *
 *   @Author wenbin
 */
public class SkipList {

    private static final int MAX_LEVEL = 32;
    private static final double P = 0.25d;
    Node head;
    private int curLevel;

    public SkipList() {
        head = new Node(null, MAX_LEVEL);
    }

    public boolean search(int target) {
        Node curNode = head;
        for (int i = curLevel - 1; i >= 0; i--) {
            curNode = findSuitableNode(curNode, i, target);
            if (curNode.next[i] != null && curNode.next[i].val == target) {
                return true;
            }
        }

        return false;
    }

    public void add(int num) {
        int level = randomLevel();
        Node newNode = new Node(num, level);
        Node curNode = head;
        for (int i = curLevel - 1; i >= 0; i--) {
            curNode = findSuitableNode(curNode, i, num);
            if (i < level) {
                if (curNode.next[i] == null) {
                    curNode.next[i] = newNode;
                } else {
                    Node tmp = curNode.next[i];
                    curNode.next[i] = newNode;
                    newNode.next[i] = tmp;
                }
            }
        }

        if (level > curLevel) {
            for (int i = curLevel; i < level; i++) {
                head.next[i] = newNode;
            }

            curLevel = level;
        }
    }

    public boolean erase(int num) {
        Node curNode = head;
        boolean flag = false;
        for (int i = curLevel - 1; i >= 0; i--) {
            curNode = findSuitableNode(curNode, i, num);
            if (curNode.next[i] != null && curNode.next[i].val == num) {
                curNode.next[i] = curNode.next[i].next[i];
                flag = true;
            }
        }

        return flag;
    }

    public Node findSuitableNode(Node cur, int level, int target) {
        while (cur.next[level] != null && cur.next[level].val < target) {
            cur = cur.next[level];
        }

        return cur;
    }

    int randomLevel() {
        int level = 1;
        while (Math.random() < P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    class Node {

        Integer val;
        Node[] next;

        public Node(Integer val, int size) {
            this.val = val;
            this.next = new Node[size];
        }
    }


}
