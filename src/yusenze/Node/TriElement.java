package yusenze.Node;

public class TriElement {
    public int data;
    public int parent,left,right;
    public TriElement(int data,int parent,int left,int right){
        this.data=data;
        this.parent=parent;
        this.left=left;
        this.right=right;
    }
    public TriElement(int data){
        this(data,-1,-1,-1);
    }
}
