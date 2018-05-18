package yusenze.Queue;

import yusenze.Interface.Queue;
import yusenze.List.SeqList;
import yusenze.List.SortedSeqList;

public class PrimeRing {
    public PrimeRing(int max){
        SortedSeqList<Integer> primeset = createPrime(max);
        System.out.println("素数集合:"+primeset.toString());
        SeqList<Integer> ring = new SeqList<>(max);
        ring.insert(1);
        Queue<Integer> que = new SeqQueue<>(max);//创建空队列
        for(int i=2;i<max;i++)//2~max全部入队
            que.add(i);
        System.out.println(que.toString());
        int i=0;
        while(!que.isEmpty()){
            int key = que.poll();//出队
            if(primeset.contains(ring.get(i)+key)) {//判断素数
                i++;
                ring.insert(key);
            }
            else
                que.add(key);
        }
        System.out.println("素数环:"+ring.toString());
    }

    /*
     * 返回2~max的所有素数
     */
    public SortedSeqList<Integer> createPrime(int max){
        if(max<=0)
            return null;
        SortedSeqList<Integer> primeset = new SortedSeqList<>(max*2);
        primeset.insert(2);
        for(int key=3;key <=max*2;key+=2){
            int i=0;
            while(i<primeset.size()&&key%primeset.get(i)!=0)
                i++;
            if(i==primeset.size())
                primeset.insert(key);
        }
        return primeset;
    }

    public static void main(String...args){
        new PrimeRing(20);
    }
}
