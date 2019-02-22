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
        while(i<j){
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


    /**
     * 递归法
     * 大家都知道斐波那契数列，现在要求输入一个整数n，
     * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * n<=39
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        //0,1,1,2,3,5,8........ f(n) = f(n-1) + f(n-2);
        if( n == 1){
            return 1;
        }
        if (n == 0){
            return 0;
        }
        return Fibonacci(n - 2)+Fibonacci(n-1);

    }

    /**
     * 循环法
     * @param n
     * @return
     */
    public static int Fibonacci2(int n) {
        //0,1,1,2,3,5,8........ f(n) = f(n-1) + f(n-2);

        int first = 0;
        int second  =1;
        int i = 2;
        int result = 0;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        while(i <= n){
            result = first + second;
            first = second;
            second = result;
            i++;
        }
        return result;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * @param target
     * @return
     */
    public static int JumpFloor(int target) {
        //1 2 3 5 8 13
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        int first = 1;
        int second = 2;
        int n = 3;
        int result = 0;
        while(n<=target){
            result = first + second;
            first = second;
            second = result;
            n++;
        }
        return result;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * @param target
     * @return
     */
    public static int JumpFloorII(int target) {
        int n =1;
        int result = 1;
        while(n<target){
            result *=2;
            n++;
        }
        return result;
    }

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * @param target
     * @return
     */
    public  static int RectCover(int target) {
        //f(n) = f(n-1)+f(n-2)
                if(target == 0){
            return 0;
        }
        if(target == 2){
            return 2;
        }
        if(target == 1){
            return 1;
        }
        return RectCover(target -1)+RectCover(target  -2);

    }

    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        if(exponent == 0){
            return 1;
        }
        double rsl = base;
//        if(exponent >0){
//            for(int i = 1;i<exponent;i++){
//                rsl = rsl*base;
//            }
//        } else{
//                for(int i = exponent+1;i<0;i++){
//                    System.out.println(rsl+":"+base);
//                    rsl = rsl*base;
//
//                }
//            }
        for(int i = 1;i<Math.abs(exponent);i++){
                rsl = rsl*base;
        }
            return exponent >0?rsl:1/rsl;
    }

    public static double PowerII(double base, int exponent) {
        if(exponent<0){
            ;
        }
        if(exponent == 1){
            return base;
        }
        if(exponent == 0){
            return 1;
        }
        return exponent>0?base*PowerII(base,Math.abs(exponent)-1):1/(base*PowerII(base,Math.abs(exponent)-1));
    }

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param array
     */
    public static void reOrderArray(int [] array) {
        int[] rsl = new int[array.length];
        int oddnum = 0;
        int evennum = array.length-1;
        int i = 0,j = array.length - 1;
        while(i<=j){
            if(array[oddnum]%2 == 1){
                rsl[i++] = array[oddnum];
                oddnum++;
            }else{
                oddnum++;
            }
            if(array[evennum]%2 == 0){
                rsl[j--] = array[evennum];
                evennum--;
            }else{
                evennum--;
            }

        }
        for(int s:rsl){
            System.out.println(s);
        }
    }
    public static void reOrderArrayII(int [] array) {
        int i = 0;
        int firstEvenNum  = -1;
        int temp;
        int temp2;
        int lastOdd;
        while(i<array.length){
            if(array[i]%2 == 1){

                if(firstEvenNum != -1){
                    lastOdd = array[i];
                    temp = array[firstEvenNum];
                    for(int n = firstEvenNum;n<i;n++){
                        temp2 = array[n+1];
                        array[n+1] = temp;
                        temp = temp2;
                    }

                    array[firstEvenNum] = lastOdd;
                    firstEvenNum++;
                }
            }else{
                if(firstEvenNum == -1){
                    firstEvenNum = i;
                }
            }
            i++;
        }
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
//        int[] arr = {6,6,6,6};
////        System.out.println(minNumberInRotateArray(arr));
        //System.out.println(RectCover(4));
        //System.out.println(PowerII(2,1));
        reOrderArrayII(new int[]{1,2,3,4,5,6,7});
    }

}
