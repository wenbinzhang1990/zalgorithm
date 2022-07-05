package com.wenbin.logic.sort;

/**
 * 逆序对 https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class ReversePairs {

  int count = 0;

  public int reversePairs(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return 0;
    }

    mergeSort(nums, 0, nums.length - 1);
    return count;
  }

  private void mergeSort(int[] nums, int begin, int end) {
    if (begin >= end) {
      return;
    }

    int mid = begin + (end - begin) / 2;
    mergeSort(nums, begin, mid);
    mergeSort(nums, mid + 1, end);
    merge(nums, begin, mid, end);
  }

  private void merge(int[] nums, int begin, int mid, int end) {
    int[] temp = new int[end - begin + 1];
    int index = 0;
    int left = begin;
    int middle = mid + 1;
    while (left <= mid && middle <= end) {
      count += nums[left] <= nums[middle] ? middle - (mid + 1) : 0;
      temp[index++] = nums[left] <= nums[middle] ? nums[left++] : nums[middle++];
    }

    while (left <= mid) {
      count += middle - (mid + 1);
      temp[index++] = nums[left++];
    }

    while (middle <= end) {
      temp[index++] = nums[middle++];
    }

    System.arraycopy(temp, 0, nums, begin, end - begin + 1);
  }

  public static void main(String[] args) {
    ReversePairs reversePairs = new ReversePairs();
    reversePairs.reversePairs(new int[]{7, 5, 6, 3});
  }
}
