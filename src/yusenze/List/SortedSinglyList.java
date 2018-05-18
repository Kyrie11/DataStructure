package yusenze.List;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import yusenze.Node.Node;

import java.lang.ref.SoftReference;
import java.util.Arrays;

/*
 *排序单链表
 */
    public class SortedSinglyList<T extends Comparable<? super T>> extends SinglyList<T> {

        public SortedSinglyList(){
            super();
        }

        public SortedSinglyList(T[] values){
            super();
            for(int i=0;i<values.length;i++)
                this.insert(values[i]);
        }

        public SortedSinglyList(SortedSinglyList<T> list){
            super(list);
        }

        public Node<T> insert(T x){
            Node<T> front = this.head, p = front.next;
            while(p!=null&&x.compareTo(p.data)>0){
                front = p;
                p = p.next;
            }
            front.next = new Node<T>(x,p);
            return front.next;
        }

        public Node<T> remove(int i){
            Node<T> p = this.head;
            for(int j=0;j<i;j++)
                p = p.next;
            Node<T> pointer = p.next;
            p.next = p.next.next;
            return pointer;
        }

        public void remove(T obj){
            Node<T> front = this.head;
            Node<T> p = this.head.next;
            while(p.data != obj&&p!=null) {
                front = front.next;
                p = p.next;
            }
            if(p==null)
                return;
            else
                front.next = p.next;
        }

        public Node<T> search(T data){
            Node<T> p = this.head.next;
            while(p.data != data&&p!=null)
                p = p.next;
            return p;
        }

        public Node<T> remove(){
            return remove(0);
        }
    /*
     * @Description:集合并
     * @Param:SinglyList<T> list
     */
    public void addAll(SinglyList<T> list){
        Node<T> p = list.head.next;
        while(p!=null){
            this.insert(p.data);
            p=p.next;
        }
    }

    public SortedSinglyList<T> union(SinglyList<T> list){
        SortedSinglyList<T> list2 = new SortedSinglyList<T>();
        Node<T> p = list.head.next;
        while(p!=null){
            list2.insert(p.data);
            p=p.next;
        }
        return list2;
    }

    /*
     * @Description:返回交集
     */
    public SortedSinglyList<T> intersection(SinglyList<T> list){
        SortedSinglyList<T> sslist = new SortedSinglyList<>();
        Node<T> p = this.head.next, q = list.head.next;
        while(p!=null){
            while(q!=null){
                if(q.data==p.data)
                    sslist.insert(q.data);
                q=q.next;
            }
            q=list.head.next;
            p=p.next;
        }
        return sslist;
    }

    @Override
    public String toString(){
        String str = "{";
        Node<T> p =this.head.next;
        while(p!=null){
            str+=p.data.toString()+" ";
            p=p.next;
        }
        return str+"}";
    }

    public static void main(String...args){
        Integer values[] = new Integer[]{70,50,100,40,80,20};
        Integer values2[] = new Integer[]{1,11,33,12,40,21};
        SortedSinglyList<Integer> list1 = new SortedSinglyList<Integer>(values);
        System.out.println("list1:"+list1.toString());

        SortedSinglyList<Integer> list2 = new SortedSinglyList<>(values2);
        System.out.println("list2:"+list2.toString());

//        list1.addAll(list2);
//        System.out.println("两链表的并集:"+list1.toString());

        SortedSinglyList<Integer> intersection = list1.intersection(list2);
        System.out.println("list1与list2交集为："+intersection.toString());
    }
}
