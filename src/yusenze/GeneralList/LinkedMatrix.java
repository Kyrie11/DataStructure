package yusenze.GeneralList;

import sun.awt.image.ImageWatched;
import yusenze.Graph.Triple;
import yusenze.List.PolySinglyList;
import yusenze.List.SeqList;
import yusenze.List.SortedSinglyList;
import yusenze.Node.Node;

public class LinkedMatrix<T> {
    private int rows,columns;
    SeqList<PolySinglyList<Triple>> rowlist;

    public LinkedMatrix(int rows,int columns){
        if(rows>=0&&columns>=0){
            this.rows = rows;
            this.columns = columns;
            this.rowlist = new SeqList<PolySinglyList<Triple>>();//构造顺序表，初值为null
            for(int i=0;i<rows;i++)//顺序表尾增加m个空单链表
                this.rowlist.insert(new PolySinglyList<Triple>());//顺序表尾插入，自动扩容
        }
        else throw new IllegalArgumentException("行列数不能为负");
    }

    public LinkedMatrix(int rows){
        this(rows,rows);
    }

    public LinkedMatrix(int rows,int columns,Triple[] triples){
        this(rows,columns);
        for(int i=0;i<triples.length;i++)
            this.set(triples[i]);
    }

    public int getRows(){
        return this.rows;
    }

    public void setRowsColumns(int row,int column){
        if(row>0&&column>0){
            if(row>this.rows)
                for(int i=this.rows;i<row;i++)
                    this.rowlist.insert(new PolySinglyList<Triple>());
            this.rows = row;
            this.columns = column;
        }
        else throw new IllegalArgumentException("矩阵行列数不能为负");
    }

    public void set(int i,int j,int x){
        this.set(new Triple(i,j,x));
    }

    public void set(Triple triple){
        int i = triple.row;
        int j = triple.column;
        if(i>=0&&i<this.rows&&j>=0&&j<this.columns){
            SortedSinglyList<Triple> link = this.rowlist.get(i);//获得第i行排序单链表
            if(triple.value == 0)
                link.remove(triple);
            else{
                Node<Triple> find = link.search(triple);
                if(find!=null)
                    find.data.value = triple.value;//查找成功，修改矩阵元素值
                else
                    link.insert(triple);//查找不成功，按(i,j)次序插入triple
            }
        }
        else
            throw new IndexOutOfBoundsException("越界");
    }

    /*
     * @Description:返回矩阵第i行，第j列元素
     */
    public int get(int i,int j){
        if(i>=0&&i<this.rows&&j>=0&&j<this.columns){
            Node<Triple> find = this.rowlist.get(i).search(new Triple(i,j,0));
            return (find!=null)?find.data.value:0;
        }
        throw new IndexOutOfBoundsException("越界");
    }

    public String toString(){
        String str="";
        for(int i = 0;i<this.rowlist.size();i++)
            str+= i+"->"+this.rowlist.get(i).toString()+"\n";
        return str;
    }

    /*
     * @Description:输出矩阵
     */
    public void printMatrix(){
        System.out.println("矩阵:"+this.getClass().getName()+"("+rows+"x"+columns+")");
        for(int i=0;i<this.rowlist.size();i++){
            Node<Triple> p = this.rowlist.get(i).head.next;
            for(int j=0;j<this.columns;j++)
                if(p!=null&&j==p.data.column){
                    System.out.print(String.format("%4d",p.data.value));
                    p = p.next;
                }
                else
                    System.out.print(String.format("%4d",0));
            System.out.println();
        }
    }

    public void addAll(LinkedMatrix mat){
        if(this.rows == mat.rows&&this.columns == mat.columns)
            for(int i=0;i<this.rows;i++)
                (LinkedMatrix)(this.rowlist.get(i)).addAll((LinkedMatrix)(mat.rowlist.get(i)));
        else throw new IllegalArgumentException("");
    }
}
