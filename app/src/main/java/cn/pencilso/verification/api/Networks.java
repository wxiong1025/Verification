package cn.pencilso.verification.api;


import org.xutils.common.Callback;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * Created by Pencilso on 2017/3/5.
 */

public class Networks {
    private static final Networks networks = new Networks();

    public static Networks getInstance() {
        return networks;
    }

    public void sendHttpRequest(HttpMethod httpMethod, RequestParams params, Callback.CommonCallback<?> callback) {
        x.http().request(httpMethod, params, callback);//综合请求函数   后期可以自行封装解析插件
    }

    /**
     * 用户登录
     *
     * @param UserName
     * @param UserPwd
     * @param Version
     * @param Mac
     */
    public void user_login(
            String UserName,
            String UserPwd,
            int Version,
            String Mac,
            Callback.CommonCallback<?> callback
    ) {
        RequestParams params = new RequestParams(URLInterface.API_USER_LOGIN);
        params.addBodyParameter("UserName", UserName);
        params.addBodyParameter("UserPwd", UserPwd);
        params.addBodyParameter("Version", String.valueOf(Version));
        params.addBodyParameter("Mac", Mac);
        sendHttpRequest(HttpMethod.POST, params, callback);
    }


}
