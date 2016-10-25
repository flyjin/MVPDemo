package net.zztst.nbshop.contract;

import android.widget.EditText;

import net.zztst.nbshop.presenter.BasePresenter;
import net.zztst.nbshop.view.BaseView;

/**
 * Created by Administrator on 2016/8/22.
 */
public interface LoginContract {

	interface Presenter extends BasePresenter<BaseView> {
		void toLogin(EditText username, EditText userpsw);
	}


}
