package com.wenbin.logic.sort.base;

/**
 * 二叉小顶堆（仅供学习使用） 工程应用请使用jdk内置堆
 *
 * @see java.util.PriorityQueue
 */
public class MinHeap {

  int[] array;
  int capacity;
  int size;

  public MinHeap(int capacity) {
    this.array = new int[capacity];
    this.capacity = capacity;
    this.size = 0;
  }

  public boolean add(int num) {
    if (isFull()) {
      return false;
    }

    array[size] = num;
    heapUp(size, num);
    size++;
    return true;
  }

  public int poll() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }

    size--;
    int result = array[0];
    array[0] = array[size];
    heapDown(0, array[0]);
    return result;
  }

  private void heapUp(int index, int num) {
    while (index > 0 && array[(index - 1) >> 1] > num) {
      array[index] = array[(index - 1) >> 1];
      index = (index - 1) >> 1;
    }

    array[index] = num;
  }

  private void heapDown(int index, int num) {
    while (smallerChildIndex(index) < size) {
      int minChild = smallerChildIndex(index);
      if (num < array[minChild]) {
        break;
      }

      array[index] = array[minChild];
      index = minChild;
    }

    array[index] = num;
  }

  private int smallerChildIndex(int index) {
    int left = index * 2 + 1;
    int right = index * 2 + 2;
    if (right > size) {
      return left;
    }

    return array[left] > array[right] ? right : left;
  }

  public boolean isFull() {
    return this.capacity == this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public static void main(String[] args) {
    MinHeap minHeap = new MinHeap(10);
    minHeap.add(10);
    minHeap.add(4);
    minHeap.add(9);
    minHeap.add(1);
    minHeap.add(7);
    minHeap.add(5);
    minHeap.add(3);

    minHeap.printHeap();
    System.out.printf("poll:"+minHeap.poll());
    System.out.println();
    minHeap.printHeap();
    System.out.printf("poll:"+minHeap.poll());
    System.out.println();
    minHeap.printHeap();
    System.out.printf("poll:"+minHeap.poll());
    System.out.println();
    minHeap.printHeap();
  }

  public void printHeap() {
    System.out.print("nHeap = ");
    for (int i = 0; i < size; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }
}
