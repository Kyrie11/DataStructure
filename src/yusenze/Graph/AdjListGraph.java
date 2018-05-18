package yusenze.Graph;

import yusenze.GeneralList.LinkedMatrix;
import yusenze.List.SeqList;

/*
 * @DescriptionL:邻接表表示的带权有向图
 */
public class AdjListGraph<T> extends AbstractGraph<T>{
    protected LinkedMatrix adjlist;//图的邻接表，结构同矩阵行的单链表

    /*
     *@Description:构造空图
     */
    public AdjListGraph() {
        super();
    }

    public AdjListGraph(int length){
        super(length);
        this.adjlist = new LinkedMatrix(length,length);
    }

    public AdjListGraph(T[] vertices){
        super(vertices.length);
        this.adjlist = new LinkedMatrix(vertices.length,vertices.length);
    }

    public AdjListGraph(T[] vertices,Triple[] edges){

    }

    @Override
    public String toString(){
        return super.toString()+"出边表:\n"+this.adjlist.toString();
    }
    @Override
    public int insert(Object x) {
        return 0;
    }

    @Override
    public void removeVertex(int i) {

    }

    @Override
    public int weight(int i, int j) {
        return 0;
    }

    @Override
    public int next(int i, int j) {
        return 0;
    }

    public void BFSearch(AdjListGraph G,int s){

    }

    /*
     * @Description:插入边
     */
    public void insertEdge(int i,int j,int weight){
        if(i!=j)//不能插入自身环
        {
            if(weight<0||weight>=MAX_WEIGHT)//边的权值容错
                weight = 0;
            //设置第i条边单链表中<vi,vj>边的权值为weight,若0<weight<∞,插入边或替换边的权
            //若weight==0，删除该边，若i,j越界，抛出序号越界异常
            this.adjlist.set(i,j,weight);
        }
        else throw new IllegalArgumentException("不能插入自身环");
    }

    public void insertEdge(Triple triple){}

    public int insertVertex(T x){
        int i = this.vertexlist.insert(x);
        if(i>=this.adjlist.getRows());
            this.adjlist.setRowsColumns(i+1,i+1);
        return i;
    }


}
