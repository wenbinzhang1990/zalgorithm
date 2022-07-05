package com.wenbin.logic.dp;

/**
 * 学生出勤记录 II  https://leetcode-cn.com/problems/student-attendance-record-ii/
 */
public class StudentAttendanceRecord2 {


  public int checkRecord(int n) {
    final int mod = 1000000007;
    int[][][] f = new int[n + 1][2][3];

    f[0] = new int[][]{{1, 1, 1}, {1, 1, 1}};
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < 2; j++) {
        for (int k = 0; k < 3; k++) {
          // 将n - 1的所有结果后面添加上‘P’
          int val = f[i - 1][j][2];

          // 将n - 1的结果其中添加了 j - 1个‘A’的所有排列情况 尾端添加'A'
          if (j > 0) {
            val = (val + f[i - 1][j - 1][2]) % mod;
          }

          // 将n - 1的结果其中添加了连续 k - 1个‘L’的所有排列情况 尾端添加‘L’
          if (k > 0) {
            val = (val + f[i - 1][j][k - 1]) % mod; // ...L
          }

          f[i][j][k] = val;
        }
      }
    }

    return f[n][1][2];
  }
}
