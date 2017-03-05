package cn.pencilso.verification.Application;

import org.xutils.BuildConfig;
import org.xutils.x;

import java.util.HashMap;
import java.util.Objects;

import cn.pencilso.verification.utils.CodeUtils;

/**
 * Created by Pencilso on 2017/3/5.
 */

public class Application extends android.app.Application {
    private static Application application;
    private static HashMap<Object, Object> map;

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
        application = this;
        map = new HashMap<Object, Object>();
    }

    public static Application getInstance() {
        return application;
    }

    public static <T> T getData(Object key) {
        return getData(key, false);
    }

    public static <T> T getData(Object key, boolean delete) {
        Object data = map.get(key);
        if (delete)
            map.remove(key);
        return (T) data;
    }

    public static void putData(Object key, Object value) {
        if (key == null || value == null)
            throw new NullPointerException("key or value not null");
        map.put(key, value);
    }
}
