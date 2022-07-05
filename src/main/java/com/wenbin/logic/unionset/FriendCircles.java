package com.wenbin.logic.unionset;

/**
 * 朋友圈 https://leetcode-cn.com/problems/friend-circles/
 */
public class FriendCircles {

  public int findCircleNum(int[][] m) {
    Union union = new Union(m.length);
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j <= i; j++) {
        if (m[i][j] == 1) {
          union.union(i, j);
        }
      }
    }

    return union.getCount();
  }

  public int findCircleNumByBfs(int[][] m) {
    return 0;
  }

  public int findCircleNumByDfs(int[][] m) {
    return 0;
  }

  class Union {

    int[] parent;
    int count;

    public Union(int length) {
      parent = new int[length];
      count = length;
      for (int i = 0; i < length; i++) {
        parent[i] = i;
      }
    }

    public int getCount() {
      return count;
    }

    public void union(int src, int des) {
      int srcPosition = find(src);
      int descPosition = find(des);
      if (srcPosition != descPosition) {
        count--;
        parent[srcPosition] = descPosition;
      }
    }

    public int find(int postion) {
      while (postion != parent[postion]) {
        postion = parent[postion];
      }

      return postion;
    }
  }
}
