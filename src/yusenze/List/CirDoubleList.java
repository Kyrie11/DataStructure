package yusenze.List;

import yusenze.Node.DoubleNode;

import java.util.function.DoubleBinaryOperator;

public class CirDoubleList<T> {
    private DoubleNode<T> head;
    public CirDoubleList(){
        this.head = new DoubleNode<>();
        this.head.prev=this.head.next=this.head;
    }
    public boolean isEmpty(){
        return this.head==this.head.next;
    }
    public DoubleNode<T> insert(int i,T data){
        if(data==null)
            throw new NullPointerException("data==null");
        DoubleNode<T> p = new DoubleNode<>(data);
        DoubleNode<T> pointer = this.head.next;
        for(int j=0;j<i&&pointer!=head.next;j++)
            pointer=pointer.next;
        p.next = pointer.next.next;
        p.prev = pointer;
        pointer.next=p;
        return p;
    }
    public DoubleNode<T> insert(T data){//尾插入
        DoubleNode<T> pointer = this.head;
        while(pointer.next!=null)
            pointer=pointer.next;
        DoubleNode<T> p = new DoubleNode<>(data,pointer,this.head);
        return p;
    }
}
