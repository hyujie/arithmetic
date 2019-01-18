package com.hyj.arithmetic.easy;

import com.hyj.arithmetic.ListNode;

/**
 * @version 1.0
 * @authord  yujie huang  email: 190158792@qq.com
 * @description
 * @date Create by in 11:02 2019/1/10
 */
public class EasyArithmetic {
    /**
     * 给定一个整数数组，返回两个数字的索引，使它们相加成为一个特定的目标。
     * 您可能假设每个输入只有一个解决方案，并且您可能不会两次使用相同的元素。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        for(int i = 0;i<nums.length;i++){
            for(int n = i+1;n<nums.length;n++){
                int temp = nums[i]+nums[n];
                if(temp == target){
                    return new int[]{i,n};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode result = new ListNode(0);
        ListNode temp1 =l1,temp2 = l2;
        ListNode first = null,last = null,resultTemp;
        int num = 0;
        int i = 0;
        while(temp1 != null || temp2 != null){
            int n = (temp1 == null)?0:temp1.val;
            int m = (temp2 == null)?0:temp2.val;
            num = (m+n+i)%10;
            i = (m+n+i)/10;
            resultTemp= new ListNode(num);
            if(first == null){
                first = resultTemp;
                last = resultTemp;
            }else {
                last.nextNode = resultTemp;
                last = last.nextNode;
            }

            temp1 = (temp1 != null)?temp1.nextNode:null;
            temp2 = (temp2 != null)?temp2.nextNode:null;
        }
        if(i == 1){
            resultTemp= new ListNode(i);
            last.nextNode = resultTemp;

        }
        return first;
    }

    public static void main(String[] args) {
        EasyArithmetic arithmetic = new EasyArithmetic();
        System.out.println(arithmetic.reverse2(-123));

    }

    public int reverse(int x) {
        String temp = x+"";
        StringBuffer buffer = new StringBuffer();
        if(x<0){
            buffer.append("-");
            for(int i = temp.length()-1;i>0;i--){
                buffer.append(temp.charAt(i));
            }
           if(Long.valueOf(buffer.toString()) < Integer.MIN_VALUE){
               return 0;
           }else {
               return Integer.valueOf(buffer.toString());
           }

        }else {
            for(int i = temp.length()-1;i>=0;i--){
                buffer.append(temp.charAt(i));
            }
            if(Long.valueOf(buffer.toString()) > Integer.MAX_VALUE){
                return 0;
            }else {
                return Integer.valueOf(buffer.toString());
            }
        }
    }
    public int reverse2(int x) {
        String temp = x+"";

        if(x<0){
            temp = temp.replace("-","");
            StringBuffer buffer = new StringBuffer(temp);
            buffer.reverse();

            if(Long.valueOf("-"+buffer.toString()) < Integer.MIN_VALUE){
                return 0;
            }else {
                return Integer.valueOf("-"+buffer.toString());
            }

        }else {
            StringBuffer buffer = new StringBuffer(temp);
            buffer.reverse();
            if(Long.valueOf(buffer.toString()) > Integer.MAX_VALUE){
                return 0;
            }else {
                return Integer.valueOf(buffer.toString());
            }
        }
    }

}
