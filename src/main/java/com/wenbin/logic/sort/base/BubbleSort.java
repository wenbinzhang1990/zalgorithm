package com.wenbin.logic.sort.base;

/**
 * 冒泡排序（稳定）
 */
public class BubbleSort extends AbstractValidatableSort {

  @Override
  public void sort(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      // 如果一轮下来没有一个元素发生变化，说明已经排序了，无需后续无效遍历了
      boolean hasSorted = true;
      for (int j = 1; j < nums.length - i; j++) {
        if (nums[j] < nums[j - 1]) {
          int temp = nums[j - 1];
          nums[j - 1] = nums[j];
          nums[j] = temp;
          hasSorted = false;
        }
      }

      if (hasSorted) {
        break;
      }
    }
  }

  public static void main(String[] args) {
    AbstractValidatableSort validatableSort = new BubbleSort();
    validatableSort.validate();
  }
}
