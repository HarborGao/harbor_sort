package com.harbor.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 桶排序
 * @author harborGao
 * @create 2020/3/7
 */
public class BucketSort {

    /**
     * 桶排序
     * @param list 待排序集合
     * @param bucketSize bucketSize 每个桶中能存放多少个不相同的数
     *                   (例如当bucketSize==5时，该桶可以存放{1,2,3,4,5}这几种数字，可以存放n个3)
     * @return 排序后的集合
     */
    public static List<Integer> bucketSort(List<Integer> list,int bucketSize){
        //若list==null或list.size()<2则无排序的必要，若bucketSize<1则无法进行排序
        if(list == null || list.size() < 2 || bucketSize < 1)
            return list;
        //获取list中的最大值和最小值
        int min = list.get(0);
        int max = list.get(1);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) > max){
                max = list.get(i);
            }
            if(list.get(i) < min){
                min = list.get(i);
            }
        }
        //由此可以得到需要多少个桶
        int count = (max-min)/bucketSize + 1;
        //每个桶中的数据由arraylist存储，并且所有桶放入一个list中
        List<List<Integer>> bucket = new ArrayList<>();
        for(int i = 0; i < count; i++){
            bucket.add(new ArrayList<Integer>());
        }
        //将所有数据装入桶中
        for(int i = 0; i < list.size(); i++){
            int index = (list.get(i) - min)/bucketSize;
            bucket.get(index).add(list.get(i));
        }
        //对每个桶内元素进行排序后先后传入resultList
        List<Integer> resultList = new ArrayList<>();
        for(int i = 0; i < bucket.size(); i++){
            List<Integer> currentBucket = bucket.get(i);
            if(bucketSize == 1){
                bucketSize--;
            }
            List<Integer> temp = bucketSort(currentBucket,bucketSize);
            for(int j = 0;j < temp.size(); j++){
                resultList.add(temp.get(j));
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        //ArrayList底层即为数组，在此创建list
        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(4);
        list.add(78);
        list.add(106);
        list.add(2);
        list.add(-5);
        list.add(17);
        list.add(28);
        list.add(66);
        //注意:bucketSize过大容易导致栈溢出
        List<Integer> result = bucketSort(list,2); //进行桶排序
        System.out.println(result);
    }
}
