package com.hyj.datastructure.queue;

import java.util.ArrayList;

/**
 * @version 1.0
 * @Authord yujie huang  email: 190158792@qq.com
 * @Description
 * @Date Create by in 16:17 2019/3/1
 */
public class CycleQueue<T> {

    Object[] array ;
    int head = 0;
    int tail ;
    int size ;
    //队列中元素的实际数目
    private int nItems;
    public CycleQueue(int size){
        if(size<0){
            throw new IllegalArgumentException("Illegal Capacity: "+
                    size);
        }else{
            tail = size-1;
            this.size = size;
            this.array = new Object[size];
        }
        nItems = 0;
    }

    /**
     * 添加
     * @param value
     */
    public void push(T value){
        if(isFull()){
            throw new IllegalArgumentException("Illegal Capacity: "+
                    size);
        }
        if(tail == size-1){
            tail = -1;
        }
        array[++tail] = value;

        nItems++;
    }

    /**
     * 出队列
     */
    public T remove(){
        if(nItems == 0){
            return null;
        }
        T value = (T)array[head++];
        if(head == size){
            head = 0;
        }
        nItems--;
        return value;
    }

    /**
     *
     * @return
     */
    public boolean isFull(){
        return nItems == size;
    }

    //查看对头数据
    public Object peekFront(){
        return array[head];
    }

    public static void main(String[] args) {
        CycleQueue<Integer> cycleQueue = new CycleQueue<>(5);
        cycleQueue.push(1);
        cycleQueue.push(2);
        cycleQueue.push(3);
        cycleQueue.push(4);;

    }
}
