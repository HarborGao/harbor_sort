package com.harbor.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author harborGao
 * @create 2020/3/7
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {85,23,56,99,12,5,9,55,192,105,78,1};
        arr = mergeSort(arr); //将数组进行归并排序
        System.out.println(Arrays.toString(arr)); //输出排序后的数组
    }

    /**
     * 归并排序
     * @param arr 传入的数组
     * @return
     */
    public static int[] mergeSort(int[] arr){
        //若arr.length < 2，则不需要进行排序
        if(arr.length < 2){
            return arr;
        }
        //将数组拆分为两部分
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr,mid,arr.length);
        //将拆分的数组进行合并，递归调用mergeSort,最终执行merge方法的两个数组长度都小于2，即为有序的
        return merge(mergeSort(left),mergeSort(right));
    }

    /**
     * 将两个有序数组合并为一个有序数组
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right){
        //新创建一个数组
        int[] arr = new int[left.length + right.length];
        int lIndex = 0;//left数组的下标
        int rIndex = 0;//right数组的下标
        for(int i = 0; i < arr.length; i++){
            if(lIndex == left.length){ //left数组为空
                arr[i] = right[rIndex++];
            }else if(rIndex == right.length){ //right数组为空
                arr[i] = left[lIndex++];
            }else if(left[lIndex] > right[rIndex]){//两个数组都不为空，将较小的数放入arr
                arr[i] = right[rIndex++];
            }else{
                arr[i] = left[lIndex++];
            }
        }
        return arr;
    }
}
