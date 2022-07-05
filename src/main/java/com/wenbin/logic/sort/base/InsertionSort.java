package com.wenbin.logic.sort.base;

/**
 * 插入排序（稳定）
 */
public class InsertionSort extends AbstractValidatableSort {

  @Override
  public void sort(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    for (int i = 1; i < nums.length; i++) {
      int cur = nums[i];
      int preIndex = i - 1;
      while (preIndex >= 0 && cur < nums[preIndex]) {
        nums[preIndex + 1] = nums[preIndex];
        preIndex--;
      }

      nums[preIndex + 1] = cur;
    }
  }

  public static void main(String[] args) {
    AbstractValidatableSort validatableSort = new InsertionSort();
    validatableSort.validate();
  }
}

