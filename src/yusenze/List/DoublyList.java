package yusenze.List;

import yusenze.Node.DoubleNode;

/*
 * @Description:双链表
 */
public class DoublyList<T> {
    private DoubleNode<T> head;

    public DoublyList(){
        this.head = new DoubleNode<T>();
    }

    /*
     *@Description:深拷贝
     */
    public DoublyList(DoublyList<T> list){
        this();
        DoubleNode<T> pointer = this.head;
        DoubleNode<T> p = list.head.next;
        while(p!=null){
            pointer.next = new DoubleNode<>(p.data,pointer,null);
            p=p.next;
            pointer = pointer.next;
        }
    }

    public DoublyList(T[] values){
        this();
        DoubleNode<T> p = this.head;
        for(int i=0;i<values.length;i++){
            p.next=new DoubleNode<T>(values[i],p,null);
            p=p.next;
        }
    }

    public void insert(T data){
        int i=0;
        DoubleNode<T> p = this.head.next;
        while(p.next!=null){
            p=p.next;
            i++;
        }
        p.next = new DoubleNode<T>(data,p,null);
    }

    public void insert(int i,T data){
        if(i<0)
            throw new NullPointerException("越界");
        DoubleNode<T> p = this.head;
        for(int j=0;j<i;j++){
            p=p.next;
        }
        p.next = new DoubleNode<>(data,p,null);

    }

    @Override
    public String toString(){
        String str="{";
        DoubleNode<T> p = this.head.next;
        while(p!=null){
            str+=p.data.toString()+" ";
            p=p.next;
        }
        return str+"}";
    }

    /*
     *@Description:尾插入子集
     */
    public void addAll(DoublyList<T> list){
        DoubleNode<T> p = list.head.next;
        while(p!=null) {
            this.insert(p.data);
            p = p.next;
        }
    }

    public static void main(String...args){
        Integer values[] = new Integer[]{10,20,30,30,40,41,50,60};
        DoublyList<Integer> list = new DoublyList<>(values);
        System.out.println("原list:"+list.toString());

        Integer values2[] = new Integer[]{1,2,3,4};
        DoublyList<Integer> list1 = new DoublyList<>(values2);
        list.addAll(list1);
        System.out.println("list尾插入list1后："+list.toString());
        System.out.println("原list1："+list1.toString());
        System.out.println("深拷贝list1得到："+(new DoublyList<Integer>(list1)).toString());
    }
}