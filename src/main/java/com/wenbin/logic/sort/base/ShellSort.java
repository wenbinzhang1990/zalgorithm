package com.wenbin.logic.sort.base;

/**
 * 希尔排序 （不稳定）
 */
public class ShellSort extends AbstractValidatableSort {

  @Override
  public void sort(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }

    for (int gap = nums.length / 2; gap > 0; gap /= 2) {
      insertSort(nums, gap);
    }
  }

  public void insertSort(int[] nums, int gap) {
    for (int i = gap; i < nums.length; i++) {
      int cur = nums[i];
      int index = i;
      while (index - gap >= 0 && cur < nums[index - gap]) {
        nums[index] = nums[index - gap];
        index -= gap;
      }

      nums[index] = cur;
    }
  }

  public static void main(String[] args) {
    AbstractValidatableSort validatableSort = new ShellSort();
    validatableSort.validate();
  }
}
