package com.harbor.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author harborGao
 * @create 2020/3/7
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {8,23,4,98,123,543,99,87,3,5};
        selectionSort(arr);//进行选择排序
        System.out.println(Arrays.toString(arr)); //输出排序后的数组
    }

    /**
     * 选择排序
     * @param arr 待排序的数组
     */
    public static void selectionSort(int[] arr){
        int min = arr[0];
        int index = 0;
        int len = arr.length; //获取数组的长度
        for(int i = 0; i < len - 1; i++){ //每次循环找到最小的元素，确定其位置，i为已确定位置元素的个数
            min = arr[i]; //现将未找到位置的第一个元素赋值给min
            index = i; //min对应的下标
            for(int j = i+1;j < len;j++){ //在未确定位置的元素中寻找最小的元素，记录其下标
                if(arr[j] < min){
                    min = arr[j];
                    index = j;
                }
            }
            //确定最小的元素，将其与i位置交换
            arr[index] = arr[i];
            arr[i] = min;
        }
    }
}
