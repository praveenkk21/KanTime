package org.practices;

public class superSub {
    public static void main(String[] args){
        a k=new b();
        k.print();
    }
}

class a{
    static void print(){
        System.out.println("aa");
    }
}
class b extends a{
    static void print(){
        System.out.println("ab");
    }
}
// aa will be the output, static method cannot be overrided