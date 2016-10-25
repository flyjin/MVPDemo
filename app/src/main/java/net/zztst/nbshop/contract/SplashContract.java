package net.zztst.nbshop.contract;

import net.zztst.nbshop.presenter.BasePresenter;
import net.zztst.nbshop.view.BaseView;

/**
 * Created by Administrator on 2016/8/20.
 */
public interface SplashContract {
	interface Presenter extends BasePresenter<View> {
		void initData();
	}
	interface View extends BaseView{
		void toMainActivity();
	}
}
