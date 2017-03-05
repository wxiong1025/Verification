package cn.pencilso.verification.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jude.swipbackhelper.SwipeBackHelper;

import cn.pencilso.verification.R;

/**
 * Created by Pencilso on 2017/3/4.
 */
public class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this).setSwipeEdgePercent(0.2f);//触发侧滑百分比为20%
        if (getSupportActionBar() != null)//设置显示返回按钮
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getSupportActionBar() != null)//设置不显示原有的标题
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        initView();
        initData();
        initEvent();
    }

    public <T extends View> T findView(int viewId) {
        return (T) findViewById(viewId);
    }

    public BaseActivity getActivity() {
        return this;
    }

    public void startActivity(Class<?> c) {
        startActivity(c, null);
    }

    public void startActivity(Class<?> c, Bundle bundle) {
        Intent intent = new Intent(this, c);
        if (bundle == null)
            startActivity(intent);
        else {
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }

    public void initView() {
    }

    public void initData() {
    }

    public void initEvent() {
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayoutCompat.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        Toolbar toolbar = (Toolbar) getLayoutInflater().inflate(R.layout.toolbar_layout, null);
        View inflate = getLayoutInflater().inflate(layoutResID, null);
        linearLayout.addView(toolbar);
        linearLayout.addView(inflate);
        setContentView(linearLayout);
        setSupportActionBar(toolbar);
        if (getTitle() != null)
            setActTitle(String.valueOf(getTitle()));
    }

    public void setActTitle(String title) {
        if (title == null)
            return;
        TextView titleView = (TextView) findViewById(R.id.act_base_titme);
        titleView.setText(title);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SwipeBackHelper.onDestroy(this);
    }

    /**
     * 是否开启侧滑
     *
     * @param isEnble
     */
    public void setSwipeBackEnable(boolean isEnble) {
        SwipeBackHelper.getCurrentPage(this).setSwipeBackEnable(isEnble);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showDialog(String text) {
        if (progressDialog != null)
            progressDialog.dismiss();
        progressDialog = new ProgressDialog(this);
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
