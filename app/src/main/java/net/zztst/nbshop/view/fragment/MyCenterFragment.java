package net.zztst.nbshop.view.fragment;

import android.os.Bundle;
import android.view.View;

import net.zztst.nbshop.R;
import net.zztst.nbshop.presenter.BasePresenter;
import net.zztst.nbshop.view.base.BaseFragment;

/**
 * 我的Fragment
 * Created by Administrator on 2016/8/19.
 */
public class MyCenterFragment extends BaseFragment{
	@Override
	protected void initView(View view, Bundle savedInstanceState) {

	}

	@Override
	protected void initData() {

	}

	@Override
	public void loadData() {

	}

	@Override
	protected int getLayoutId() {
		return R.layout.fragment_mycenter;
	}

	@Override
	protected int getFragmentContentId() {
		return 0;
	}

	@Override
	protected BasePresenter getChildPresenter() {
		return null;
	}

	@Override
	protected View getLoaingTargetView() {
		return null;
	}
}
