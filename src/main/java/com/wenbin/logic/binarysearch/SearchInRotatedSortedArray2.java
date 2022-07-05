package com.wenbin.logic.binarysearch;

import javax.swing.text.html.HTML.Tag;

/**
 * 搜索旋转排序数组 https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray2 {

  public static void main(String[] args) {
    SearchInRotatedSortedArray2 searchInRotatedSortedArray = new SearchInRotatedSortedArray2();
    searchInRotatedSortedArray.search(new int[]{3, 1}, 1);
  }

  public boolean search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return true;
      }

      if (nums[left] == nums[mid]) {
        left++;
        continue;
      }

      if (nums[left] < nums[mid]) {
        if (nums[left] <= target && nums[target] <= nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] <= target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return false;
  }
}
