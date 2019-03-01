package com.hyj.arithmetic.sort;

/**
 * @version 1.0
 * @Authord yujie huang  email: 190158792@qq.com
 * @Description
 * @Date Create by in 10:11 2019/3/1
 */
public class LowLevelSorting {

    /**
     * 冒泡算法的运作规律如下：
     *
     * 　　①、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     *
     * 　　②、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数（也就是第一波冒泡完成）。
     *
     * 　　③、针对所有的元素重复以上的步骤，除了最后一个。
     *
     * 　　④、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr){
        if(arr == null || arr.length == 0){
            return arr;
        }
        int temp;
        for(int i = 0;i<arr.length-1;i++){
            for(int j = 0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 　①、从待排序序列中，找到关键字最小的元素
     *
     * 　　②、如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换
     *
     * 　　③、从余下的 N - 1 个元素中，找出关键字最小的元素，重复(1)、(2)步，直到排序结束
     * @param arr
     * @return
     */
     public static int[] selectionSort(int[] arr){
         if(arr == null || arr.length == 0){
             return arr;
         }
         int sub;
         int temp;
         for(int i = 0;i<arr.length-1;i++){
             sub = i;
             for(int j = i+1;j<arr.length;j++){
                 if(arr[sub]>arr[j]){
                     sub = j;
                 }
             }
             if(sub != i){
                 temp = arr[sub];
                 arr[sub] = arr[i];
                 arr[i] = temp;
             }

         }
         return arr;
    }

    /**
     * 直接插入排序基本思想是每一步将一个待排序的记录，
     * 插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
     *
     * 插入排序还分为直接插入排序、二分插入排序、链表插入排序、希尔排序等等
     * ，这里我们只是以直接插入排序
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr){
        int temp,j;
        for(int i = 1;i<arr.length;i++){
            temp = arr[i];
            j = i;
            while(j>0 && temp<arr[j-1]){
                arr[j] =arr[j-1];
                j--;
            }
            arr[j] = temp;

        }
         return arr;
    }


    public static void main(String[] args) {
        int[] arrays = new int[]{1,2,3,7,2,5,18,10};
        arrays = insertSort(arrays);
        for(int x:arrays){
            System.out.print(x);
        }

    }
}
