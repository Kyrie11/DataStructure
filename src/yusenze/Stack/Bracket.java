package yusenze.Stack;

import yusenze.Interface.Stack;

public class Bracket {
    public static String isMatched(String infix){
        Stack<String> stack = new SeqStack<String>(infix.length());
        for(int i=0;i<infix.length();i++){
            char ch = infix.charAt(i);
            switch (ch){
                case '(':
                    stack.push(ch+"");break;
                case ')':
                    if(stack.isEmpty()||!stack.pop().equals("("))
                        return "缺少(";
            }
        }
        return (stack.isEmpty()?"":"缺少)");
    }

    public static void main(String...args){
        String infix = "(1+2)*3+4(";
        System.out.println(isMatched(infix));
    }
}
