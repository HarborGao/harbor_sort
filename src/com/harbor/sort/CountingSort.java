package com.harbor.sort;

import java.util.Arrays;

/**
 * 计数排序
 * @author harborGao
 * @create 2020/3/7
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] array = {5,32,67,9,23,19,103,98,55,19,199};
        countingSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void countingSort(int[] array){
        //找出待排序数组的取值区间
        int min = array[0];
        int max = array[0];
        for(int i = 0; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }

        //创建用来计数的数组
        int[] count = new int[max-min+1];

        //计算每个元素的个数
        for(int i = 0; i < array.length; i++){
            int index = array[i] - min;
            count[index]++;
        }

        for(int i = 1; i < count.length; i++){
            count[i] = count[i-1] + count[i];
        }

        //创建一个新数组来保存排序好的值
        int[] temp = new int[array.length];
        for(int i = array.length-1; i >= 0; i--){
            int index = array[i] - min;
            //count[index]表示array[i]之前还有多少个元素，因为数组下标从0开始，所以需要-1
            temp[count[index]-1] = array[i];
            count[index]--;
        }

        //将排序好的数组重新赋值给array
        for(int i = 0; i < temp.length; i++){
            array[i] = temp[i];
        }
    }
}
