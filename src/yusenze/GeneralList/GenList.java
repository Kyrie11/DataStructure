package yusenze.GeneralList;

import yusenze.Node.GenNode;

public class GenList<T> {
    public GenNode<T> head;

    public GenList(){
        this.head = new GenNode<>();
    }

    public GenList(T[] atmos){
        this();
        GenNode<T> p = this.head;
        for(int i=0;i<atmos.length;i++){
            p.next = new GenNode<T>(atmos[i],null,null);
            p = p.next;
        }
    }
    public String toString(){
        return this.toString("");
    }

    public String toString(String str){
        str+="(";
        for(GenNode<T> p = this.head.next;p!=null;p=p.next){
            if(p.child==null)
                str+=p.data.toString();
            else str+="("+p.data.toString()+","+p.child.toString()+")";
            if(p.next!=null) str+=",";
        }
        return str+")";
    }


    /*
     *@Description:判断广义表是否为空
     */
    public boolean isEmpty(){
        return this.head.next==null;
    }

    /*
     * @Description:插入子表到原表尾
     */
    public GenNode<T> insert(GenList<T> glist){
        GenNode<T> p = this.head;
        GenNode<T> pointer = glist.head.next;
        while(p.next!=null)
            p=p.next;
        while(pointer!=null){
            p.next = new GenNode<T>(pointer.data,null,null);
            p = p.next;
            pointer = pointer.next;
        }
        return pointer;
    }

    /*
     * @Description:插入广义表到原表第i个结点作为该结点的孩子
     */
    public void insertChild(int i,GenList<T> glist){
        GenNode<T> p = this.head.next;
        if(i<0)
            i=0;
        for(int j=0;j<i;j++)
            p = p.next;
        GenNode<T> node = glist.head.next;
        p.child = new GenList<T>();
        GenNode<T> pointer = p.child.head;
        while(node!=null){
            pointer.next = new GenNode<T>(node.data,null,null);
            node = node.next;
            pointer =pointer.next;
        }
    }

    public static void main(String...args){
        String[] atmos = new String[]{ "a","b","c"};
        String[] atmos2 = new String[]{"A","B","C"};
        GenList<String> genlist = new GenList<>(atmos);
        System.out.println("原广义表genlist为:"+genlist.toString());
        GenList<String> genlist2 = new GenList<>(atmos2);
        System.out.println("原广义表genlist2为:"+genlist2.toString());
        genlist.insert(genlist2);
        System.out.println("原表genlist插入genlist2后变为:"+genlist.toString());
        System.out.println(genlist2.toString());
        genlist.insertChild(2,genlist2);
        System.out.println("原广义表genlist插入genlist2作为第3个结点的子表后："+genlist.toString());
    }
}
