/*
 * 栈接口
 */
package yusenze.Interface;

public interface Stack<T> {
    public abstract boolean isEmpty();//判断栈是否为空
    public abstract  void push(T x);//元素x入栈
    public abstract  T peak();//返回栈顶元素
    public abstract T pop();//出栈，返回栈顶元素
}
