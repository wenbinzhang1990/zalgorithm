package com.wenbin.logic.heap;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/**
 * 滑动窗口最大值 https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {

  // 滑动窗口最大值-deque实现
  public int[] maxSlidingWindowByDeque(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return new int[0];
    }

    int[] result = new int[nums.length - k + 1];
    ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
      while (!arrayDeque.isEmpty() && nums[arrayDeque.peekLast()] < nums[i]) {
        arrayDeque.pollLast();
      }

      arrayDeque.addLast(i);
      if (arrayDeque.peekFirst() <= i - k) {
        arrayDeque.pollFirst();
      }

      if (i >= k - 1) {
        result[i - k + 1] = nums[arrayDeque.peekFirst()];
      }

    }

    return result;
  }

  // 滑动窗口最大值-heap实现
  public int[] maxSlidingWindowByHeap(int[] nums, int k) {
      if (nums == null || nums.length == 0) {
        return new int[0];
      }

      int[] result = new int[nums.length - k + 1];
      PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, (v1, v2) -> v2 - v1);
      for (int i = 0; i < nums.length; i++) {
        priorityQueue.add(nums[i]);
        if (i - k >= 0) {
          priorityQueue.remove(nums[i - k]);
        }

        if (i >= k - 1) {
          result[i - k + 1] = priorityQueue.peek();
        }
      }

      return result;
  }

  public static void main(String[] args) {
    SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
    slidingWindowMaximum.maxSlidingWindowByHeap(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
  }
}
