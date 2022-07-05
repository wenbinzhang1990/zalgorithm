package com.wenbin.logic.sort.base;

/**
 * 堆排序 （不稳定）
 */
public class HeapSortByOwnHeap extends AbstractValidatableSort {

  @Override
  public void sort(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    MinHeap minHeap = new MinHeap(nums.length);
    for (int i = 0; i < nums.length; i++) {
      minHeap.add(nums[i]);
    }

    for (int i = 0; i < nums.length; i++) {
      nums[i] = minHeap.poll();
    }
  }

  public static void main(String[] args) {
    AbstractValidatableSort validatableSort = new HeapSortByOwnHeap();
    validatableSort.validate();
  }
}
