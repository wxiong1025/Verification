package cn.pencilso.verification.api;

/**
 * Created by Pencilso on 2017/3/5.
 */

public interface URLInterface {
    public static final String API_BASE_URL = "http://w.eydata.net/%s";//易游验证的线路
    /**
     * 登录接口地址
     */
    public static final String API_USER_LOGIN = String.format(API_BASE_URL, "c43300e5a5deea37");
}
