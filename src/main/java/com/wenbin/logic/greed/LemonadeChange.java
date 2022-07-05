package com.wenbin.logic.greed;

/**
 * 柠檬水找零 https://leetcode-cn.com/problems/lemonade-change
 */
public class LemonadeChange {

  public boolean lemonadeChange(int[] bills) {
    if (bills == null || bills.length == 0) {
      return true;
    }

    int five = 0;
    int ten = 0;
    for (int i = 0; i < bills.length; i++) {
      if (bills[i] == 5) {
        five++;
      } else if (bills[i] == 10) {
        if (five == 0) {
          return false;
        }

        five--;
        ten++;
      } else {
        if (ten >= 1 && five >= 1) {
          ten--;
          five--;
        } else if (five >= 3) {
          five -= 3;
        } else {
          return false;
        }
      }
    }

    return true;
  }

  public boolean lemonadeChangeEasy(int[] bills) {
    int five = 0, ten = 0;
    for (int i : bills) {
      if (i == 5) {
        five++;
      } else if (i == 10) {
        five--;
        ten++;
      } else if (ten > 0) {
        ten--;
        five--;
      } else {
        five -= 3;
      }
      if (five < 0) {
        return false;
      }
    }
    return true;
  }
}
