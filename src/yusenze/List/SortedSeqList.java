package yusenze.List;

import java.lang.ref.SoftReference;
import java.util.Arrays;

public class SortedSeqList<T extends Comparable<? super T>> extends SeqList<T> {

    public SortedSeqList(){
        super();
    }

    public SortedSeqList(int length){
        super(length);
    }
    public SortedSeqList(T[] values){
        Arrays.sort(values);
        this.n = values.length;
        int i=values.length;
        for(int j=0;j<i;j++){
            this.element[j]=values[j];
        }
    }

    /*
     * 顺序表构造排序顺序表
     */
    public SortedSeqList(SeqList<? extends T> list){
        super();
        for(int i=0;i<list.n;i++)
            this.insert(list.get(i));
    }
    public int insert(T x){
        int i=0;
        if(this.isEmpty()||x.compareTo(this.get(this.size()-1))>0)
            i=this.n;
        else
            while(i<this.n&&x.compareTo(this.get(i))<0)
                i++;
        super.insert(i,x);
        return i;
    }

    /*
     *@Description:插入不重复的元素
     */
    public int insertDifferent(T x){
        for(int i=0;i<this.element.length;i++)
            if(x.equals(this.element[i]))
                return -1;
        int j =this.insert(x);
        return j;
    }
    /*
     * 不支持父类的set方法
     */
    public void set(int i,T x){
        throw new java.lang.UnsupportedOperationException("不支持的方法");
    }
    /*
     * 不支持的父类insert方法
     */
    public int insert(int i,T x){
        throw new UnsupportedOperationException("不支持的方法");
    }

    @Override
    public String toString(){
        String str = this.getClass().getName()+"(";
        if(this.n>0)
            str+=element[0].toString()+" ";
        for(int i=1;i<n;i++)
            str+=element[i].toString()+" ";
        return str+")";
    }

    /*
     *查找
     */
    public int search(T key){
        for(int i=0;i<this.n&&key.compareTo(this.get(i))>=0;i++)
            if(key.compareTo(this.get(i))==0)
                return i;
        return -1;
    }

    public T remove(T key){
        return this.remove(this.search(key));
    }

    public int compareTo(){
        return 1;
    }
    public static void main(String...args){
        Integer[] values={72,124,53,69,55};
        SeqList<Integer> list2 = new SeqList<>(values);
        SortedSeqList<Integer> list1 = new SortedSeqList<>(values);
        list1.insert(1);
        System.out.println(list1.toString());
        System.out.println(list2.toString());
    }
}
