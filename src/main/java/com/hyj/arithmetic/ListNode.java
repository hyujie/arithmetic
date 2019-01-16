package com.hyj.arithmetic;

import com.hyj.arithmetic.easy.EasyArithmetic;

/**
 * @version 1.0
 * @ Authord  yujie huang  email: 190158792@qq.com
 * @ Description 链表对象
 * @ Date Create by in 10:05 2019/1/15
 */
public class ListNode {
    public int val;
    public ListNode nextNode;
    public ListNode(int x) {
        val = x;
    }

    /**
     * 添加元素
     * @param input
     */
    public static  ListNode buildListNode(int[] input){
        ListNode first = null,last = null,newNode;
        if(input.length >0){

            for(int num:input){
                newNode = new ListNode(num);
                if(first == null){
                    first = newNode;
                    last = newNode;
                }else{
                    last.nextNode = newNode;
                    last = newNode;
                }
            }
        }
        return first;
    }

    public static ListNode remove(ListNode head,int val){
        if(head==null){
            return null;
        }
        ListNode p=head,q=head.nextNode;
        while(q!=null){
            if(q.val==val){
                p.nextNode=q.nextNode;
                q=q.nextNode;
            }else{
                p=p.nextNode;
                q=q.nextNode;
            }
        }
        if(head.val==val){
            return head.nextNode;
        }
        return head;

    }
}
