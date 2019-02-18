package com.hyj.nowcoder;

import com.hyj.arithmetic.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @Authord yujie huang  email: 190158792@qq.com
 * @Description
 * @Date Create by in 16:24 2019/2/15
 */
public class Arithmetic1_10 {

    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
     * 判断数组中是否含有该整数。
     * @param target
     * @param array
     * @return
     */
    public static boolean find(int target, int [][] array) {

//        if(count < 0){
//            return false;
//        }
//        if(target<array[0][0] && target>array[array.length - 1][count]){
//            return false;
//        }
        int count =  array[0].length - 1;
        for(int i = 0;i<array.length;i++){
            while(count>=0&&array[i][count]>target){
                count--;
            }
            if(count>=0){
                if(array[i][count] == target){
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     * @param listNode
     * @return
     */
    static  ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            printListFromTailToHead(listNode.nextNode);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int [] array) {
        //{78926}
        int l = array.length;
        int i = 0;
        int j = l-1;
        while(i<array.length&&j>0&&i<j){
            if(array[i]>array[i + 1]){
                System.out.println(i);
                return array[i+1];
            }
            if(array[j]<array[j-1]){
                return array[j];
            }
            i++;
            j--;
        }
        return l == 0?0:array[j];
    }
    public static void main(String[] args) {
        //5,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
//        int[][] x = {
//                {1,2,8,9},
//                {2,4,9,12},
//                {4,7,10,13},
//                {6,8,11,15}
//
//        };
//        System.out.println(find(6,x));
//        int[] arr = {1,2,3,4,5};
//        ListNode listNode = ListNode.buildListNode(arr);
//        System.out.println(listNode.val);
//        List<Integer> arrayList = printListFromTailToHead(listNode);
//        System.out.println(arrayList.get(0));
//        for(Integer s:arrayList){
//            System.out.println(s);
//        }
        int[] arr = {6,6,6,6};
        System.out.println(minNumberInRotateArray(arr));
    }

}
