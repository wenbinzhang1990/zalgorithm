package com.wenbin.logic.binarysearch;

/**
 * 寻找旋转排序数组中的最小值 https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {

  public static void main(String[] args) {
    FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
    findMinimumInRotatedSortedArray.findMin(new int[]{3, 2, 1});
  }


  public int findMinByMinValue(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int min = Integer.MAX_VALUE;
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[left] <= nums[mid]) {
        min = Math.min(min, nums[left]);
        left = mid + 1;
      } else {
        min = Math.min(min, nums[mid]);
        right = mid - 1;
      }
    }

    return min;
  }

  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      if (nums[left] <= nums[right]) {
        return nums[left];
      }

      int mid = left + (right - left) / 2;
      if (nums[left] <= nums[mid]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return -1;
  }
}
