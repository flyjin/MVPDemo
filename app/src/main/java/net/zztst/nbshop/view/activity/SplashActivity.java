package net.zztst.nbshop.view.activity;

import android.content.Intent;

import net.zztst.nbshop.R;
import net.zztst.nbshop.contract.SplashContract;
import net.zztst.nbshop.internal.component.ActivityComponent;
import net.zztst.nbshop.presenter.BasePresenter;
import net.zztst.nbshop.presenter.SplashPresenter;
import net.zztst.nbshop.utils.StatusBarUtil;
import net.zztst.nbshop.view.base.AppActivity;
import net.zztst.nbshop.view.base.BaseFragment;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016/8/20.
 */
public class SplashActivity extends AppActivity implements SplashContract.View{


	@Inject
	SplashPresenter presenter;

	@Override
	protected BaseFragment getFirstFragment() {
		return null;
	}

	@Override
	protected BasePresenter getChildPresenter() {
		return presenter;
	}

	@Override
	protected void injectDagger(ActivityComponent activityComponent) {
		activityComponent.inject(this);
	}

	@Override
	protected void initDataAndEvent() {
		StatusBarUtil.setTransparent(this);
		presenter.bindView(this);
		presenter.initData();
	}

	@Override
	protected int getContentViewId() {
		return R.layout.activity_splash;
	}

	@Override
	protected int getFragmentContentId() {
		return 0;
	}

	@Override
	public void toMainActivity() {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}


}
