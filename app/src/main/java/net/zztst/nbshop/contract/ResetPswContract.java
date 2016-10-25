package net.zztst.nbshop.contract;

import android.widget.EditText;

import net.zztst.nbshop.presenter.BasePresenter;
import net.zztst.nbshop.view.BaseView;

/**
 * Created by Administrator on 2016/8/23.
 */
public interface ResetPswContract {

	interface View extends BaseView{
		void setReSetView();
		void setRuntimeView(int time);
		void setTimeOutView();
		void setEditTextIsFalse();
		void setEditTextIsTrue();

	}

	interface Presenter extends BasePresenter<View> {
		void getCode(EditText tel);
		void inviateCode(EditText tel,EditText code);
		void resetpassword(EditText psw, EditText psw2);
	}
}
