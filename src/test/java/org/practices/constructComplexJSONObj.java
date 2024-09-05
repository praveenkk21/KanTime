package org.practices;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;

public class constructComplexJSONObj {

    public static void main(String[] args){
        JSONObject tempAddress=new JSONObject();
        tempAddress.put("address1","BTM 2nd Stage");
        tempAddress.put("address2","30th Main Road");

        JSONObject Address=new JSONObject();
        Address.put("peremanent_address","Mangalore");
        Address.put("temp_address",tempAddress);

        System.out.println(Address.toString());
        JSONObject test=Address.getJSONObject("temp_address");
        System.out.print(test.getString("address1"));

    }
}
