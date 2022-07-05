package com.wenbin.logic.sort.base;

/**
 * 归并排序（稳定）
 */
public class MergeSort extends AbstractValidatableSort {

  @Override
  public void sort(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    mergeSort(nums, 0, nums.length - 1);
  }

  public void mergeSort(int[] nums, int left, int right) {
    if (left >= right) {
      return;
    }

    int mid = left + ((right - left) >> 2);
    mergeSort(nums, left, mid);
    mergeSort(nums, mid + 1, right);
    merge(nums, left, mid, right);
  }

  public void merge(int[] nums, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int index = 0, begin = left, k = mid + 1;
    while (begin <= mid && k <= right) {
      temp[index++] = nums[begin] <= nums[k] ? nums[begin++] : nums[k++];
    }

    while (begin <= mid) {
      temp[index++] = nums[begin++];
    }

    while (k <= right) {
      temp[index++] = nums[k++];
    }

    System.arraycopy(temp, 0, nums, left, right - left + 1);
  }

  public static void main(String[] args) {
    AbstractValidatableSort validatableSort = new MergeSort();
    validatableSort.validate();
  }
}
