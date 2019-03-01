package com.hyj.datastructure.rbtree;

/**
 * @version 1.0
 * @Authord yujie huang  email: 190158792@qq.com
 * @Description
 * @Date Create by in 15:29 2019/2/28
 */
public class RBNode<T extends Comparable<T>> {
    private boolean color;
    private T var;
    private RBNode<T> left;//左
    private RBNode<T> right;//右
    private RBNode<T> parent;//父节点
    private RBNode<T> root;

    public RBNode(boolean color,T var,RBNode<T> parent,RBNode<T> left,RBNode<T> right){
        this.color = color;
        this.var = var;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public T getVar(){
        return var;
    }

    public String getColor(){
        return color?"R":"B";
    }

    public String toString(){
        return var+getColor();
    }

    /*************对红黑树节点x进行左旋操作 ******************/
    /*
     * 左旋示意图：对节点x进行左旋
     *     p                       p
     *    /                       /
     *   x                       y
     *  / \                     / \
     * lx  y      ----->       x  ry
     *    / \                 / \
     *   ly ry               lx ly
     * 左旋做了三件事：
     * 1. 将y的左子节点赋给x的右子节点,并将x赋给y左子节点的父节点(y左子节点非空时)
     * 2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
     * 3. 将y的左子节点设为x，将x的父节点设为y
     */
    private void leftRotate(RBNode<T> x){
        RBNode<T> y = x.right;
        x.right = y.left;
        if(y.left != null){
            y.left.parent = x;
        }
        y.parent = x.parent;
        if(x.parent != null){
            if(x.parent.left == x ){
                x.parent.left = y;
            }else {
                x.parent.right = y;
            }
        }else{
            root = y;
        }

        y.left = x;
        x.parent = y;
    }
    /*************对红黑树节点y进行右旋操作 ******************/
    /*
     * 左旋示意图：对节点y进行右旋
     *        p                   p
     *       /                   /
     *      y                   x
     *     / \                 / \
     *    x  ry   ----->      lx  y
     *   / \                     / \
     * lx  rx                   rx ry
     * 右旋做了三件事：
     * 1. 将x的右子节点赋给y的左子节点,并将y赋给x右子节点的父节点(x右子节点非空时)
     * 2. 将y的父节点p(非空时)赋给x的父节点，同时更新p的子节点为x(左或右)
     * 3. 将x的右子节点设为y，将y的父节点设为x
     */
    private void rightRotate(RBNode<T> y){
        RBNode<T> x = y.left;
        y.left = x.right;
        if(x.right != null){
            x.right.parent = y;
        }
        x.parent = y.parent;
        if(y.parent != null){
            if(y.parent.left == y){
                y.parent.left = x;
            }else{
                y.parent.right = y;
            }
        }else{
            root = x;
        }
        x.right = y;
        y.parent = x;
    }

    public void insert(T var){
        RBNode<T> node = new RBNode<T>(true,var,null,null,null);
        if(node != null){
            insert(node);
        }
    }
    public void insert(RBNode<T> node){
        if(root == null){
            root = node;
        }
        RBNode parent = null;
        RBNode copy = root;
        Comparable<? super T> s = node.var;
        while(copy != null){
            parent = copy;
            if(s.compareTo((T)copy.var)>0){
                copy = copy.right;
            }else if(s.compareTo((T)copy.var)<0){

                copy = copy.left;
            }else{
                return;
            }
        }
        node.parent = parent;
        if(parent != null){
            if(s.compareTo((T)parent.var)>0){
                parent.right = node;
            }else{
                parent.left = node;
            }
        }else{
            root = node;
        }
        //3.利用旋转操作将其修正为一颗红黑树
        insertFixUp(node);
    }

    public void insertFixUp(RBNode<T> node){
        RBNode parent,gparent,uncle;
        //
        while((parent = getParent(node)) != null && parent.color){
            gparent = getParent(parent);

            if(parent == gparent.left){
                uncle = gparent.right;
                if(uncle !=null&&uncle.color){
                    parent.color = false;
                    uncle.color = false;
                    gparent.color = true;
                    node = gparent;
                    continue;
                }
                //case2:叔叔节点是黑色，且当前节点是右子节点
                if(node == parent.right){
                    leftRotate(parent);
                    RBNode<T> temp = parent;
                    parent = node;
                    node = temp;
                }
                //case3:叔叔节点是黑色，且当前节点是左子节点
                parent.color = false;
                gparent.color = true;
                rightRotate(gparent);
            }else{
                uncle = gparent.left;
                if(uncle !=null&&uncle.color){
                    parent.color = false;
                    uncle.color = false;
                    gparent.color = true;
                    node = gparent;
                    continue;
                }
                //case2:叔叔节点是黑色，且当前节点是右子节点
                if(node == parent.left){
                    leftRotate(parent);
                    RBNode<T> temp = parent;
                    parent = node;
                    node = temp;
                }
                //case3:叔叔节点是黑色，且当前节点是左子节点
                parent.color = false;
                gparent.color = true;
                rightRotate(gparent);
            }
        }
        root.color = false;
    }

    public RBNode<T> getParent(RBNode<T> node){
        return node.parent;

    }
}
