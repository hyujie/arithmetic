package com.hyj.datastructure.stack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @version 1.0
 * @Authord yujie huang  email: 190158792@qq.com
 * @Description
 * @Date Create by in 14:31 2019/3/1
 */
public class MyStack<T> {
    Object[] array  = {};
    int top = -1;
    int maxSize = 0;
    boolean dilatationSwitch = true;
   // Class<T> type;

//    @SuppressWarnings("unchecked")
//    public MyStack (Class<T> type, int maxSize){
//        this.type = type;
//        this.maxSize = maxSize;
//        this.array = (T[]) Array.newInstance(type,maxSize);
//    }
    public MyStack(int maxSize){
        this.maxSize = maxSize;
        array = new Object[maxSize];
    }
    public MyStack(int maxSize,boolean dilatationSwitch){
        this.maxSize = maxSize;
        array = new Object[maxSize];
        this.dilatationSwitch = dilatationSwitch;
    }

    /**
     * 压栈
     * @param value
     */
    public void push(T value){
        if(dilatationSwitch ){
            isGrow(top+1);
        }
        if(top == maxSize-1){
            throw new ArrayIndexOutOfBoundsException(maxSize);
        }
        array[++top] = value;
    }

    /**
     * 出栈
     * @return
     */
    public T pop(){
        return top != -1?(T)array[top--]:null;
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public T peek(){
        return top ==-1?null:(T)array[top];
    }
    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return top == -1;
    }
    /**
     * 判断栈是否满了
     * @return
     */
    public boolean isFull(){
        return top+1 == maxSize;
    }

    /**
     *
     *  是否需要扩容，如果需要，则扩大一倍并返回true，不需要则返回false
     * @param minCapacity
     * @return
     */
    public boolean isGrow(int minCapacity){
        int oldmaxSize = maxSize;
        if(minCapacity>=maxSize){
            int newMaxSize = 0;
            if((oldmaxSize <<1)-Integer.MAX_VALUE>0){
                newMaxSize = Integer.MAX_VALUE;
            }else{
                newMaxSize = oldmaxSize <<1;
            }
            this.maxSize = newMaxSize;
           // T[] newValue = (T[]) Array.newInstance(type,newMaxSize);
            array = Arrays.copyOf(array,newMaxSize);
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<Integer>(2,true);
        myStack.push(10);
        myStack.push(9);
        myStack.push(8);
        System.out.println(myStack.maxSize);
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.isFull());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.maxSize);
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.isFull());
    }

}
