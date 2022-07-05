package com.wenbin.logic.sort.base;

/**
 * 选择排序（不稳定，例：58529）
 */
public class SelectionSort extends AbstractValidatableSort {

  @Override
  public void sort(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    for (int i = 0; i < nums.length - 1; i++) {
      int min = i;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[min] > nums[j]) {
          min = j;
        }
      }

      if (min != i) {
        int temp = nums[min];
        nums[min] = nums[i];
        nums[i] = temp;
      }
    }
  }

  public static void main(String[] args) {
    AbstractValidatableSort validatableSort = new SelectionSort();
    validatableSort.validate();
  }
}
