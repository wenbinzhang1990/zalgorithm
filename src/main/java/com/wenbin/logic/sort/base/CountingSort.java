package com.wenbin.logic.sort.base;

/**
 * 计数排序（稳定） 适用于一定范围的整数排序。在取值范围不是很大的情况下，它的性能在某些情况甚至快过那些O(nlogn)的排序，例如快速排序、归并排序
 * 一旦范围过大，就需要太多存储空间，就不合适了。
 */
public class CountingSort extends AbstractValidatableSort {

  @Override
  public void sort(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    int min = nums[0];
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      min = Math.min(min, nums[i]);
      max = Math.max(max, nums[i]);
    }

    int[] countArray = new int[max - min + 1];
    for (int i = 0; i < nums.length; i++) {
      countArray[nums[i] - min]++;
    }

    int k = 0;
    for (int i = 0; i < countArray.length; i++) {
      for (int j = 0; j < countArray[i]; j++) {
        nums[k++] = i + min;
      }
    }
  }

  public static void main(String[] args) {
    AbstractValidatableSort validatableSort = new CountingSort();
    validatableSort.validate();
  }
}
