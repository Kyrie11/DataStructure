package yusenze.Node;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadNode<T> {
    public T data;
    public ThreadNode<T> left,right;
    public boolean ltag,rtag;
    public ThreadNode(T data,ThreadNode<T> left,boolean ltag,ThreadNode<T> right,boolean rtag) {
        this.data=data;
        this.left=left;
        this.right=right;
        this.rtag=rtag;
    }
    public ThreadNode(T data){
        this(data,null,false,null,false);
    }
    public boolean isLeaf(){
        return this.left==null&&this.right==null;
    }
}
