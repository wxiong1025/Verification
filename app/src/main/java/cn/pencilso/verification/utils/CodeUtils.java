package cn.pencilso.verification.utils;

import android.util.ArrayMap;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pencilso on 2017/3/5.
 */

public class CodeUtils {
    private static final CodeUtils codeUtils = new CodeUtils();
    private Map<String, String> codeMap;

    public static CodeUtils getInstance() {
        return codeUtils;
    }

    /**
     * 初始化  加载错误码信息
     */
    public CodeUtils() {
        codeMap = new HashMap<String, String>();
        String code = AssetsUtils.getFromAssets("code.txt");
        /**
         * 对文本进行分割 并且添加到集合当中
         */
        String[] lineData = code.split("\n|\r");
        for (String line : lineData) {
            String[] split = line.split("\\ ");
            codeMap.put(split[0], split[1]);
        }
    }

    public String getString(String key) {
        return codeMap.get(key);
    }

    public String getString(int key) {
        return getString(String.valueOf(key));
    }
}
