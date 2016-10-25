package net.zztst.nbshop.view.activity;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.widget.TextView;

import net.zztst.nbshop.R;
import net.zztst.nbshop.internal.component.ActivityComponent;
import net.zztst.nbshop.presenter.BasePresenter;
import net.zztst.nbshop.utils.AppUtils;
import net.zztst.nbshop.utils.ResourceUtils;
import net.zztst.nbshop.view.adapter.HomeFragmentAdapter;
import net.zztst.nbshop.view.base.AppActivity;
import net.zztst.nbshop.view.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppActivity {

	@Bind(R.id.home_content)
	ViewPager container;
	@Bind(R.id.tab)
	android.support.design.widget.TabLayout tab;
	private HomeFragmentAdapter adapter;

	@Override
	protected BaseFragment getFirstFragment() {
		return null;
	}

	@Override
	protected BasePresenter getChildPresenter() {
		return null;
	}

	@Override
	protected void initDataAndEvent() {

		ButterKnife.bind(this);
		tab.setTabMode(TabLayout.MODE_FIXED);
		initTab();
		setListener();
		setAdapterAndNotify();
		container.setOffscreenPageLimit(3);
	}

	private void setAdapterAndNotify() {
		if (null == adapter) {
			adapter = new HomeFragmentAdapter(getSupportFragmentManager(), 4);
			container.setAdapter(adapter);
		} else {
			adapter.notifyDataSetChanged();
		}
	}

	private void setListener() {
		//这行代码将TabLayout与ViewPager的页面切换绑定 原理很简单 看源码
		container.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
		tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			@Override
			public void onTabSelected(TabLayout.Tab tab) {
				int position = tab.getPosition();
				//ViewPager切换页面无动画需要使用两个参数的方法并传入false
				container.setCurrentItem(position, false);
				//这句别忘了 否则tab就丢失选择器效果了
				tab.getCustomView().setEnabled(true);
				//当前页面的数据加载
				adapter.getItem(position).loadData();
			}

			@Override
			public void onTabUnselected(TabLayout.Tab tab) {
				//别忘了
				tab.getCustomView().setEnabled(false);
			}

			@Override
			public void onTabReselected(TabLayout.Tab tab) {

			}
		});

	}


	private void initTab() {
		LayoutInflater inflater = getLayoutInflater();
		TextView view;
		for (int i = 0; i < 4; i++) {
			view = (TextView) inflater.inflate(R.layout.tab_home_item, null);
			String text = null;
			Drawable drawable = null;
			switch (i) {
				case 0:
					text = ResourceUtils.getString(R.string.tab_home);
					view.setEnabled(true);
					drawable = ResourceUtils.getDrawable(R.drawable.tab_main);
					break;
				case 1:
					text = ResourceUtils.getString(R.string.tab_category);
					drawable = ResourceUtils.getDrawable(R.drawable.tab_what);
					break;
				case 2:
					text = ResourceUtils.getString(R.string.tab_shopcart);
					drawable = ResourceUtils.getDrawable(R.drawable.tab_message);
					break;
				case 3:
					text = ResourceUtils.getString(R.string.tab_mycenter);
					drawable = ResourceUtils.getDrawable(R.drawable.tab_mine);
					break;
			}
			view.setText(text);
			drawable.setBounds(0, 0, AppUtils.px2dip(this,200), AppUtils.px2dip(this,200));
			view.setCompoundDrawables(null, drawable, null, null);
			TabLayout.Tab tab = this.tab.newTab().setCustomView(view);
			this.tab.addTab(tab, i == 0 ? true : false);
		}
	}

	@Override
	protected int getContentViewId() {
		return R.layout.activity_main;
	}

	@Override
	protected void injectDagger(ActivityComponent activityComponent) {

	}
}
