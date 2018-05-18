package yusenze.Node;

import yusenze.GeneralList.GenList;

/*
 * 广义表结点类
 */
public class GenNode<T> {
    public T data;
    public GenList<T> child;//地址域，指向子表
    public GenNode<T> next;//地址域，指向后继结点

    public GenNode(T data,GenList<T> child,GenNode<T> next){
        this.data=data;
        this.child=child;
        this.next=next;
    }

    public GenNode(T data){
        this(data,null,null);
    }

    public GenNode(){}

    public String toString(){
        return "("+data.toString()+","+child.toString()+"."+next.toString()+")";
    }
}
