package net.zztst.nbshop.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.zztst.nbshop.R;
import net.zztst.nbshop.contract.ResetPswContract;
import net.zztst.nbshop.internal.component.ActivityComponent;
import net.zztst.nbshop.presenter.BasePresenter;
import net.zztst.nbshop.presenter.ResetPswPresenter;
import net.zztst.nbshop.view.base.AppActivity;
import net.zztst.nbshop.view.base.BaseFragment;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

public class ResetPswActivity extends AppActivity implements ResetPswContract.View {

	@Inject
	ResetPswPresenter presenter;

	@Bind(R.id.topbase_back)
	ImageView topbaseBack;
	@Bind(R.id.edt_mobile)
	EditText edtMobile;
	@Bind(R.id.btn_getcode)
	Button btnGetcode;
	@Bind(R.id.edt_receivecode)
	EditText edtReceivecode;
	@Bind(R.id.btn_inviateCode)
	Button btnInviateCode;
	@Bind(R.id.ed_pass1)
	EditText etPass1;
	@Bind(R.id.ed_pass2)
	EditText etPass2;
	@Bind(R.id.btn_resetpass)
	Button btnResetpass;
	@Bind(R.id.tv_process1)
	TextView tvProcess1;
	@Bind(R.id.tv_process2)
	TextView tvProcess2;
	@Bind(R.id.li_invatecode)
	LinearLayout liInvatecode;
	@Bind(R.id.li_resetpass)
	LinearLayout liResetpass;


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
		presenter.bindView(this);
	}

	@Override
	protected int getContentViewId() {
		return R.layout.activity_reset_psw;
	}

	@Override
	protected int getFragmentContentId() {
		return 0;
	}

	@Override
	public void setReSetView() {
		tvProcess1.setTextColor(getResources()
				.getColor(R.color.text_color_gray_c1));
		tvProcess2.setTextColor(getResources()
				.getColor(R.color.shape_text_white));
		liInvatecode.setVisibility(View.GONE);
		liResetpass.setVisibility(View.VISIBLE);
	}

	//开始计时
	@Override
	public void setRuntimeView(int time) {
		btnGetcode.setTextSize(12);
		btnGetcode.setText("验证码已发送\n(" + time+ "秒)后重新获取");
	}

	//计时结束
	@Override
	public void setTimeOutView() {
		btnGetcode.setTextSize(14);
		btnGetcode.setText("获取验证码");
	}

	@Override
	public void setEditTextIsFalse() {
		edtMobile.setEnabled(false);
		btnGetcode.setEnabled(false);
	}

	@Override
	public void setEditTextIsTrue() {
		edtMobile.setEnabled(true);
		btnGetcode.setEnabled(true);
	}

	@OnClick({R.id.btn_getcode, R.id.btn_inviateCode, R.id.btn_resetpass})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.btn_getcode:
				presenter.getCode(edtMobile);
				break;
			case R.id.btn_inviateCode:
				presenter.inviateCode(edtMobile,edtReceivecode);
				break;
			case R.id.btn_resetpass:
				presenter.resetpassword(etPass1,etPass2);
				break;
		}
	}

}
