package com.wenbin.logic.dp;

/**
 * 统计全为 1 的正方形子矩阵 https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/
 */
public class CountSquareSubMatricesWithAllOnes {

  public static void main(String[] args) {
    CountSquareSubMatricesWithAllOnes countSquareSubMatricesWithAllOnes = new CountSquareSubMatricesWithAllOnes();
    countSquareSubMatricesWithAllOnes
        .countSquares(new int[][]{{0, 1, 1, 1}, {1, 0, 0, 0}, {0, 1, 1, 1}, {0, 1, 1, 1}});
  }

  public int countSquares(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int result = 0;
    int rowCount = matrix.length;
    int colCount = matrix[0].length;
    int[][] dp = new int[rowCount + 1][colCount + 1];
    for (int i = 1; i <= rowCount; i++) {
      for (int j = 1; j <= colCount; j++) {
        if (matrix[i - 1][j - 1] == 1) {
          dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
          result += dp[i][j];
        }
      }
    }

    return result;
  }
}
