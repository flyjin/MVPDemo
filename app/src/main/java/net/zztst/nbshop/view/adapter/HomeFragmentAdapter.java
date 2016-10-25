package net.zztst.nbshop.view.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import net.zztst.nbshop.view.base.BaseFragment;
import net.zztst.nbshop.view.factory.FragmentFactory;

/**
 * 首页Frgment适配器
 */
public class HomeFragmentAdapter extends FragmentPagerAdapter {
    private int count;

    public HomeFragmentAdapter(FragmentManager fm, int count) {
        super(fm);
        this.count = count;
    }

    @Override
    public BaseFragment getItem(int position) {
        return FragmentFactory.getFragment(position);
    }

    @Override
    public int getCount() {
        return count;
    }
}
