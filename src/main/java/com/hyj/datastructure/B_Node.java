package com.hyj.datastructure;

/**
 * @version 1.0
 * @Authord yujie huang  email: 190158792@qq.com
 * @Description
 * @Date Create by in 17:01 2019/2/26
 */
public class B_Node<T> implements B_Tree<T>{

    private Node root;//根节点

    public B_Node(Node<T> root) {
        this.root = root;
    }



    public Node find(T k) {
        Node<T> node = root;
        if(root.comparable == null){
            Comparable<? super T> s = (Comparable<? super T>) k;
            while(node != null){
                if(s.compareTo((T)node.var)>0){
                    node = node.rightChild;
                }else if (s.compareTo(k)<0){
                    node = node.leftChild;
                }else{
                    return node;
                }
            }

        }
        return null;
    }

    public boolean insert(T k) {
        Comparable<? super T> s = (Comparable<? super T>) k;
        Node<T> node = new Node<T>(k);
        if(root == null){
            root = node;
            return true;
        }
        Node<T> copy = root;
        Node<T> parent;
        while(copy != null){
            parent = copy;
            if(s.compareTo((T)copy.var)>0){
                copy = copy.rightChild;
                if(copy == null){
                    parent.rightChild = node;
                    return true;
                }
            }else if(s.compareTo((T)copy.var)<0){
                copy = copy.leftChild;
                if(copy == null){
                    parent.leftChild = node;
                    return true;
                }
            }else {
                return false;
            }
        }
        return false;
    }

    public boolean delete(T k) {
        Node<T> parent = null;
        Node<T> copy = root;
        boolean isLeft = false;
        if(root.comparable == null){
            Comparable<? super T> s = (Comparable<? super T>) k;
            while(copy != null){
                if(s.compareTo((T)copy.var)>0){
                    parent = copy;
                    copy = copy.rightChild;
                    isLeft = false;
                }else if (s.compareTo(k)<0){
                    parent = copy;
                    copy = copy.leftChild;
                    isLeft = true;
                }else{
                    break;
                }
            }
            if(copy == null){
                return false;
            }
        }
        if(copy.rightChild == null && copy.leftChild == null){
            if(copy == root){
                root = null;
            }else if(isLeft){
                parent.leftChild = null;
            }else {
                parent.rightChild = null;
            }
            return true;
        }
        if(copy.rightChild == null && copy.leftChild != null){
            if(copy == root){
                root = null;
            }else if(isLeft){
                parent.leftChild = copy.leftChild;
            }else{
                parent.rightChild = copy.leftChild;
            }
            return true;
        }else if(copy.rightChild != null && copy.leftChild == null) {
            if(copy == root){
                root = null;
            }else if(isLeft){
                parent.leftChild = copy.rightChild;
            }else{
                parent.rightChild  = copy.rightChild;
            }
            return true;
        }
        Node<T> parentNode = null;
        Node<T> nodeR = copy.rightChild;
        if(nodeR.leftChild == null){
            if(copy == root){
                root = null;
            }else if(isLeft){
                nodeR.leftChild = copy.leftChild;
                parent.leftChild = nodeR;

            }else{
                nodeR.leftChild = copy.leftChild;
                parent.rightChild  = nodeR;
            }
        }else{
            while (nodeR.leftChild != null){
                parentNode = nodeR;
                nodeR = nodeR.leftChild;
            }
            parentNode.leftChild = nodeR.rightChild;
            nodeR.leftChild = copy.leftChild;
            nodeR.rightChild = copy.rightChild;
            if(copy == root){
                root = null;
            }else if(isLeft){
                parent.leftChild = nodeR;
            }else{
                parent.rightChild  = nodeR;
            }
            return true;
        }

        return false;
    }


    //中序遍历
    public void infixOrder(Node current){
        if(current != null){
            infixOrder(current.leftChild);
            System.out.print(current.var+" ");
            infixOrder(current.rightChild);
        }
    }

    //前序遍历
    public void preOrder(Node current){
        if(current != null){
            System.out.print(current.var+" ");
            preOrder(current.leftChild);
            preOrder(current.rightChild);
        }
    }

    //后序遍历
    public void postOrder(Node current){
        if(current != null){
            postOrder(current.leftChild);
            postOrder(current.rightChild);
            System.out.print(current.var+" ");
        }
    }

    public Node<T> findMin(){
        if(root == null){
            return null;
        }
        Node<T> c = root;
        while(c != null){
            if(c.leftChild != null){
                c = c.leftChild;
            }else {
                return c;
            }
        }
        return null;
    }

    public Node<T> findMax(){
        if(root == null){
            return null;
        }
        Node<T> c = root;
        while(c != null){
            if(c.rightChild != null){
                c = c.rightChild;
            }else {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args)throws Exception {
        Node<Integer> node = new Node<Integer>(10);
        B_Node<Integer> b_node = new B_Node<Integer>(node);
        b_node.insert(20);
        b_node.insert(9);
        b_node.insert(21);
        b_node.insert(22);
        b_node.insert(2);
        b_node.insert(6);
        System.out.println(node.rightChild.var);
        b_node.infixOrder(b_node.root);
        System.out.println();
        b_node.postOrder(b_node.root);
        System.out.println();
        b_node.preOrder(b_node.root);
        System.out.println();
        System.out.println(b_node.findMin().var);
        System.out.println(b_node.findMax().var);

    }


}

