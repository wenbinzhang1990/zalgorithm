package com.wenbin.logic.sort.base;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 堆排序（不稳定）
 */
public class HeapSortByLib extends AbstractValidatableSort {

  @Override
  public void sort(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    Queue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < nums.length; i++) {
      pq.add(nums[i]);
    }

    for (int i = 0; i < nums.length; i++) {
      nums[i] = pq.poll();
    }
  }

  public static void main(String[] args) {
    AbstractValidatableSort validatableSort = new HeapSortByLib();
    validatableSort.validate();
  }
}
