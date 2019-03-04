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

    public static void main(String[] args) {
        int[] array = {4,2,8,9,5,7,6,1,3,10};
        shellKnuthSort(array);
    }
}
