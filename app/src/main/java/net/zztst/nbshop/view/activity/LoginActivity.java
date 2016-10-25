package net.zztst.nbshop.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.zztst.nbshop.R;
import net.zztst.nbshop.internal.component.ActivityComponent;
import net.zztst.nbshop.presenter.BasePresenter;
import net.zztst.nbshop.presenter.LoginPresenter;
import net.zztst.nbshop.utils.PreferenceUtils;
import net.zztst.nbshop.view.base.AppActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

public class LoginActivity extends AppActivity{



	@Inject
	LoginPresenter presenter;

	@Bind(R.id.topbase_back)
	ImageView topbaseBack;
	@Bind(R.id.topbase_center_text)
	TextView topbaseCenterText;
	@Bind(R.id.rl_topbase)
	RelativeLayout rlTopbase;
	@Bind(R.id.activity_user_login_inptut_username)
	EditText usernameEditText;
	@Bind(R.id.activity_user_login_inptut_password)
	EditText userpswEditText;
	@Bind(R.id.activity_user_login_inptut_submit)
	Button activityUserLoginInptutSubmit;
	@Bind(R.id.tv_doregister)
	TextView tvDoregister;
	@Bind(R.id.tv_forget_password)
	TextView tvForgetPassword;

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
		presenter.bindView(this);
	}

	@Override
	protected int getContentViewId() {
		return R.layout.activity_login;
	}


	@OnClick({R.id.tv_doregister, R.id.tv_forget_password,R.id.activity_user_login_inptut_submit})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.tv_doregister:

				break;
			case R.id.tv_forget_password:

				break;
			case R.id.activity_user_login_inptut_submit:
				presenter.toLogin(usernameEditText,userpswEditText);
				break;

		}
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 100) {
			// 注册成功返回
			usernameEditText.setText(PreferenceUtils.getInstance(this)
					.getSettingUserName());
		}
	}
}
