package wind.datastruct;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-12-10 14:00
 **/
public class Search {

    /**
     * 二分查找针对的是一个有序的数据集合，查找思想有点类似分治思想。
     * 每次都通过跟区间的中间元素对比，将待查找的区间缩小为之前的一半。
     * 直到找到要查找的元素，或者区间被缩小为 0。
     *
     * @param a
     * @param val
     * @return
     */
    private static int binarySearch(int[] a, int val) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == val) {
                return mid;
            } else if (a[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个等于val的元素
     *
     * @param a
     * @param val
     * @return
     */
    private static int binarySearchFirst(int[] a, int val) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if (a[mid] < val) {
                low = mid + 1;
            } else if (a[mid] > val) {
                high = mid - 1;
            } else {
                if (mid == 0 || a[mid - 1] != val) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个等于val的元素
     *
     * @param a
     * @param val
     * @return
     */
    private static int binarySearchLast(int[] a, int val) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if (a[mid] < val) {
                low = mid + 1;
            } else if (a[mid] > val) {
                high = mid - 1;
            } else {
                if (mid == a.length - 1 || a[mid + 1] != val) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于val的元素
     *
     * @param a
     * @param val
     * @return
     */
    private static int binarySearchFirstGranterThanOrEqual(int[] a, int val) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if (a[mid] < val) {
                low = mid + 1;
            } else {
                if (mid == 0 || a[mid - 1] < val) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于val的元素
     *
     * @param a
     * @param val
     * @return
     */
    private static int binarySearchLastLessThanOrEqual(int[] a, int val) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if (a[mid] <= val) {
                if (mid == a.length || a[mid + 1] > val) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
