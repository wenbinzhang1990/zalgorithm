package com.wenbin.logic.sort;

/**
 * 翻转对 https://leetcode-cn.com/problems/reverse-pairs/
 */
public class ReversePairs2 {

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
    int twoLeft = begin;
    for (int i = mid + 1; i <= end; i++) {
      while (twoLeft <= mid && nums[twoLeft] / 2.0 <= nums[i]) {
        twoLeft++;
      }

      while (left <= mid && nums[left] < nums[i]) {
        temp[index++] = nums[left++];
      }

      temp[index++] = nums[i];
      count += mid - twoLeft + 1;
    }

    while (left <= mid) {
      temp[index++] = nums[left++];
    }

    System.arraycopy(temp, 0, nums, begin, end - begin + 1);
  }

  public static void main(String[] args) {
    ReversePairs2 reversePairs2=new ReversePairs2();
    reversePairs2.reversePairs(new int[]{1,3,3,1});
  }
}
