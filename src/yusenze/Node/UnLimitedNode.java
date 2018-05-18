package yusenze.Node;
/*
 *@Description:分支无限制的有根树结点
 */
public class UnLimitedNode<T> {
    public UnLimitedNode<T> leftChild;
    public UnLimitedNode<T> rightSibling;
    public UnLimitedNode<T> parent;
    public T data;

    public UnLimitedNode(){
        this.leftChild = null;
        this.rightSibling = null;
        this.data = null;
        this.parent = null;
    }

    public UnLimitedNode(UnLimitedNode<T> leftChild,UnLimitedNode<T> rightSibling,UnLimitedNode<T> parent,T data){
        this.leftChild = leftChild;
        this.rightSibling = rightSibling;
        this.parent = parent;
        this.data = data;
    }

    public UnLimitedNode(T data){
        this(null,null,null,data);
    }
}
