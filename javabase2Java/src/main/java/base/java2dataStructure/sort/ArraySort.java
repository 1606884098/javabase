package base.java2dataStructure.sort;

import java.util.Arrays;

/**
 * 排序算法：对一序列对象根据某个关键字进行排序
 */
public class ArraySort {
    public static void main(String[] args) {
        int[] array = {42,20,17,13,28,14,23,15};

        array = bubbleSort(array);//1.冒泡排序法
        System.out.println(Arrays.toString(array));
        array =selectionSort(array);//2.选择排序法
        array =insertionSort(array);//3.插入排序法
        array=quickSort(array);
        System.out.println(Arrays.toString(array));//输出数组的内容

    }


    /**
     * 1.冒泡排序法:一次比较相邻的两个元素，如果它们的顺序错误就把它们交换过来
     * @param array
     * @return
     */
    private static int[] bubbleSort(int[] array) {
        if (array.length == 0)
            return array;
        int temp;//临时变量
        boolean flag;//是否交换的标志
        for (int i = 0; i < array.length - 1; i++) {   //表示趟数，一共array.length-1次。
            flag = false;
            for (int j = array.length - 1; j > i; j--) {//数组的最后一个元素和倒数第二个比较

                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;//如果全部已经排好了，就没有进入到交换位置，说明已经排好了跳出for
        }
        return array;
    }

    /**
     * 2.选择排序法：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * @param array
     * @return
     */
    private static int[] selectionSort(int[] array) {
        if (array.length == 0)
            return array;
        for(int i=0;i<array.length-1;i++){
            int minIndex = i;//用第一个元素和其他的元素比较，用第一个位置存放小的元素
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){//稳定不用调换位置
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return array;
    }

    /**
     * 3.插入排序:在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，
     * 使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
     * @param array
     * @return
     */
    private static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int temp;
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(array[j] < array[j-1]){
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }else{         //不需要交换
                    break;
                }
            }
        }
        return array;
    }

    /**
     *
     * @param array
     * @return
     */
    private static int[] quickSort(int[] array) {

        if (array.length == 0)
            return array;

        return array;
    }
}
