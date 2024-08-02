package org.practices;

class helloword_to_HelloWorld {
    public static void main(String[] args) {
        String name="hello world";
        String[] input=name.split(" ");

        System.out.println("--without using toUpperCase()");
        for(int i=0;i<input.length;i++)
        {
            for(int l=0;l<(input[i]).length();l++)
            {
                char k=(char)input[i].charAt(l);
                if(l==0)
                {
                    k =(char)(k-32);
                }
                System.out.print(k);
            }
            System.out.print(" ");
        }


        System.out.println();
        System.out.println("--with toUpperCase()");

        for (String s : input) {
            String o = s.substring(0, 1).toUpperCase() + s.substring(1);
            System.out.print(o);
            System.out.print(" ");
        }

    }
}