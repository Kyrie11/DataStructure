package yusenze.GeneralList;

public class Matrix {

    private int columns,rows;
    private int[][] element;

    public Matrix(int rows,int columns){
        this.element = new int[rows][columns];
        this.columns = columns;
        this.rows = rows;
    }

    public Matrix(int n){
        this(n,n);
    }

    public Matrix(int rows,int columns,int[][] values){
        this(rows,columns);
        for(int i=0;i<rows;i++)
            for(int j=0;j<columns;j++)
                this.element[i][j] = values[i][j];
    }

    public void setRowsColumns(int row,int column){
        int[][] copy = this.element;
        this.element = new int[row][column];
        for(int i=0;i<rows;i++)
            for(int j=0;j<columns;j++)
                this.element[i][j] = copy[i][j];
        this.rows = row;
        this.columns = column;
    }

    public int getRows(){
        return this.rows;
    }

    public int getColumns(){
        return this.columns;
    }

    public int get(int row,int column){
        return this.element[row][column];
    }

    public void set(int row,int column,int x){
//        int[][] newMatrix = this.element;
//        if(row>this.rows||column>this.columns) {
//            this.element = new int[row][column];
//            for(int i=0;i<row;i++)
//                for(int j=0;j<column;j++)
//                    this.element[i][j] = newMatrix[i][j];
//        }
        if(row>0&&row<this.rows&&column>0&&column<this.columns)
            this.element[row][column] = x;
    }
}
