package com.wenbin.logic.sort;

/**
 * 数组的相对排序 https://leetcode-cn.com/problems/relative-sort-array
 */
public class RelativeSortArray {

  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    int[] table = new int[1001];
    int[] result = new int[arr1.length];
    for (int i : arr1) {
      table[i]++;
    }

    int index = 0;
    for (int i : arr2) {
      while (table[i] > 0) {
        result[index++] = i;
        table[i]--;
      }
    }

    for (int i = 0; i < table.length; i++) {
      while (table[i] > 0) {
        result[index++] = i;
        table[i]--;
      }
    }

    return result;
  }

}
