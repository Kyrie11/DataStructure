package yusenze.List;


import java.lang.reflect.Array;

public class SeqList<T> {
    protected T[] element;
    protected int n;

    private Class<T> type;

    public SeqList(Class<T> type){
        this.type = type;
    }

    public SeqList(int length)
    {

        @SuppressWarnings("unchecked")
        final T[] element = (T[]) Array.newInstance(type,length);
        this.element = element;
    }

    public SeqList(){
        this(64);
    }

    public SeqList(T[] values){
        this(values.length);
        for(int i=0;i<values.length;i++)
            this.element[i]=values[i];
        this.n = element.length;
    }
    /*
     * 拷贝构造方法:深拷贝
     */
    public SeqList(SeqList<? extends T> list){
        this.n = list.n;
        @SuppressWarnings("unchecked")
        final T[] element = (T[]) Array.newInstance(type ,list.element.length);
        this.element = element;
        for(int i=0;i<list.element.length;i++)
            this.element[i]=list.element[i];
    }

    public boolean isEmpty(){
        return this.n==0;
    }

    public int size(){
        return this.n;
    }

    public T get(int i){
        if(i>=0&&i<this.n)
            return this.element[i];
        return null;
    }

    public void set(int i,T x){
        if(x==null)
            throw new NullPointerException("x=null");
        if(i>=0&&i<this.n)
            this.element[i] = x;
        else throw new java.lang.IndexOutOfBoundsException(i+"");
    }

    public String toString(){
        String str = this.getClass().getName()+"(";
        if(this.n>0)
            str+=this.element[0].toString();
        for(int i=1;i<this.n;i++)
            str+=","+this.element[i].toString();
        return str+")";
    }

    public int insert(int i,T x){
        if(x==null)
            throw new NullPointerException("x=null");
        if(i<0) i=0;
        if(i>this.n)  i=this.n;
        T[] source =  this.element;
        if(this.n==element.length){
            @SuppressWarnings("unchecked")
            final T[] element = (T[]) Array.newInstance(type,this.element.length*2);
            this.element = element;
        }
        for(int j=0;j<n-1;j++)
            element[j]=source[j];
        for(int j=this.n-1;j>=i;j--)
            element[j+1]=source[j];
        element[i] = x;
        this.n++;
        return i;
    }

    public int insert(T x){
        return this.insert(this.n,x);
    }

    public T remove(int i){
        if(this.n>0&&i>=0&&i<this.n){
            T old = (T)this.element[i];
            for(int j=i;j<this.n-1;j++)
                this.element[j]=this.element[j+1];
            this.element[this.n-1] = null;
            this.n--;
            return old;
        }
        return null;
    }

    public int search(T key){
        for(int i=0;i<this.n;i++)
            if(this.element[i].equals(key))
                return i;
        return -1;
    }

    public boolean contains(T key){
        return this.search(key)==-1;
    }

    public boolean equals(Object obj){
       if(obj==this)
           return true;
       if(obj instanceof SeqList<?>){
           SeqList<T> list =(SeqList<T>)obj;
           if(this.n==list.n){
               for(int i=0;i<list.n;i++)
                   if(!(this.get(i).equals(list.get(i))))
                       return false;
           }
       }
       return false;
    }
}
