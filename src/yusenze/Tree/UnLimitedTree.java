package yusenze.Tree;
/*
 *@Description:分支无限制的有根树
 */
import yusenze.Node.UnLimitedNode;

public class UnLimitedTree<T> {
    UnLimitedNode<T> head;

    public UnLimitedTree(){
        this.head = new UnLimitedNode<>();
    }



    public void insert(UnLimitedNode<T> root){
        this.head = new UnLimitedNode<>(root.data);

    }
}
