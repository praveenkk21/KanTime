package org.practices;

import org.testng.annotations.Test;

class const2 {
    private String patient_id=null;
    public const2() {
        patient_id=null;
        System.out.println((String) null);
    }
    public const2(String patient_id) {
        this.patient_id=patient_id;
        System.out.println(patient_id);
    }

    public const2(int client_id) {
        this.patient_id=String.valueOf(client_id);
        System.out.println(patient_id);
    }

}

@Test
public class constructor {

    public void test() {
        const2 obj = new const2();
        System.out.println(obj);

        const2 obj2 = new const2("12345");
        System.out.println(obj);

        const2 obj3 = new const2(12345);
        System.out.println(obj);
    }
}
