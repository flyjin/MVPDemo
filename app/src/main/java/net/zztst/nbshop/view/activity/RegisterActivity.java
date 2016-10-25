package net.zztst.nbshop.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.zztst.nbshop.R;
import net.zztst.nbshop.internal.component.ActivityComponent;
import net.zztst.nbshop.presenter.BasePresenter;
import net.zztst.nbshop.view.base.AppActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class RegisterActivity extends AppActivity {

	@Bind(R.id.tv_process1)
	TextView tvProcess1;
	@Bind(R.id.tv_process2)
	TextView tvProcess2;
	@Bind(R.id.tv_process3)
	TextView tvProcess3;
	@Bind(R.id.edt_mobile)
	EditText edtMobile;
	@Bind(R.id.edt_setmobile)
	EditText edtSetmobile;
	@Bind(R.id.btn_user_getCode)
	Button btnUserGetCode;
	@Bind(R.id.check_agreement)
	CheckBox checkAgreement;
	@Bind(R.id.tv_agreement)
	TextView tvAgreement;
	@Bind(R.id.ll_input_mobile)
	LinearLayout llInputMobile;
	@Bind(R.id.edt_mobile_code)
	EditText edtMobileCode;
	@Bind(R.id.btn_get_phonecode)
	Button btnGetPhonecode;
	@Bind(R.id.btn_user_code)
	Button btnUserCode;
	@Bind(R.id.ll_input_code)
	LinearLayout llInputCode;
	@Bind(R.id.edt_password)
	EditText edtPassword;
	@Bind(R.id.edt_password_again)
	EditText edtPasswordAgain;
	@Bind(R.id.edt_paypasw)
	EditText edtPaypasw;
	@Bind(R.id.edt_paypasw_again)
	EditText edtPaypaswAgain;
	@Bind(R.id.btn_user_register)
	Button btnUserRegister;
	@Bind(R.id.ll_setpasswprd)
	LinearLayout llSetpasswprd;

	@Override
	protected BasePresenter getChildPresenter() {
		return null;
	}

	@Override
	protected void injectDagger(ActivityComponent activityComponent) {

	}

	@Override
	protected void initDataAndEvent() {

	}

	@Override
	protected int getContentViewId() {
		return R.layout.activity_register;
	}


	@OnClick({R.id.btn_user_getCode, R.id.btn_get_phonecode, R.id.btn_user_code, R.id.btn_user_register})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.btn_user_getCode://获取验证码 第一次

				break;
			case R.id.btn_get_phonecode://重新获取验证码  计时结束第二次

				break;
			case R.id.btn_user_code://提交验证码

				break;
			case R.id.btn_user_register://注册

				break;
		}
	}
}
