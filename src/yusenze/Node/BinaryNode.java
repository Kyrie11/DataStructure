package yusenze.Node;

import java.util.function.BinaryOperator;

public class BinaryNode<T> {
    public T data;
    public BinaryNode<T> left,right;
    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public BinaryNode(T data){
        this(data,null,null);
    }
    public boolean isLeaf(){//判断是否是叶节点
        return this.left==null&&this.right==null;
    }
}
