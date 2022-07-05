package com.wenbin.logic.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 翻转字符串里的单词 https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInAString {

  public static void main(String[] args) {
    ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
    reverseWordsInAString.reverseWords("the 2  33");
  }

  public String reverseWordsByLib(String s) {
    List<String> wordList = Arrays.asList(s.trim().split("\\s+"));
    Collections.reverse(wordList);
    return String.join(" ", wordList);
  }

  public String reverseWords(String s) {
    if (s.length() == 0) {
      return s;
    }

    char[] array = s.toCharArray();
    List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < array.length; i++) {
      if (array[i] == ' ') {
        if (sb.length() > 0) {
          list.add(sb.toString());
          sb.delete(0, sb.length());
        }
      } else {
        sb.append(array[i]);
      }
    }

    if (sb.length() > 0) {
      list.add(sb.toString());
    }

    int left = 0;
    int right = list.size() - 1;
    while (left < right) {
      String temp = list.get(left);
      list.set(left, list.get(right));
      list.set(right, temp);
      left++;
      right--;
    }

    return join(list, " ");
  }

  public static String join(Iterable<String> pieces, String separator) {
    StringBuilder buffer = new StringBuilder();
    for (Iterator<String> iter = pieces.iterator(); iter.hasNext(); ) {
      buffer.append(iter.next());

      if (iter.hasNext()) {
        buffer.append(separator);
      }
    }

    return buffer.toString();
  }
}
