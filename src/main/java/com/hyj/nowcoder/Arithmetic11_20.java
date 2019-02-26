package com.hyj.nowcoder;

import com.hyj.arithmetic.ListNode;
import com.sun.imageio.plugins.common.I18N;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Authord yujie huang  email: 190158792@qq.com
 * @Description
 * @Date Create by in 10:26 2019/2/26
 */
public class Arithmetic11_20 {

    /*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
    /**
     *     输入一个链表，输出该链表中倒数第k个结点。
     */
    public static ListNode FindKthToTail(ListNode head, int k) {

        if(k<=0){
            return null;
        }
        int count = 1;
        Map<Integer,ListNode> map = new HashMap<Integer, ListNode>(20);
        if(head != null){
            map.put(count,head);
        }
        while(head.nextNode != null){
            count++;
            head = head.nextNode;
            map.put(count,head);
        }
        if(k>count){
            return null;
        }

        return  null;

    }
    public static ListNode FindKthToTailII(ListNode head, int k) {
        int count = 0;
        ListNode listNode = head;
        while(head != null){
            head = head.nextNode;
            count++;
            if(count>k){
                listNode = listNode.nextNode;
            }
        }
        return count<k?null:listNode;
    }


    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     * @param head
     * @return
     */
    public static ListNode ReverseList(ListNode head) {

        return ListNode.ReverseList(head);
    }
    public static void main(String[] args) {
        ListNode listNode = ListNode.buildListNode(new int[]{1,2,3,4,5});
       // System.out.println(FindKthToTailII(listNode,5).val);
        System.out.println( ReverseList(listNode).val);
    }
}
