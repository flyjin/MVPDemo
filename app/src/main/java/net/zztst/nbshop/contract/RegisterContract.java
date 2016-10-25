package net.zztst.nbshop.contract;

import android.widget.EditText;

import net.zztst.nbshop.presenter.BasePresenter;
import net.zztst.nbshop.view.BaseView;

/**
 * Created by Administrator on 2016/8/29.
 */
public interface RegisterContract {


	interface View extends BaseView{
		void setInputCodeView();
		void setSettingPswView();
		void setRuntimeView(int time);
		void setTimeOutView();
	}
	interface Presenter extends BasePresenter<View> {
		void getCode(EditText tel);
		void reGetCode();
		void register();
	}

}
