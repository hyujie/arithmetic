package com.hyj.datastructure.btree;

/**
 * @version 1.0
 * @Authord yujie huang  email: 190158792@qq.com
 * @Description
 * @Date Create by in 16:34 2019/2/26
 */
public class Node<T> {
    public T var;
    public Node<T> rightChild;//右支点
    public Node<T> leftChild;//左支点
    public boolean isdelete = false;
    public  Comparable<? super T> comparable;

    public Node(T var){
        this.var = var;
    }

    public void printData(){
        System.out.println(var);
    }
}
