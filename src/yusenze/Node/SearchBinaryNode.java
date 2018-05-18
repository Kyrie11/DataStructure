package yusenze.Node;

public class SearchBinaryNode {
    public SearchBinaryNode left;
    public SearchBinaryNode right;
    public SearchBinaryNode parent;
    public int data;
    public SearchBinaryNode(int data,SearchBinaryNode left,SearchBinaryNode right,SearchBinaryNode parent){
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
    public SearchBinaryNode(int data){
        this(data,null,null,null);
    }
}
