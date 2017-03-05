package cn.pencilso.verification.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Pencilso on 2017/3/4.
 */

public abstract class BaseFragment extends Fragment {
    private ProgressDialog progressDialog;

    public void initView() {
    }

    public void initData() {
    }

    public void initEvent() {
    }

    public <T extends View> T findView(int viewId) {
        return (T) getView().findViewById(viewId);
    }


    public void startActivity(Class<?> c) {
        startActivity(c, null);
    }

    public void startActivity(Class<?> c, Bundle bundle) {
        Intent intent = new Intent(getContext(), c);
        if (bundle == null)
            startActivity(intent);
        else {
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }

    private View mview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mview == null) {
            mview = onCreateView(inflater, container);
        }
        return mview;
    }

    /**
     * 代替父类的onCreate方法
     *
     * @param inflater
     * @param container
     * @return
     */
    public abstract View onCreateView(LayoutInflater inflater, ViewGroup container);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        initEvent();
    }

    public void showDialog(String text) {
        if (progressDialog != null)
            progressDialog.dismiss();
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage(text);
        progressDialog.setCancelable(true);//设置进度条是否可以按退回键取消
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    public void dismissDialog() {
        progressDialog.dismiss();
        progressDialog = null;
    }

    public void editDialog(String text) {
        if (progressDialog != null)
            progressDialog.setMessage(text);
    }
}
