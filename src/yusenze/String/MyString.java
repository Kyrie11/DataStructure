package yusenze.String;

public final class MyString implements Comparable<MyString>,java.io.Serializable{
    private char[] value;

    public MyString(){
        this.value = new char[]{};
    }

    public MyString(String str){
        this.value = new char[str.length()];
        for(int i=0;i<str.length();i++)
            value[i]=str.charAt(i);
    }

    public MyString(char[] value,int i,int n){
        if(i>=0&&n>=0&&i+n<=value.length){
            this.value = new char[n-i+1];
            for(int j=0;j<n;j++)
                this.value[j]=value[j+i];
        }
        else throw new NullPointerException("越界");
    }

    public MyString(String str,int i,int n){
        if(i>=0&&n>=0&&i+n<=str.length()){
            this.value = new char[n-i+1];
            for(int j=0;j<n;j++)
                this.value[j] = str.charAt(j);
        }
        else throw new NullPointerException("越界");
    }
    public MyString(char[] value){
        this(value,0,value.length);
    }

    public MyString(MyString str){
        this(str.value);
    }

    public int length(){
        return this.value.length;
    }

    public MyString subString(int begin,int end){
        if(begin==0&&end==this.value.length)
            return this;
        return new MyString(this.value,begin,end);
    }

    public int compareTo(MyString str){
        MyString mystring = new MyString(str);
        if(mystring.value.length<this.value.length)
            return 1;
        else if(mystring.value.length>this.value.length)
            return -1;
        else{
            for(int i=0;i<this.value.length;i++)
                if((this.value[i]-'a')>(mystring.value[i]-'a'))
                    return 1;
                else if((this.value[i]-'a')>(mystring.value[i]-'a'))
                    return 0;
                else return -1;
        }
        return -1;
    }

    @Override
    public String toString(){
        String str = "";
        for(int i=0;i<this.value.length;i++)
            str+=this.value[i];
        return str;
    }
    public static void main(String...args){
        String str = "This is a test programing for MyString";
        MyString mystring = new MyString(str);
        System.out.println(mystring.toString());
        MyString mystring2 = new MyString(str,1,15);
        System.out.println(mystring2.toString());

        String str2 = "This is a simple test";
        MyString mystring3 = new MyString(str2);
        String result = "mystring1大于mystring3吗？：";
        result+=(mystring.compareTo(mystring3)>0)?"是的":"不是";
        System.out.println(result);
    }
}
