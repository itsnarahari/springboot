package com.example.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test
{
    public static void main(String[] args) {

        JSONObject jo = new JSONObject();
        jo.put("id", 2121);
        jo.put("email", "Doe@gmail.com");

        JSONObject jo2 = new JSONObject();
        jo2.put("id", 977);
        jo2.put("email", "Dgsfgoe@gmail.com");

        List email = new ArrayList();
        List id = new ArrayList();



        JSONArray ja = new JSONArray();
        ja.put(jo);
        ja.put(jo2);

        Iterator iterator = ja.iterator();

        JSONObject js;
        while(iterator.hasNext())
        {
           js = (JSONObject) iterator.next();
            email.add(js.get("email"));
            id.add(js.get("id"));
        }

        System.out.println(email);
        System.out.println(id.size());


    }
}
