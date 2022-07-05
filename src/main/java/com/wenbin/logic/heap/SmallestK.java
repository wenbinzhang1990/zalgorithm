package com.wenbin.logic.heap;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 最小的k个数 https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 */
public class SmallestK {

  // 排序后数组复制
  public int[] smallestKBySort(int[] arr, int k) {
    int[] result = new int[k];
    Arrays.sort(arr);
    System.arraycopy(arr, 0, result, 0, k);
    return result;
  }

  // 堆实现
  public int[] smallestKByHeap(int[] arr, int k) {
    if (k <= 0 || arr == null || arr.length == 0) {
      return new int[0];
    }

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, (v1, v2) -> v2 - v1);
    for (int i = 0; i < arr.length; i++) {
      if (i < k || priorityQueue.isEmpty() || arr[i] < priorityQueue.peek()) {
        priorityQueue.add(arr[i]);
      }
      if (priorityQueue.size() > k ) {
        priorityQueue.poll();
      }
    }

    int[] result = new int[k];
    int idx = 0;
    for (int num : priorityQueue) {
      result[idx++] = num;
    }

    return result;
  }

  public static void main(String[] args) {
    SmallestK smallestK = new SmallestK();
    int[] result = smallestK.smallestKByHeap(new int[]{3, 2, 1, 4, 5, 6}, 2);
    System.out.println("Test");
  }
}
