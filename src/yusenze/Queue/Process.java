package yusenze.Queue;

public class Process implements Comparable<Process> {
    private String name;//进程名
    private int priority;//进程优先级

    public Process(String name,int priority){
        this.name=name;
        if(priority>=1&&priority<=10)
            this.priority=priority;
        else
            throw new IllegalArgumentException("无效的进程优先级");
    }

    public Process(String name){
        this.name=name;
        this.priority=5;//默认优先级
    }

    public String toString(){
        return "("+this.name+" "+this.priority+")";
    }

    @Override
    public int compareTo(Process p){//进程优先级比较大小
        return this.priority-p.priority;
    }

    public static void main(String...args){
        Process process[] = {new Process("进程1",6),new Process("进程2"),
                new Process("进程3",7),new Process("进程4",1)};
        PriorityQueue<Process> que = new PriorityQueue<>(false);
        System.out.println("进程入队:");
        for(int i=0;i<process.length;i++){
            que.add(process[i]);
            System.out.println(process[i].toString());
        }
        System.out.println("进程出队：");
        while(!que.isEmpty())
            System.out.println(que.poll().toString());
    }
    
}
