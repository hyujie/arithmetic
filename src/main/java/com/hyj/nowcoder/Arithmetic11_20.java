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

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，
     * 当然我们需要合成后的链表满足单调不减规则。
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode alist = list1;
        ListNode blist = list2;
        ListNode listNode = null,p = null;
        int a,b;
        while (alist!= null && blist != null){
            a = alist.val;
            b = blist.val;
            if(a <= b){
                //
                if(listNode == null){
                    listNode = alist;
                    p = listNode;
                }else{
                    p = p.nextNode = alist;
                }
                alist = alist.nextNode;

            }else{
                //
                if(listNode == null){
                    listNode = blist;
                    p = listNode;
                }else{
                    p = p.nextNode = blist;
                }
                blist = blist.nextNode;
            }

        }
        if(alist != null){
            if(listNode == null){
                listNode = alist;
            }else{
                p.nextNode = alist;
            }

        }else if(blist != null){
            if(listNode == null){
                listNode = blist;
            }else{
                p.nextNode = blist;
            }
        }
        return listNode;
    }

    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * @param root1
     * @param root2
     * @return
     */
    public static boolean HasSubtree(BinaryTreeNode root1,BinaryTreeNode root2) {
        boolean result = false;
        if(root1 != null && root1 != null){
            if(root1.val == root2.val){
                if(DoesTree1HaveTree2(root1,root2)){
                    return true;
                }
            }
            result = HasSubtree(root1.left,root2)||HasSubtree(root2.right,root2);
        }
        return result;
    }

    public static boolean DoesTree1HaveTree2(BinaryTreeNode root1,BinaryTreeNode root2){
        if(root1 == null && root2 != null) return false;
        if(root2 == null) return true;
        if(root1.val != root2.val) return false;
        return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
    }
    public static void main(String[] args) {
        ListNode listNode = ListNode.buildListNode(new int[]{1,2,3,4,5});
        ListNode listNode2 = ListNode.buildListNode(new int[]{6,7,8});
        ListNode listNode3 = Merge(listNode,listNode2);
        System.out.println(listNode3.val);
        //System.out.println(ReverseList(listNode3).val);
        listNode3.printString();
        System.out.println();
       // System.out.println(FindKthToTailII(listNode,5).val);
//        System.out.println( ReverseList(listNode).val);
    }
}
