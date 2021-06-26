package com.mobile.application.testutils;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mobile.application.dto.Brand;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LoadUtils {

    public List<Brand> getMobiles() {
        String str = readFromFile();
        Gson g = new Gson();
       return g.fromJson(str, new TypeToken<List<Brand>>(){}.getType());

    }
    public static String readFromFile() {
        try {
            Path currentDir = Paths.get("src","test");
            String filePath = currentDir.toAbsolutePath() + "/java/resources/mobiles.json";
            return readFile(filePath);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static String readFile(String filePath) throws IOException {
        FileInputStream fin = new FileInputStream(filePath);
        StringBuilder resultStringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
            String line = null;
            while ((line = reader.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return resultStringBuilder.toString();
    }

}
