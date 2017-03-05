package cn.pencilso.verification.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Pencilso on 2017/3/4.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> frags;
    private String[] title;

    public FragmentAdapter(FragmentManager fm, List<Fragment> frags, String... title) {
        super(fm);
        this.frags = frags;
        this.title = title;
    }

    @Override
    public Fragment getItem(int arg0) {
        return frags.get(arg0);
    }

    @Override
    public int getCount() {
        return frags.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
