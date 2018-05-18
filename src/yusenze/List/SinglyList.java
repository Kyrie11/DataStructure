package yusenze.List;

import yusenze.Node.Node;

/*
 * 单链表的操作
 */
public class SinglyList<T> {
    public Node<T> head;

    public SinglyList(){
        this.head = new Node<T>();
    }

    public SinglyList(T[] values){
        this();
        Node<T> rear = this.head;
        for(int i=0;i<values.length;i++)
        {
            rear.next=new Node<T>(values[i],null);
            rear=rear.next;
        }
    }

    public SinglyList(Node<T> begin,Node<T> end){
        Node<T> p = begin;
        this.head.next=p;
        while(p!=end){
            p=p.next;
        }
        p=p.next;
    }

    public SinglyList(SinglyList<T> list){
        Node<T> p = list.head;
        Node<T> pointer = this.head;
        while(p.next!=null){
            pointer.next=p.next;
            p=p.next;
            pointer = pointer.next;
        }
    }
    public boolean isEmpty(){
        return head.next==null;
    }

    public SinglyList<T> remove(int begin,int end) {//删除子表
        Node<T> p = head.next;
        for(int i=0;i<begin-1;i++){
            p=p.next;
        }
        Node<T> pointer = p;
        for(int i=begin;i<end-1;i++){
            p=p.next;
        }
        pointer = p.next;
        return this;
    }
    public boolean contains(SinglyList<T> list){//判断this单链表是否包含list的所有元素
        Node<T> p = list.head,next;
        Node<T> P = this.head.next;
        while(P.next!=null){
            while(P!=p){
                P=P.next;
            }
            p=p.next;
        }
        if(p.next==null)
            return true;
        else
            return false;
    }
    public Node<T> insert(int i,T data){
        Node<T> p = this.head.next,front=this.head;
        for(int j=0;j<i;j++){
            p=p.next;
            front=front.next;
        }
        front.next = new Node<T>(data,p);
        return front.next;
    }

    public Node<T> insert(T data){
        return this.insert(0,data);
    }

    public Node<T> get(int i){
        Node<T> p = this.head;
        for(int j=0;j<=i;j++){
            p=p.next;
        }
        return p;
    }
    public Node<T> remove(int i){
        Node<T> p = this.head;
        for(int j=0;j<i;j++){
            p=p.next;
        }
        Node<T> pointer = p.next;
        p.next = p.next.next;
        return pointer;
    }

    public SinglyList<T> subList(int begin,int end){
        Node<T> p = this.head;
        SinglyList<T> list = new SinglyList<>();
        for(int i=0;i<begin;i++)
            p=p.next;
        for(int i=begin;i<end;i++){
            list.insert(i-begin,p.data);
            p=p.next;
        }
        return list;
    }

    @Override
    public String toString(){
        String str="{";
        Node<T> p = this.head.next;
        while(p!=null){
            str+=p.toString()+" ";
            p=p.next;
        }
        return str+"}";
    }
    public static void main(String...args){
        Integer values[] = new Integer[]{19,20,21,22,23,24,25,26,27,28,29,30};
        SinglyList<Integer> list = new SinglyList<>(values);
        System.out.println(list.toString());
        SinglyList<Integer> sublist = list.subList(2,10);
        System.out.println((sublist.toString()));
    }
}
