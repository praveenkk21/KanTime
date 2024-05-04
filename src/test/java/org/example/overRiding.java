package org.example;

import org.testng.annotations.Test;
//no static method can be ovverrided
 class home{
     public void furniture(){
         System.out.println("Homefurniture");
     }
    
}

class rented extends home{
    public void furniture(){
        System.out.println("RentedFuntiture");
    }
}

class clinician{
     public void work(){
         System.out.println("Clinician");
     }
}

class admin extends clinician{
    public void work(){
        System.out.println("admin");
    }
}

@Test
public class overRiding{
    @Test
    public void test()
    {
        home r=new rented();
        r.furniture();
    }

    @Test
    public void test2(){
        admin c=new admin();
        c.work();
    }
}