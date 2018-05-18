package yusenze.Queue;

import yusenze.Interface.Queue;
import yusenze.List.SortedCirDoublyList;

public class PriorityQueue<T extends Comparable<? super T>> implements Queue<T> {
    private SortedCirDoublyList<T> list;//使用排序循环双链表存储

    private boolean asc;//asc指定升序或降序

    public PriorityQueue(boolean asc) {
        this.list = new SortedCirDoublyList<>();
        this.asc = asc;
    }

    public PriorityQueue() {
        this(true);
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public boolean add(T x) {
        return this.list.insert(x) != null;
    }

    public T peek() {//返回队头，不出对
        return asc?this.list.get(0):this.list.head.prev.data;
    }

    public T poll(){//出队，返回队头元素
        return this.asc?this.list.remove(0):this.list.removeLast();
    }

    public String toString(){
        return this.getClass().getName()+" "+(this.asc?this.list.toString():this.list.toPreviousString());
    }

}