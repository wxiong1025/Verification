package cn.pencilso.verification.ui.login.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;

import org.xutils.common.Callback;

import cn.pencilso.verification.R;
import cn.pencilso.verification.api.Networks;
import cn.pencilso.verification.base.BaseFragment;
import cn.pencilso.verification.utils.CodeUtils;
import cn.pencilso.verification.utils.Utils;

/**
 * Created by Pencilso on 2017/3/4.
 */

public class LoginFrag extends BaseFragment implements View.OnClickListener {
    private AutoCompleteTextView inUserName;
    private AutoCompleteTextView inUserPwd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.frag_login, null);
    }

    @Override
    public void initView() {
        super.initView();
        inUserName = findView(R.id.frag_login_userName);
        inUserPwd = findView(R.id.frag_login_userPwd);
    }

    private void login() {
        /**
         * 非空验证
         */
        View view = null;
        String userName = inUserName.getText().toString().trim();
        String userPwd = inUserPwd.getText().toString().trim();
        if (userName.length() == 0) {
            inUserName.setError("帐号不可为空!");
            view = inUserName;
        } else if (userPwd.length() == 0) {
            inUserPwd.setError("密码不可为空");
            view = inUserPwd;
        }
        if (view != null) {
            view.requestFocus();
            return;
        }
        showDialog("正在登录");
        Networks.getInstance().user_login(userName, userPwd, Utils.getVersion(getContext()), Utils.getMac(), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                String errorInfo = CodeUtils.getInstance().getString(result);//错误信息  如果为空的话  则登陆成功  result就是登陆成功后的调试码
                if (errorInfo == null) {
                    editDialog("登陆成功");
                } else {
                    editDialog(errorInfo);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                editDialog("与服务器连接异常");
            }

            @Override
            public void onCancelled(CancelledException cex) {
                editDialog("取消登录");
            }

            /**
             * 完成请求
             */
            @Override
            public void onFinished() {
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.frag_login_but:
                login();
                break;
        }
    }

    @Override
    public void initEvent() {
        super.initEvent();
        getView().findViewById(R.id.frag_login_but).setOnClickListener(this);
    }
}
