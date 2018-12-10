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

}
