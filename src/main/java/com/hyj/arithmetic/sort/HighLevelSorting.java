package com.hyj.arithmetic.sort;

import java.util.Arrays;

/**
 * @version 1.0
 * @Authord yujie huang  email: 190158792@qq.com
 * @Description
 * @Date Create by in 17:32 2019/3/4
 */
public class HighLevelSorting {

    //3h+1
    public static void shellKnuthSort(int[] array){

//        System.out.println("原始数据："+ Arrays.toString(array));
//        int step = 1;
//        int len = array.length;
//        if(step<=len/3){
//            step = 3*step+1;
//        }
//
//        while(step>0){
//
//        }
        System.out.println("原数组为"+Arrays.toString(array));
        int step = 1 ;
        int len = array.length;
        while(step <= len/3){
            step = step*3 + 1;//1,4,13,40......
        }
        while(step > 0){
            //分别对每个增量间隔进行排序
            for(int i = step ; i < len ; i++){
                int temp = array[i];
                int j = i;
                System.out.println(j+"==");
                while(j > step-1 && temp <= array[j-step]){
                    System.out.println(j);
                    array[j] = array[j-step];
                    j -= step;
                }
                array[j] = temp;
            }//end for
            System.out.println("间隔为"+step+"的排序结果为"+Arrays.toString(array));
            step = (step-1)/3;
        }//end while(step>0)

        System.out.println("最终排序："+Arrays.toString(array));
    }


    public static void QuickSort(int[] array,int left,int right){
        if (left >=right){
            return;
        }
        int point = partitionIt(array,left,right);
        QuickSort(array,left,point-1);
        QuickSort(array,point+1,right);
    }

    /**
     * 某一次排序
     * @param array
     * @param left
     * @param right
     */
    public static int partitionIt(int[] array,int left,int right){
        medianOf3(array,left,right);
        int temp = left;
        left = left+1;
        while(left <right){
            if(array[left]>array[temp] && array[right]<array[temp]){
                swap(array,left,right);
            }else{
                if(array[left]<array[temp]){
                    left++;
                }
                if(array[right]>array[temp]){
                    right--;
                }
            }

        }
        if(array[left] >array[temp]){
            swap(array,left-1,temp);
            return left-1;
        }else{
            swap(array,left,temp);
            return left;
        }
    }

    /**
     * 数组交换位置
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }
    //取数组下标第一个数、中间的数、最后一个数的中间值
    public static int medianOf3(int[] array,int left,int right){
        int center = (right - left)/2+1;
        //保证array[left] < array[right]
        if(array[left] > array[right]){
            swap(array,left,right);
        }
        //保证array[right]最大
        if(array[center]>array[right]){
            swap(array,center,right);
        }
        if(array[center]>array[left]){
            swap(array,center,left);
        }
        return array[left];
    }
    public static void main(String[] args) {
        int[] array = {9,9,8,7,6,5,4,3,2,1};
        //shellKnuthSort(array);
        QuickSort(array,0,array.length-1);
        //partitionIt(array,0,array.length-1);
        System.out.println(Arrays.toString(array));

        while (true){

        }
    }
}
