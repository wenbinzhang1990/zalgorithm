package com.wenbin.logic.binarysearch;

/**
 * 搜索旋转排序数组 https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {

  public static void main(String[] args) {
    SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
    searchInRotatedSortedArray.search(new int[]{3,1}, 3);
  }

  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (target == nums[mid]) {
        return mid;
      }

      if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (target <= nums[right] && target > nums[mid]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }

    return -1;
  }
}
