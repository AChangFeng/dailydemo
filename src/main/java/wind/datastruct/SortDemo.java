package wind.datastruct;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-07-27 10:10
 **/
public class SortDemo {

    public static void main(String[] args) {
        int arrayLength = 10;
        Random random = new Random();
        int[] array = new int[arrayLength];
        IntStream.range(0, arrayLength).forEach(x -> {
            array[x] = random.nextInt(arrayLength * arrayLength);
        });
        //insertionSort(array);
        //shellSort(array);
        bubbleSortV0(array);
        printArray(array);
    }

    public static int[] mergeSort(int[] a1, int[] a2) {
        if (a1.length != a2.length) {
            throw new UnsupportedOperationException();
        }
        int[] result = new int[a1.length * 2];
        int left = Integer.MIN_VALUE;
        for (int i = 0, j = 0; i < a1.length; i++) {
            int i1 = a1[i];
            int i2 = a2[i];

        }
        return result;
    }

    /**
     * 希尔排序（基于插入排序）
     *
     * @param array
     */
    public static void shellSort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j;
                int temp = array[i];
                //找到temp的正确位置 即array[x]<temp<array[j]
                for (j = i; j > 0 && temp < array[j - 1]; j--) {
                    // temp正确位置到temp索引-1的元素都右移1个位置
                    array[j] = array[j - 1];
                }
                // 将temp插入正确的位置
                array[j] = temp;
            }
        }
    }

    /**
     * 插入排序
     *
     * @param array
     */
    public static void insertSortV0(int[] array) {
        // 索引0上的本来就是有序的 不需排序
        for (int i = 1; i < array.length; i++) {
            int j;
            int temp = array[i];
            //找到temp的正确位置 即array[x]<temp<array[j]
            for (j = i; j > 0 && temp < array[j - 1]; j--) {
                // temp正确位置到temp索引-1的元素都右移1个位置
                array[j] = array[j - 1];
            }
            // 将temp插入正确的位置
            array[j] = temp;
        }
    }

    /**
     * 插入排序
     *
     * @param a
     */
    private static void insertSortV1(int[] a) {
        if (a.length <= 1) {
            return;
        }
        // 索引0上的本来就是有序的 不需排序
        for (int i = 1; i < a.length; i++) {
            // 将下标为i的元素插入到左边的已有序部分中
            int value = a[i];
            // 已有序部分的最后一个下标为i-1
            int j = i - 1;
            // 在已有序部分中找到要插入的位置 同时将大于需插入元素右移1位
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            // 插入 该元素
            a[j + 1] = value;
        }
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void bubbleSortV1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // 记录一次冒泡是否进行了元素操作 如果没有操作 说明已经排序完毕
            boolean flag = false;
            // 一次冒泡的最大次数为：当前需排序元素-1，因为每次冒泡比较2个元素
            // 当前需排序元素就是j-i
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param a
     */
    private static void bubbleSortV0(int[] a) {
        if (a.length <= 1) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }
}