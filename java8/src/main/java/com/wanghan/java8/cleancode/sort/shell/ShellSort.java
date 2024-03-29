package com.wanghan.java8.cleancode.sort.shell;

import com.wanghan.java8.cleancode.util.ArrayUtils;

import java.util.Arrays;

/**
 * 希尔排序
 *      于1959年提出的一种排序算法。
 *      希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序，同时该算法是冲破O(n2）的第一批算法之一。
 *      它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
 *
 * 算法步骤
 *      希尔排序的基本步骤，在此我们选择增量gap=length/2，缩小增量继续以gap = gap/2的方式，这种增量选择我们可以用一个序列来表示，{n/2,(n/2)/2…1}，称为增量序列。希尔排序的增量序列的选择与证明是个数学难题，我们选择的这个增量序列是比较常用的，也是希尔建议的增量，称为希尔增量，但其实这个增量序列不是最优的。此处我们做示例使用希尔增量。
 *
 *      先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
 *          步骤1：选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 *          步骤2：按增量序列个数k，对序列进行k 趟排序；
 *          步骤3：每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 *
 * 算法分析
 *      最佳情况：T(n) = O(nlog2 n)
 *      最坏情况：T(n) = O(nlog2 n)
 *      平均情况：T(n) =O(nlog2n)
 *
 * @Author WangHan
 * @Create 2021/4/15 10:28 上午
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 0, 1, 2, 3, 4, 10, 11, 17, 20};
        long startTime = System.currentTimeMillis();

        //希尔排序
        shellSort(arr);

        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.println("speed time ms :" + (endTime - startTime));
    }

    /**
     * 希尔排序
     * @param array
     * @return
     */
    public static int[] shellSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int gap = array.length / 2;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
            ArrayUtils.print(array);
        }
        return array;
    }

}
