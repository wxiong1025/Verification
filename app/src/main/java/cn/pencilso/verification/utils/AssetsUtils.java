package cn.pencilso.verification.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import cn.pencilso.verification.Application.Application;

/**
 * Created by Pencilso on 2017/3/5.
 */

public class AssetsUtils {
    public static String getFromAssets(String fileName) {
        try {
            InputStreamReader inputReader = new InputStreamReader(Application.getInstance().getResources().getAssets().open(fileName));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line = null;
            StringBuffer sf = new StringBuffer();
            while ((line = bufReader.readLine()) != null)
                sf.append(line).append("\n");
            return sf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
