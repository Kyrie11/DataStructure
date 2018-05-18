package yusenze.Graph;

import yusenze.Interface.Addible;
/*
 * @Description:稀疏矩阵非零元素三元组类
 */
public class Triple implements Comparable<Triple>,Addible<Triple> {
    public int row,column,value;//行号，列号，元素值

    public Triple(int row,int column,int value){
        if(row>=0&&column>=0){
            this.row = row;
            this.column = column;
            this.value = value;
        }
        else throw new IllegalArgumentException("行列号不能为负数");
    }

    public Triple(Triple trip){
        this(trip.row,trip.column,trip.value);
    }

    @Override
    public String toString(){
        return "row="+row+","+"column="+column+","+"value="+value;
    }

    @Override
    public int compareTo(Triple triple) {
        if(this.row==triple.row&&this.column==triple.column)
            return 0;
        return(this.row<triple.row||this.row==triple.row&&this.column<triple.column)?-1:1;
    }

    @Override
    public void add(Triple triple) {
        if(this.compareTo(triple)==0)
            this.value += triple.value;
        else
            throw new IllegalArgumentException("矩阵大小不同，不能相加");
    }

    public boolean equals(Object obj){
        Triple triple = (Triple) obj;
        if(this.row == triple.row&&this.column == triple.column&&this.value == triple.value)
            return true;
        else  return false;
    }

    @Override
    public boolean removable() {
        return this.value == 0;
    }
    /*
     * @Description:返回矩阵对称位置元素的三元组
     */
    public Triple toSymmetry(){
        return new Triple(this.column,this.row,this.value);
    }

}
