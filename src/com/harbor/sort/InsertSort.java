package com.harbor.sort;

import java.util.Arrays;

/**
 * 插入排序
 * @author harborGao
 * @create 2020/3/7
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {56,9,53,1,56,9,123,55,88,76,531,222};
        insertSort(arr); //数组进行插入排序
        System.out.println(Arrays.toString(arr)); //输出排序后的数组
    }

    /**
     * 插入排序
     * @param arr 传入的数组
     */
    public static void insertSort(int[] arr){
        int len = arr.length; //获取数组的长度
        //从第二个元素开始与前面的数组比较，若比前面的小，则交换位置
        for(int i = 1; i < len; i++){
            for(int j = i - 1; j >= 0; j--){
                //下标为i的元素依次与小于下标i的元素比较，若小于，则交换
                if(arr[j+1] < arr[j]){
                    swap(arr,j+1,j); //交换位置的方法
                }else{
                    //因下标小于i的元素是有序的，所以if条件不成立，即位置已确定，可跳出内存循环
                    break;
                }
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
