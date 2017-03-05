package cn.pencilso.verification.ui.init;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import cn.pencilso.verification.R;

public class InitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getSupportActionBar() != null)
//            getSupportActionBar().hide();

        setContentView(R.layout.act_init);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.act_alpha);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(InitActivity.this, cn.pencilso.verification.ui.login.LoginActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        findViewById(R.id.act_init).startAnimation(animation);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();

    }
}
