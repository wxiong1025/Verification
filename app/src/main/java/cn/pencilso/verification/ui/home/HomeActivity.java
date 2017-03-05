package cn.pencilso.verification.ui.home;

import android.view.MenuItem;

import cn.pencilso.verification.R;
import cn.pencilso.verification.base.BaseActivity;

public class HomeActivity extends BaseActivity {
    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.act_home);
//        Toolbar toolbar = findView(R.id.act_base_toolbar);
//        setSupportActionBar(toolbar);
    }

    @Override
    public void initData() {
        super.initData();
        setActTitle("首页");
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
}
