package yusenze.Graph;


import yusenze.GeneralList.Matrix;

public class MatrixGraph<T> extends AbstractGraph<T> {
    protected Matrix matrix;//矩阵对象，存储图的邻接矩阵

    public MatrixGraph(int length){
        super(length);//构造顶点集
        this.matrix = new Matrix(length);
    }

    public MatrixGraph(){
        this(10);
    }

    public MatrixGraph(T[] vertices){
        this(vertices.length);
        for(int i=0;i<vertices.length;i++)
            this.insertVertex(vertices[i]);
    }

    /*
     * @Description:以顶点集合和边集合构造图
     */
    public MatrixGraph(T[] vertices,Triple[] edges){
        this(vertices);
        for(int i=0;i<edges.length;i++)
            this.insertEdge(edges[i]);
    }
    /*
     * @Description:插入顶点
     */
    public int insertVertex(T vertice){
        int i = this.vertexlist.insert(vertice);
        if(i>=this.matrix.getRows())
            this.matrix.setRowsColumns(i+1,i+1);
        for(int j=0;j<i;j++){
            this.matrix.set(i,j,MAX_WEIGHT);
            this.matrix.set(j,i,MAX_WEIGHT);
        }
        return i;
    }
    /*
     *@Description：插入边
     */
    public void insertEdge(int i,int j,int weight){
        if(i!=j){
            if(weight<=0||weight>MAX_WEIGHT)
                weight = MAX_WEIGHT;
            this.matrix.set(i,j,weight);
        }
        else throw new IllegalArgumentException("不能形成重复路");
    }


    public void insertEdge(Triple edge){
        this.insertEdge(edge.row,edge.column,edge.value);
    }

    public int insert(T x) {
        return this.insertVertex(x);
    }

    public void removeEdge(int i,int j){
        if(i!=j)
            this.matrix.set(i,j,MAX_WEIGHT);
    }

    public void removeEdge(Triple triple){
    }

    public void removeVertex(int i){
        int n = this.vertextCount();
        if(i>0&&i<n){
            this.vertexlist.remove(i);
            for(int j=i+1;j<n;j++)
                for(int k=0;k<n;k++)
                    this.matrix.set(j-1 ,k,this.matrix.get(j,k));
            for(int j=0;j<n;j++)
                for(int k=i+1;k<n;k++)
                    this.matrix.set(j,k-1,this.matrix.get(j,k));
            this.matrix.setRowsColumns(n-1,n-1);
        }
        else throw new IllegalArgumentException("越界");
    }

    public int vertextCount(){
        return this.vertexlist.size();
    }

    public int weight(int i,int j){
        return this.matrix.get(i,j);
    }

    public int next(int i,int j){
        int n = this.vertexCount();
        if(i>=0&&i<n&&j>=-1&&j<n&&i!=j)
            for(int k=j+1;k<n;k++)
                if(this.matrix.get(i,k)>0&&this.matrix.get(i,k)<MAX_WEIGHT)
                    return k;
        return -1;
    }

    @Override
    public String  toString(){
        String str = super.toString()+"邻接矩阵: \n";
        int n= this.vertexCount();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                if(this.matrix.get(i,j)==MAX_WEIGHT)
                    str+="     ∞";
            else str+=String.format("%6d",this.matrix.get(i,j));
            str+="\n";
        }
        return str;
    }

    public static void main(String...args){
        String[] vertices = {"A","B","C","D","E"};
        Triple edges[] = {new Triple(0,1,45),new Triple(0,2,28),new Triple(0,3,10),new Triple(1,0,45),new Triple(1,2,12)};
        MatrixGraph<String> graph = new MatrixGraph<>(vertices,edges);
        System.out.println(graph.toString());
        graph.insertEdge(3,4,22);
        System.out.println(graph.toString());
        String F = "F";


    }
}