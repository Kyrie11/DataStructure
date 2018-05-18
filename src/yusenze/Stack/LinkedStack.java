package yusenze.Stack;

import sun.awt.image.ImageWatched;
import yusenze.Interface.Stack;
import yusenze.List.SinglyList;
import yusenze.Node.Node;

/*
 * @Description:链式栈
 * @Author:余森泽
 */
public class LinkedStack<T> implements Stack<T> {

    private SinglyList<T> list;//使用单链表存储栈元素

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public LinkedStack(){
        this.list = new SinglyList<T>();
    }

    public LinkedStack(T[] values){
        this.list = new SinglyList(values);
    }

    public LinkedStack(SinglyList<T> list){
        this.list = new SinglyList(list);
    }

    public LinkedStack(LinkedStack<T> stack){
        this.list = new SinglyList<>(stack.list);
    }

    @Override
    public void push(T x) {//元素x入栈，空对象不能入栈，单链表头插入
        this.list.insert(0,x);
    }

    @Override
    public T peak() {//返回栈顶元素
        return this.list.get(0).data;
    }

    @Override
    public T pop() {//出栈
        return this.list.remove(0).data;
    }

    /*
     *@Description:遍历栈
     * @Author:余森泽
     */
    public void TraverseStack(){

    }

    @Override
    public String toString(){
        String str="{";
        Node<T> p = this.list.head.next;
        while(p!=null){
            str+=p.data.toString()+" ";
            p=p.next;
        }
        return str+"}";
    }

    public static void main(String...args){
        Integer[] values = new Integer[]{1,2,3,20,30,10,12};
        LinkedStack<Integer> stack = new LinkedStack<>(values);
        System.out.println(stack.toString());

        System.out.println("出栈一个元素后：");
        stack.pop();
        System.out.println(stack.toString());

        System.out.println("返回栈顶元素:"+stack.peak());

        stack.push(99);
        System.out.println("元素99入栈后:"+stack.toString());
    }
}