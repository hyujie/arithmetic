package com.hyj.datastructure.queue;

/**
 * @version 1.0
 * @Authord yujie huang  email: 190158792@qq.com
 * @Description
 * @Date Create by in 17:31 2019/3/1
 */
public class PriorityQueue<T extends Comparable> {
    private Object[] array;
    //队列中元素的实际数目
    private int nItems;
    private int maxSize;

    public PriorityQueue(int size){
        if(size < 0){
            throw new IllegalArgumentException("Illegal Capacity: "+
                    size);
        }else{
            this.maxSize = size;
            array = new Object[maxSize];
        }
    }

    /**
     * 插入数据
     * @param value
     */
    public void insert(T value){
        Comparable<? super T> s = value;
        if(!isFull()){
            if(nItems == 0){
                array[nItems++] = value;
            }else{
                int j;
                j = nItems-1;
                while(j>=0 && s.compareTo((T)array[j])<0 ){
                    array[j+1] = array[j];
                    j--;
                }
                array[j+1] = value;
                nItems++;
            }
        }

    }

    /**
     *
     * @return
     */
    public T remove(){
        int k = nItems -1;
        T value = (T)array[k];
        array[k] = null;//-1表示这个位置的数据被移除了
        nItems--;
        return value;
    }

    //查看优先级最高的元素
    public T peekMin(){
        return (T)array[nItems-1];
    }

    //判断是否为空
    public boolean isEmpty(){
        return (nItems == 0);
    }

    //判断是否满了
    public boolean isFull(){
        return (nItems == maxSize);
    }


    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(3);
        priorityQueue.insert(1);
        priorityQueue.insert(2);
        priorityQueue.insert(3);
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        priorityQueue.insert(1);
        priorityQueue.insert(2);
        priorityQueue.insert(3);
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.remove());
    }
}
