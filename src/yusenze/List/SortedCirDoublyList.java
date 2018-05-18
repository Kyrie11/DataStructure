package yusenze.List;

import yusenze.Node.DoubleNode;

import javax.swing.event.DocumentEvent;

public class SortedCirDoublyList<T> {
    public DoubleNode<T> head;
    public boolean isEmpty(){
        return head==head.next;
    }
    public T removeLast(){
        T data = head.prev.data;
        DoubleNode<T> p = head.prev.prev;
        head.prev = head.prev.prev;
        p.next = head;
        return data;
    }
    public T remove(int i){
        DoubleNode<T> p = this.head;
        for(int j=0;j<=i;j++){
            p=p.next;
        }
        T data=p.data;
        p.prev.next =  p.next.next;
        p.next.prev = p.prev;
        return data;
    }
    public T get(int i){
        DoubleNode<T> p = this.head;
        for(int j=0;j<=i;j++){
            p=p.next;
        }
        return p.data;
    }
    public DoubleNode<T> insert(int i,T data){
        DoubleNode<T> p = this.head;
        for(int j=0;j<i;j++){
            p=p.next;
        }
        DoubleNode<T> pointer = new DoubleNode<>(data,p,p.next);
        p.next.prev = pointer;
        p.next = pointer;
        return pointer;
    }
    public DoubleNode<T> insert(T data){
        return this.insert(0,data);
    }

    public String toPreviousString(){
        if(this.head==null)
                return null;
        DoubleNode<T> p = this.head.prev;
        String previousString="";
        while(p.prev!=head)
            previousString+=p.data.toString();
        return previousString;
    }
}
