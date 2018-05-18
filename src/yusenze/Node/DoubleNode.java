package yusenze.Node;

public class DoubleNode<T> {
    public T data;
    public DoubleNode<T> prev,next;
    public DoubleNode(T data,DoubleNode prev,DoubleNode next){
        this.data=data;
        this.prev=prev;
        this.next=next;
    }

    public DoubleNode(T data){
        this(data,null,null);
    }

    public DoubleNode(){
        this.prev=this.next=null;
    }
}
