package com.wenbin.logic.sort.base;

/**
 * 快速排序（不稳定,例 45527）
 */
public class QuickSort2 extends AbstractValidatableSort {

  @Override
  public void sort(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    sort(nums, 0, nums.length - 1);
  }

  private void sort(int[] nums, int begin, int end) {
    if (begin >= end) {
      return;
    }

    int pivot = begin;
    int index = pivot + 1;
    for (int i = index; i <= end; i++) {
      if (nums[i] < nums[pivot]) {
        swap(nums, i, index++);
      }
    }

    swap(nums, index - 1, pivot);
    sort(nums, begin, index - 2);
    sort(nums, index, end);
  }

  private void swap(int[] nums, int from, int to) {
    int temp = nums[from];
    nums[from] = nums[to];
    nums[to] = temp;
  }

  public static void main(String[] args) {
    AbstractValidatableSort validatableSort = new QuickSort2();
    validatableSort.validate();
  }
}
