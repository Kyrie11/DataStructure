package yusenze.Queue;

import yusenze.Interface.Queue;
import yusenze.Node.Node;
/*
 * 链式队列
 */
public class LinkedQueue<T> implements Queue<T> {
    private Node<T> front,rear;//头指针和尾指针

    public LinkedQueue(){
        this.front=this.rear=null;
    }

    @Override
    public boolean isEmpty(){
        return this.front==null&&this.rear==null;
    }

    @Override
    public boolean add(T x) {
        if(x==null)
            return false;
        Node<T> node = new Node<T>(x);
        if(this.front == null)
            this.front=node;
        else
            this.rear.next = node;
        this.rear = node;
        return true;
    }

    @Override
    public T peek() {//返回队头元素,不删除
        return this.isEmpty()?null:this.front.data;
    }

    @Override
    public T poll() {//出队且删除
        if(this.isEmpty())
            return null;
        T x = this.front.data;
        this.front = this.front.next;
        if(this.front==null)
            this.rear=null;
        return x;
    }

}
