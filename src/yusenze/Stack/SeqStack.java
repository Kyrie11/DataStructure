package yusenze.Stack;
/*
 * 顺序栈
 */
import yusenze.Interface.Stack;
import yusenze.List.SeqList;

public final class SeqStack<T> implements Stack<T> {
    private SeqList<T> list;

    public SeqStack(){
        this.list=null;
    }

    public SeqStack(int length){
        this.list = new SeqList<T>(length);
    }

    @Override
    public boolean isEmpty() {
        return list.size()==0;
    }

    @Override
    public T peak() {//返回栈顶元素(未出栈)
        return this.list.get(list.size()-1);
    }

    @Override
    public T pop() {//出栈
        return list.remove(list.size()-1);
    }
    /*
     * 入栈
     */
    @Override
    public void push(T x) {
        this.list.insert(x);
    }
}
