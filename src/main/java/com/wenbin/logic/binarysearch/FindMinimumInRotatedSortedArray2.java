package com.wenbin.logic.binarysearch;

/**
 * 寻找旋转排序数组中的最小值 https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray2 {

  public static void main(String[] args) {
    FindMinimumInRotatedSortedArray2 findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray2();
    findMinimumInRotatedSortedArray.findMin(new int[]{3, 1, 3});
  }


  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int left = 0, right = nums.length - 1;
    while (left <= right) {
      if (nums[left] == nums[right]) {
        left++;
        continue;
      }

      if (nums[left] < nums[right]) {
        return nums[left];
      }

      int mid = left + (right - left) / 2;
      if (nums[left] == nums[mid]) {
        left++;
      }

      if (nums[left] <= nums[mid]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return nums[right];
  }

  public int findMin2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else if (nums[mid] < nums[right]) {
        right = mid;
      } else {
        right = right - 1;
      }
    }

    return nums[left];
  }
}
