package yusenze.Tree;


import yusenze.List.SortedSinglyList;
import yusenze.Node.SearchBinaryNode;


/*
 *@Description:二叉搜索树
 */
public class SearchBinaryTree {
    public SearchBinaryNode root;


    public void delete(BinaryTree tree,int data){

    }

    public SearchBinaryTree(SortedSinglyList<Integer> list) {
    }

    public SearchBinaryTree(SearchBinaryNode node){
        this.root = new SearchBinaryNode(node.data);
    }

    public SearchBinaryTree(int value){
        this.root = new SearchBinaryNode(value);
    }

    public SearchBinaryTree(Integer[] values){
        this(values[0]);
        for(int i=1;i<values.length;i++){
            this.insert(new SearchBinaryNode(values[i]));
        }
    }

    public SearchBinaryTree(SearchBinaryTree tree){
        this.insert(tree.root);
    }

    /*
     *@Description:插入结点
     */
    public SearchBinaryNode insert(SearchBinaryNode node){
        SearchBinaryNode p = this.root;
        SearchBinaryNode parents = p;
        if(node!=null){
            while(p!=null){
                if(p.data>node.data) {
                    parents = p;
                    p = p.left;
                }
                else if(p.data<node.data){
                    parents = p;
                    p=p.right;
                }
            }

            if(parents.data>node.data){
                p = new SearchBinaryNode(node.data,null,null,parents);
                parents.left = p;
            }
            else if(parents.data<node.data){
                p = new SearchBinaryNode(node.data,null,null,parents);
                parents.right = p;
            }
            insert(node.left);
            insert(node.right);
        }

        return p;
    }
    /*
     * @Description:中序遍历二叉搜索树
     */
    public void inorder(SearchBinaryNode node){
        if(node!=null){
            inorder(node.left);
            System.out.print(node.data+" ");
            inorder(node.right);
        }
    }

    public void tree_Insert(SearchBinaryTree T,SearchBinaryNode z){
        SearchBinaryNode y =null;
        SearchBinaryNode x = T.root;
        while(x!=null){
            y=x;
            if(z.data<x.data)
                x = x.left;
            else x=x.right;
        }
        z.parent = y;
        if(y==null)
            T.root = z;
        else if(z.data<y.data)
            y.left = z;
        else y.right = z;
    }

    /*
     *@Description:先序遍历
     */
    public void preorder(){

    }

    public int Maximum(){
        SearchBinaryNode p = this.root;
        while(p.right!=null){
            p = p.right;
        }
        return p.data;
    }

    public int Minmium(){
        SearchBinaryNode p = this.root;
        while(p.left!=null){
            p = p.left;
        }
        return p.data;
    }

    public SearchBinaryNode search(SearchBinaryNode k,int x) {
        if(k.data==x||k==null)
            return k;
        if(x<k.data)
            return search(k.left,x);
        else return search(k.right,x);
    }
    public int i=0;
    public String toString(SearchBinaryNode node){
        String str="";
        if(node!=null){
            i++;
            str+=node.data+" ";
            str+=toString(node.left);
            str+=toString(node.right);
        }
        return str;
    }
    @Override
    public String toString(){
        String str="";
        str+=this.toString(this.root);
        return str;
    }
    public static void main(String...args){
        Integer values[] =new Integer[]{1,2,17,18,15,30,20,89,24};
        SearchBinaryTree tree = new SearchBinaryTree(values);
        System.out.println(tree.toString());

    }
}
