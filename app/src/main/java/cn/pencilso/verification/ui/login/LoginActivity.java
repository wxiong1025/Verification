package cn.pencilso.verification.ui.login;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import java.util.Arrays;

import cn.pencilso.verification.R;
import cn.pencilso.verification.adapter.FragmentAdapter;
import cn.pencilso.verification.base.BaseActivity;
import cn.pencilso.verification.ui.login.Fragment.LoginFrag;
import cn.pencilso.verification.ui.login.Fragment.RegisterFrag;
import cn.pencilso.verification.utils.ImageLoader;

public class LoginActivity extends BaseActivity {
    private ImageView login_conver;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    public void initView() {
        super.initView();
        setContentView(getLayoutInflater().inflate(R.layout.act_login, null));
        Toolbar toolbar = (Toolbar) findViewById(R.id.act_base_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        login_conver = findView(R.id.act_login_conver);
        tabLayout = findView(R.id.act_login_tablayout);
        viewPager = findView(R.id.act_login_viewPager);
        Fragment bfs[] = new Fragment[]{new LoginFrag(), new RegisterFrag()};
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), Arrays.asList(bfs), "登录", "注册");
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        ImageLoader.loadImage(R.drawable.photo,login_conver);
    }
}
