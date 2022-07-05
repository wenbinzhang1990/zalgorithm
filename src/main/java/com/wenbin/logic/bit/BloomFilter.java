package com.wenbin.logic.bit;


import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 参考以下链接，有所修改，去掉序列化，超出限制，清理功能等，仅供学习参考
 *
 * @Link https://blog.csdn.net/u014653197/article/details/76397037
 */
public class BloomFilter implements Serializable {

  private static final long serialVersionUID = -5221305273707291280L;
  private final int[] seeds;
  private final int size;
  private final BitSet notebook;
  private final MisjudgmentRate rate;
  private final AtomicInteger useCount = new AtomicInteger(0);

  /**
   * 默认中等程序的误判率：MisjudgmentRate.MIDDLE 以及不自动清空数据（性能会有少许提升）
   *
   * @param dataCount 预期处理的数据规模，如预期用于处理1百万数据的查重，这里则填写1000000
   */
  public BloomFilter(int dataCount) {
    this(MisjudgmentRate.MIDDLE, dataCount);
  }

  /**
   * @param rate      一个枚举类型的误判率
   * @param dataCount 预期处理的数据规模，如预期用于处理1百万数据的查重，这里则填写1000000
   */
  public BloomFilter(MisjudgmentRate rate, int dataCount) {
    long bitSize = rate.seeds.length * dataCount;
    if (bitSize < 0 || bitSize > Integer.MAX_VALUE) {
      throw new RuntimeException("位数太大溢出了，请降低误判率或者降低数据大小");
    }
    this.rate = rate;
    seeds = rate.seeds;
    size = (int) bitSize;
    notebook = new BitSet(size);
  }

  public void add(String data) {
    for (int i = 0; i < seeds.length; i++) {
      int index = hash(data, seeds[i]);
      setTrue(index);
    }
  }

  public boolean check(String data) {
    for (int i = 0; i < seeds.length; i++) {
      int index = hash(data, seeds[i]);
      if (!notebook.get(index)) {
        return false;
      }
    }
    return true;
  }

  public void setTrue(int index) {
    useCount.incrementAndGet();
    notebook.set(index, true);
  }

  private int hash(String data, int seed) {
    char[] value = data.toCharArray();
    int hash = 0;
    if (value.length > 0) {

      for (int i = 0; i < value.length; i++) {
        hash = i * hash + value[i];
      }
    }

    hash = hash * seed % size;
    // 防止溢出变成负数
    return Math.abs(hash);
  }

  public double getUseRate() {
    return (double) useCount.intValue() / (double) size;
  }


  public MisjudgmentRate getRate() {
    return rate;
  }

  /**
   * 分配的位数越多，误判率越低但是越占内存
   * <p>
   * 4个位误判率大概是0.14689159766308
   * <p>
   * 8个位误判率大概是0.02157714146322
   * <p>
   * 16个位误判率大概是0.00046557303372
   * <p>
   * 32个位误判率大概是0.00000021167340
   *
   * @author lianghaohui
   */
  public enum MisjudgmentRate {
    // 这里要选取质数，能很好的降低错误率
    /**
     * 每个字符串分配4个位
     */
    VERY_SMALL(new int[]{2, 3, 5, 7}),
    /**
     * 每个字符串分配8个位
     */
    SMALL(new int[]{2, 3, 5, 7, 11, 13, 17, 19}), //
    /**
     * 每个字符串分配16个位
     */
    MIDDLE(new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53}), //
    /**
     * 每个字符串分配32个位
     */
    HIGH(new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
        79, 83, 89, 97,
        101, 103, 107, 109, 113, 127, 131});

    private int[] seeds;

    private MisjudgmentRate(int[] seeds) {
      this.seeds = seeds;
    }

  }

  public static void main(String[] args) {
    BloomFilter filter = new BloomFilter(100);
    filter.add("1111111111111");
    filter.add("2222222222222222");
    filter.add("3333333333333333");
    filter.add("444444444444444");
    filter.add("5555555555555");
    filter.add("6666666666666");
    filter.add("1111111111111");
    System.out.println(filter.getUseRate());
    filter.add("1111111111111");
    System.out.println(filter.check("1"));
    System.out.println(filter.check("2"));
    System.out.println(filter.check("3"));
    System.out.println(filter.check("4"));
    System.out.println(filter.check("1111111111111"));

  }
}
