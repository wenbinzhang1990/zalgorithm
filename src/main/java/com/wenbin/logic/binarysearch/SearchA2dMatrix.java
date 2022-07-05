package com.wenbin.logic.binarysearch;

/**
 * 搜索二维矩阵 https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class SearchA2dMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    int rowCount = matrix.length;
    int colCount = matrix[0].length;
    int left = 0;
    int right = rowCount * colCount - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int newRow = mid / colCount;
      int newCol = mid % colCount;
      if (matrix[newRow][newCol] == target) {
        return true;
      }

      if (target > matrix[newRow][newCol]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return false;
  }
}
