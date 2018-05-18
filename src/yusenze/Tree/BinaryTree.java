package yusenze.Tree;

import yusenze.Interface.Stack;
import yusenze.Node.BinaryNode;
import yusenze.Queue.LinkedQueue;
import yusenze.Stack.SeqStack;

public class BinaryTree<T> {
    public BinaryNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public BinaryNode<T> insert(T data) {
        return this.root = new BinaryNode<>(data, this.root, null);
    }

    public BinaryNode<T> insert(BinaryNode<T> parent, T data, boolean leftChild) {
        if (data == null)
            return null;
        if (leftChild)
            return parent.left = new BinaryNode<T>(data, parent.left, null);
        return parent.right = new BinaryNode<T>(data, null, parent.right);
    }

    public void remove(BinaryNode<T> parent, boolean leftChild) {
        if (leftChild)
            parent.left = null;
        else
            parent.right = null;
    }

    public void clear() {
        this.root = null;
    }

    public void preorder() {//先根遍历
        preorder(this.root);
        System.out.println();
    }

    public void preorder(BinaryNode<T> p) {
        if (p != null) {
            System.out.print(p.data.toString() + "");
            preorder(p.left);
            preorder(p.right);
        }
    }
    public String toString(){
        return toString(this.root);
    }
    public String toString(BinaryNode<T> p) {
        if (p == null){
            return "∧";
        }
        return p.data.toString() + "" + toString(p.left) + toString(p.right);
    }
    public void inOrder(){//中根次序遍历
        inOrder(this.root);
        System.out.println();
    }
    private static int count=0;
    public void inOrder(BinaryNode<T> p){
        if(p!=null){
            count++;
            inOrder(p.left);
            System.out.print(p.data.toString()+""+count);
            inOrder(p.right);
        }
    }
    public void postOrder(){//后根遍历
        postOrder(this.root);
    }
    public void postOrder(BinaryNode<T> p){
        if(p!=null){
            postOrder(p.left);
            postOrder(p.right);
            System.out.print(p.data.toString()+"");
        }
    }
    /*
     *********************************************
     ****************非递归实现遍历***************
     */
    public void PreOrder(BinaryNode<T> p){
        Stack<BinaryNode<T>> stack = new SeqStack<BinaryNode<T>>();
        if(p!=null)
            stack.push(p);//根入栈
        while(!stack.isEmpty()){
            BinaryNode<T> node = stack.pop();
            System.out.print(node.data);
            //右结点先入栈，左结点后入栈
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
    }
    public void InOrder(BinaryNode<T> p) {
        Stack<BinaryNode<T>> stack = new SeqStack<BinaryNode<T>>();
    }
    public int size(BinaryNode<T> root){//返回二叉树的结点数
        if(root==null)
            return 0;
        else
            return size(root.left)+1+size(root.right);

    }
    public int height(BinaryNode<T> root){//返回二叉树的高度
        if(root==null)
            return 0;
        else{
            int lh = height(root.left);
            int rh = height(root.right);
            return lh>rh?lh+1:rh+1;
        }
    }
    public BinaryTree(T[] prelist){
            this.root = create(prelist);
    }
    private int m=0;
    private BinaryNode<T> create(T[] prelist){
        BinaryNode<T> p = null;
        if(m<prelist.length)
        {
            T elem = prelist[m];
            m++;
            if(elem!=null)
            {
                p=new BinaryNode<>(elem);
                p.left=create(prelist);
                p.right=create(prelist);
            }
        }
        return p;
    }
    public void levelorder(){
        LinkedQueue<BinaryNode<T>> queue = new LinkedQueue<>();
        BinaryNode<T> p = this.root;
        while(p!=null){
            System.out.print(p.data+"");
            if(p.left!=null)
                queue.add(p.left);
            if(p.right!=null)
                queue.add(p.right);
            p=queue.poll();
        }
    }
    public static BinaryTree<String> get(int max){
        BinaryTree<String> tree = new BinaryTree<>();
        BinaryNode<String> D=new BinaryNode<>("D",null,null);
        BinaryNode<String> E=new BinaryNode<>("E");
        BinaryNode<String> F=new BinaryNode<>("F");
        BinaryNode<String> G=new BinaryNode<>("G");
        BinaryNode<String> B=new BinaryNode<>("B",D,E);
        BinaryNode<String> C=new BinaryNode<>("C",F,G);
        tree.root = new BinaryNode<String>("A",B,C);
        return tree;
    }


    public void printGenList(){

    }

    public void printGenList(BinaryNode<T> p){

    }

    /*
     *@Description:以先根和中根次序遍历序列构造二叉树
     */
    public BinaryTree(T[] prelist,T[] inlist){

    }

    /*public BinaryNode<T> create(T[] prelist,T[] inlist,int postEnd,int start,int n){
        BinaryNode<T> p = null;
        if(n>0){
            T elem = prelist[postEnd];
            p = new BinaryNode<>(elem);

        }
    }*/

    public static void main(String...args){
        String[] prelist={"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
        BinaryTree<String> bitree = new BinaryTree<>(prelist);
        System.out.println(bitree.toString());
        bitree.preorder();
        bitree.postOrder();
        System.out.println();
        BinaryTree<String> tree=get(1);
        tree.preorder();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.postOrder();
        System.out.println();

    }
}