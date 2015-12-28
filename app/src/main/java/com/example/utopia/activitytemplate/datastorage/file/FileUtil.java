package com.example.utopia.activitytemplate.datastorage.file;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by weiwei on 11/10/15.
 */
public class FileUtil {

    public static void saveStr2file(Context context, String str) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
         try {
             out = context.openFileOutput("data", Context.MODE_PRIVATE);
             writer = new BufferedWriter(new OutputStreamWriter(out));
             writer.write(str);
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             try {
                 if (writer != null) {
                     writer.close();
                 }
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
    }

    public static String readFromFile(Context context) {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();

        try {
            in = context.openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return content.toString();
    }
}
