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
        int arrayLength = 100000;
        Random random = new Random();
        int[] array = new int[arrayLength];
        IntStream.range(0, arrayLength).forEach(x -> {
            int i = arrayLength * arrayLength;
            if (i <= 0) {
                i = Integer.MAX_VALUE;
            }
            array[x] = random.nextInt(i);
        });
        //insertionSort(array);
        //shellSort(array);
        printArray(array);
        //int[] result = mergeSort(array);
        quickSort(array, 0, arrayLength - 1);
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

    /**
     * 插入排序
     * <p>
     * 首先，我们将数组中的数据分为两个区间，已排序区间和未排序区间。
     * 初始已排序区间只有一个元素，就是数组的第一个元素。
     * 插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。
     * 重复这个过程，直到未排序区间中元素为空，算法结束
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
            printArray(a);
        }
    }

    /**
     * 冒泡排序
     * <p>
     * 冒泡排序只会操作相邻的两个数据。
     * 每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求。
     * 如果不满足就让它俩互换。
     * 一次冒泡会让至少一个元素移动到它应该在的位置，重复n 次，就完成了 n 个数据的排序工作。
     * <p>
     * 实际上，冒泡过程还可以优化。当某次冒泡操作已经没有数据交换时，说明已经达到完全有
     * 序，不用再继续执行后续的冒泡操作。
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
     * 选择排序
     * <p>
     * 选择排序的思路类似插入排序，整个数组分为已排序区间和未排序区间。
     * 每次排序从未排序区间找出最小的元素放在已排序区间末尾。
     *
     * @param a
     */
    private static void selectionSort(int[] a) {
        // 对于长度为n的数组 需要n次才能排序完成
        for (int i = 0; i < a.length; i++) {
            // 找出最小值 i左边为已排序区域 右边为未排序区域
            int minIndex = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // 最小值放到已排序末尾 即与未排序的首位交换元素
            int min = a[minIndex];
            a[minIndex] = a[i];
            a[i] = min;
        }
    }

    private static int[] mergeSort(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        int mid = a.length / 2;

        int[] a1 = new int[mid];
        int[] a2 = new int[a.length - mid];

        System.arraycopy(a, 0, a1, 0, mid);
        System.arraycopy(a, mid, a2, 0, a.length - mid);

        int[] left = mergeSort(a1);
        int[] right = mergeSort(a2);
        return merge(left, right);
    }

    private static int[] merge(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        int x, y, z;
        x = y = z = 0;
        while (y < a1.length && z < a2.length) {
            if (a1[y] < a2[z]) {
                result[x++] = a1[y++];
            } else {
                result[x++] = a2[z++];
            }
        }
        if (y == a1.length) {
            for (; z < a2.length; ) {
                result[x++] = a2[z++];
            }
        } else {
            for (; y < a1.length; ) {
                result[x++] = a1[y++];
            }
        }
        return result;
    }

    private static void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        // 分区
        int partition = partition(a, start, end);
        // 递归排序左边
        quickSort(a, start, partition - 1);
        // 递归排序右边
        quickSort(a, partition + 1, end);
    }

    /**
     * 将数组区间排序为p下标左边元素都比a[p]小右边都比它大的区间，并返回p
     *
     * @param a
     * @param start
     * @param end
     * @return
     */
    private static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        // 假设0-i是有序区间 pivot是哨兵 小于哨兵的要放到i之前
        int i = start, j = start;
        for (; j < end; j++) {
            if (a[j] < pivot) {
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
                i++;
            }
        }
        // swap pivot and target index
        int tmp = a[i];
        a[i] = a[end];
        a[end] = tmp;
        return i;
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
