package yusenze.Interface;
/*
 * 队列接口
 */
public interface Queue<T> {
    public abstract boolean isEmpty();//判断队列是否为空
    public abstract boolean add(T x);//元素x入队
    public abstract T peek();//返回队头元素
    public abstract T poll();//出队，返回队头元素。若队列空，则返回null
}
