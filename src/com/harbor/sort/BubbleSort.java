package com.harbor.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author harborGao
 * @create 2020/3/7
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,239,9,1,534,23,99,86,53,6};
        bubbleSort(arr); //数组进行冒泡排序
        System.out.println(Arrays.toString(arr));  //输出排序后的数组
    }

    /**
     * 冒泡排序
     * @param arr 待排序的数组
     */
    public static void bubbleSort(int[] arr){
        int len = arr.length; // 获取数组元素的个数
        boolean flag = true; //内层循环中if语句没有执行则说明排序已完成
        //循环执行len-1次，每次循环确定一个元素的位置，i即为以确定位置元素的个数
        for(int i = 0; i < len-1; i++){
            for(int j = 0; j < len-i-1; j++){ //内层循环将最大的元素放到最末尾的位置
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                    flag = false; //说明排序有可能还没有完成
                }
            }
            if(flag)
                return;
        }
    }

    /**
     * 交换两个变量的值
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr,int i,int j){
        //写法一
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
        //写法二
//        arr[i] = arr[i]+arr[j];
//        arr[j] = arr[i]-arr[j];
//        arr[i] = arr[i]-arr[j];
        //写法三
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
