package com.hyj.datastructure;

/**
 * @version 1.0
 * @Authord yujie huang  email: 190158792@qq.com
 * @Description
 * @Date Create by in 16:34 2019/2/26
 */
public interface B_Tree<T> {

    Node find(T k);

    boolean insert(T k);

    boolean delete(T k);
}
