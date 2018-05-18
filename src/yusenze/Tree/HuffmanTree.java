/*
package yusenze.Tree;

import yusenze.Node.TriElement;

public class HuffmanTree {
    private String charset;
    private TriElement[] huftree;
    public HuffmanTree(int[] weights){
        this.charset="";
        for(int i=0;i<weights.length;i++)
            this.charset+=(char)('A'+i);
        int n= weights.length;
        this.huftree=new TriElement[2*n-1];
        for(int i=0;i<n;i++)
            this.huftree[i]=new TriElement(weights[i]);
        for(int i=0;i<2*n-1;i++){
            int min1=Integer.MAX_VALUE,min2=min1;
            int x1=-1,x2=-1;
            for(int j=0;j<i;j++)
                if(this.huftree[j].parent==-1)
        }
    }
}
*/
package yusenze.Tree;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Random;

public class HuffmanTree{
    public static void main(String...args){
        int number ;
        for(int i=0;i<20;i++)
        {
            number=new Random().nextInt(8);
            System.out.println(number);
        }
    }

}
