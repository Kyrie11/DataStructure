package yusenze.Stack;

import yusenze.Interface.Stack;

public class Expression {
    public static StringBuffer toPostfix(String infix){
        Stack<String> stack = new SeqStack<>(infix.length());
        StringBuffer  postfix = new StringBuffer(infix.length()*2);
        int i = 0;
        while(i<infix.length()) {
            char ch = infix.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    while (!stack.isEmpty() && !stack.peak().equals("("))//栈非空且栈顶运算符优先级较高
                        postfix.append(stack.pop());
                    stack.push(ch + "");
                    i++;
                    break;
                case '*':
                case '/':
                    while (!stack.isEmpty() && (stack.peak().equals("*") || stack.peak().equals("/")))
                        postfix.append(stack.pop());
                    stack.push(ch + "");
                    i++;
                    break;
                case '(':
                    stack.push(ch + "");
                    i++;
                    break;
                case ')':
                    String out = stack.pop();
                    while (out != null && !out.equals("(")) {
                        postfix.append(out);
                        out = stack.pop();
                    }
                    i++;
                    break;
                default:
                    while (i < infix.length() && ch >= '0' && ch <= '9') {
                        postfix.append(ch);
                        i++;
                        if (i < infix.length())
                            ch = infix.charAt(i);
                    }
                    postfix.append(" ");
            }
        }
        while (!stack.isEmpty())
            postfix.append(stack.pop());
        return postfix;
    }
    public static int toValue(StringBuffer postfix){
        Stack<Integer> stack = new LinkedStack<Integer>();
        int value=0;
        for(int i=0;i<postfix.length();i++){
            char ch=postfix.charAt(i);
            if(ch>='0'&&ch<='9'){
                value =0;
                while(ch!=' '){
                    value = value*10+ch-'0';
                    ch = postfix.charAt(++i);
                }
                stack.push(value);
            }
            else if(ch!=' '){
                int y = stack.pop(),x = stack.pop();
                switch (ch){
                    case '+': value=x+y;break;
                    case '-': value=x-y;break;
                    case '*': value=x*y;break;
                    case '/': value=x/y;break;
                }
                System.out.println(x+(ch+"")+y+"="+value);
                stack.push(value);
            }
        }
        return stack.pop();
    }
}
