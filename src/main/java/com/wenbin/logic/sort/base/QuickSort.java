package com.wenbin.logic.sort.base;

/**
 * 快速排序（不稳定）
 */
public class QuickSort extends AbstractValidatableSort {

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

    int pivotValue = nums[begin];
    int left = begin;
    int right = end;
    while (left < right) {
      while (left < right && nums[right] >= pivotValue) {
        right--;
      }

      while (left < right && nums[left] <= pivotValue) {
        left++;
      }

      if (left < right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
      }
    }

    nums[begin] = nums[left];
    nums[left] = pivotValue;
    sort(nums, begin, left - 1);
    sort(nums, left + 1, end);
  }

  public static void main(String[] args) {
    AbstractValidatableSort validatableSort = new QuickSort();
    validatableSort.validate();
  }
}
