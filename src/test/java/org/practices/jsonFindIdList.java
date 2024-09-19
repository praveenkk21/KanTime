package org.practices;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class jsonFindIdList {

    public static void main(String[] args){
        String response = "{\n" +
                "  \"company\": {\n" +
                "    \"employee\": [\n" +
                "      {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Sanotsh\",\n" +
                "        \"role\": \"Admin\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Saket\",\n" +
                "        \"role\": \"User\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 3,\n" +
                "        \"name\": \"shyam\",\n" +
                "        \"role\": \"User\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";

        JSONObject j=new JSONObject(response.toString());
            JSONObject j1=j.getJSONObject("company");
            JSONArray j2=j1.getJSONArray("employee");
            ArrayList<Integer> a=new ArrayList<>();

            for(int i=0;i<j2.length();i++)
            {
                a.add( j2.getJSONObject(i).getInt("id"));
            }
        System.out.println(a);

    }

}
