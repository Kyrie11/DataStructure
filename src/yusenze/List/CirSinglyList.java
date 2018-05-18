package yusenze.List;

import yusenze.Node.Node;

public class CirSinglyList<T> extends SinglyList<T> {
    public CirSinglyList(CirSinglyList<T> list){//深拷贝
        Node<T> p = list.head;
        Node<T> pointer = this.head;
        while(p.next!=list.head){
            pointer.next = new Node<>(p.next.data,null);
            p=p.next;
            pointer = pointer.next;
        }
        pointer.next = this.head;
    }
    public CirSinglyList(){
        super();
        head.next = head;
    }
    public CirSinglyList(T[] values){
        super();
        Node<T> pointer = this.head;
        int n=values.length;
        for(int i=0;i<n;i++){
            pointer.next = new Node<T>(values[i],null);
            pointer = pointer.next;
        }
        pointer.next=head;
    }
    @Override
    public String toString(){
        Node<T> p = this.head.next;
        String str="";
        while(p.next!=null){
            str+=p.data+ " ";
            p=p.next;
        }
        return str;
    }
    @Override
    public boolean equals(Object obj){
        if(! (obj instanceof  CirSinglyList))
            return false;
        Node<T> p =this.head.next;
        Node<T> pointer = ((CirSinglyList)obj).head.next;
        while(p!=null){
            p=p.next;
            pointer=pointer.next;
            if(pointer!=p||pointer==null)
                return false;
        }
        if(pointer.next!=null)
            return false;
        else
            return true;
    }

    public boolean equals(CirSinglyList<T> list){
        if(! (list instanceof  CirSinglyList))
            return false;
        Node<T> p =this.head.next;
        Node<T> pointer = list.head.next;
        while(p!=null){
            p=p.next;
            pointer=pointer.next;
            if(pointer!=p||pointer==null)
                return false;
        }
        if(pointer.next!=null)
            return false;
        else
            return true;
    }
    public static void main(String...args){
        Integer[] values=new Integer[]{1,3,5,7,9,11,13,15};
        CirSinglyList<Integer> list1 = new CirSinglyList<>(values);
        CirSinglyList list2 = new CirSinglyList<>(list1);
        Node<Integer> p = list1.head.next;
        while(p!=list1.head){
            System.out.print(p.data+" ");
            p=p.next;
        }
        p = list2.head.next;
        while(p!=list2.head){
            System.out.print(p.data+" ");
            p=p.next;
        }
        p=list1.head;
        Node<Integer> pointer = list2.head;
        loop:while(pointer.next!=list2.head){
            if(pointer.next==p.next){
                System.out.println("浅拷贝");
                break loop;
            }
            p=p.next;
            pointer=pointer.next;
        }
        SinglyList<Integer> list3 = list2;
        System.out.println(list3.equals(list2));
    }
}
