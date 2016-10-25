package net.zztst.nbshop.view.factory;

import android.util.SparseArray;

import net.zztst.nbshop.view.base.BaseFragment;
import net.zztst.nbshop.view.fragment.CategoryFragment;
import net.zztst.nbshop.view.fragment.HomeFragment;
import net.zztst.nbshop.view.fragment.MyCenterFragment;
import net.zztst.nbshop.view.fragment.ShopCartFragment;

import java.lang.ref.SoftReference;

public class FragmentFactory {
    private static SparseArray<SoftReference<BaseFragment>> arr = new SparseArray<SoftReference<BaseFragment>>();

    public static BaseFragment getFragment(int pos) {
        BaseFragment fragment = null;
        if (null != arr.get(pos))
            fragment = arr.get(pos).get();
        if (null == fragment) {
            switch (pos) {
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new CategoryFragment();
                    break;
                case 2:
                    fragment = new ShopCartFragment();
                    break;
                case 3:
                    fragment = new MyCenterFragment();
                    break;
            }
            arr.put(0, new SoftReference<BaseFragment>(fragment));
        }
        return fragment;
    }
}