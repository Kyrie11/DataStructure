package yusenze.Graph;

import yusenze.List.SeqList;

public abstract class AbstractGraph<T> {
    protected static final int MAX_WEIGHT =  0x0000ffff;//表示最大权值
    protected SeqList<T> vertexlist;//顶点顺序表

    public AbstractGraph(int length){
        this.vertexlist = new SeqList<>(length);
    }
    public AbstractGraph(){}
    public int vertexCount(){
        return this.vertexlist.size();
    }

    public String toString(){
        return "顶点顺序表:"+this.vertexlist.toString();
    }

    public T getVertex(int i){
        return this.vertexlist.get(i);
    }

    public void setVertex(int i,T x){
        this.vertexlist.set(i,x);
    }

    public abstract int insert(T x);//插入元素为x的顶点并返回顶点序号
    public abstract void removeVertex(int i);//删除第i个顶点以及相关的所有边
    public abstract int weight(int i,int j);//返回<vi,vj>边的权值
    public abstract int next(int i,int j);//返回vi在vj后的后继邻接顶点序号
}
