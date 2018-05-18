package yusenze.Interface;

public interface Addible<T> {
    public void add(T t);//约定两元素相加规则
    public boolean removable();//约定删除元素条件
}
