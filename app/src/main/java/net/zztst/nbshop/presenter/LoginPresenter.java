package net.zztst.nbshop.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import net.zztst.nbshop.contract.LoginContract;
import net.zztst.nbshop.data.ApiService;
import net.zztst.nbshop.data.bean.User;
import net.zztst.nbshop.internal.ActivityContext;
import net.zztst.nbshop.utils.AppUtils;
import net.zztst.nbshop.view.BaseView;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/8/22.
 */
public class LoginPresenter  implements LoginContract.Presenter {
	private BaseView view;
	private Context context;

	@Inject
	ApiService apiService;


	@Inject
	public LoginPresenter(@ActivityContext Context context) {

		this.context = context;
	}

	@Override
	public void toLogin(EditText etName, EditText etPsw) {
		String username = etName.getText().toString();
		String password = etPsw.getText().toString();
		if(!AppUtils.isPhone(username)){
			view.showMessage("请输入正确的手机号！");
			return;
		}
		if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
			view.showMessage("账号密码不能为空！");
			return;
		}
		if (!AppUtils.isNetWorkConnected(context)) {
			view.showMessage("网络连接不可用！");
			return;
		}
		dologin(username, password);
	}

	private void dologin(String username, String password) {

		view.showProgress("正在登陆...");
		apiService.login(username,password)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribeOn(Schedulers.io())
				.subscribe(new Subscriber<User>() {
			@Override
			public void onCompleted() {

			}

			@Override
			public void onError(Throwable e) {
				//view.showErrorMessage("登陆失败",);
			}

			@Override
			public void onNext(User user) {
				view.hideProgress();
				//储存user信息
			}
		});
	}



	@Override
	public void bindView(BaseView view) {
		this.view = view;
	}

	@Override
	public void resume() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void destroy() {

	}

}
