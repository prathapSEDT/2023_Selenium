package com.jsonreader;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonUtils {
    public static void main(String[] args) throws IOException, ParseException {
        //step 1
        File f=new File("src/test/resources/Testdata/Testdata.json");
        FileReader fileReader=new FileReader(f);

        //step 2
        JSONParser jsonParser=new JSONParser();
        JSONObject jsonObject=(JSONObject)jsonParser.parse(fileReader);

        JSONArray array=(JSONArray)jsonObject.get("companies");
        System.out.println(array.size());
        for (int i=0;i<=array.size()-1;i++){
            jsonObject= (JSONObject)jsonParser.parse(array.get(i).toString());
            System.out.println(jsonObject.get("name"));
        }


    }
}
