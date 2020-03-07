package com.harbor.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author harborGao
 * @create 2020/3/7
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {52,234,98,8,12,45,99,120,5,34,52,1};
        quickSort(arr,0,arr.length-1); //数组传入进行快排
        System.out.println(Arrays.toString(arr)); //输出排序后的数组
    }

    /**
     * 对数组start到end部分进行快速排序
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr,int start,int end){
        if(start >= end)
            return;
        //得到一个index，下标小于index则对应的值也小于index，下标大于index则对应的值也大于index
        int index = divide(arr,start,end);
        //将下标小于index的部分进行以上操作
        quickSort(arr,start,index-1);
        //将下标大于index的部分进行以上操作
        quickSort(arr,index+1,end);
    }

    public static int divide(int[] arr, int left, int right){
        int index = left;
        int value = arr[right]; //设置排序区间的最后一个元素为基准点
        for(int i = left; i <= right; i++){ //遍历待排序区间
            //将小于基准点的数放到数组最前面
            if(arr[i] < value){
                swap(arr,index,i);
                index++; //每放一个数，index往后移一位
            }
        }
        /*此时下标小于index的都小于arr[right],下标大于index则大于arr[right],
        所以将下标为index的元素和下标大于index的元素交换位置*/
        swap(arr,index,right);
        return index;
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
