package yusenze.Queue;
/*
 *实现:入队，出队，返回队头，判断空
 * 顺序循环队列
 */
import yusenze.Interface.Queue;

public class SeqQueue<T> implements Queue<T> {
    private Object element[];

    private int front,rear;//队列头尾

    public SeqQueue(int length)
    {
        if(length<64)
            length=64;
        this.element= new Object[length];
        this.front = this.rear =0;
    }

    public SeqQueue()
    {
        this(64);
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    @Override
    public T peek() {//返回队头元素
        return this.isEmpty()?null:(T)this.element[this.front];
    }

    @Override
    public T poll() {//出队
        if(this.isEmpty())
            return null;
        T temp = (T)this.element[this.front];
        this.front = (this.front+1)%this.element.length;
        return temp;
    }

    @Override
    public boolean add(T x) {
        if(x==null)
            return false;
        if(this.front==(this.rear+1)%this.element.length)
        {
            Object[] temp=this.element;
            this.element = new Object[element.length*2];
            int j=0;
            for(int i=this.front;i!=this.rear;i=(i+1)%temp.length)
                this.element[j++]=temp[i];
            this.front=0;
            this.rear=j;
        }
        this.element[this.rear]=x;
        this.rear = (this.rear+1)%this.element.length;
        return true;
    }
}
