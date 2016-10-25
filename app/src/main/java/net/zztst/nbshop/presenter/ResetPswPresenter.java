package net.zztst.nbshop.presenter;

import android.os.CountDownTimer;
import android.widget.EditText;

import net.zztst.nbshop.contract.ResetPswContract;
import net.zztst.nbshop.utils.AppUtils;

import javax.inject.Inject;

/**
 *重置密码
 * Created by Administrator on 2016/8/23.
 */
public class ResetPswPresenter implements ResetPswContract.Presenter{

	private final TimeCount time;
	private ResetPswContract.View view;


	@Inject
	public ResetPswPresenter() {
		time = new TimeCount(60000, 1000);// 构造CountDownTimer对象
	}

	//获取验证码
	@Override
	public void getCode(EditText etTel) {
		String tel = etTel.getText().toString().trim();
		if (tel.isEmpty() || !AppUtils.isPhone(tel)) {
			view.showMessage( "请输入正确的手机号！");

		} else {
			view.showProgress("正在发送请求...");
			view.setEditTextIsFalse();
			requestNet();
		}
	}

	//请求验证码
	private void requestNet() {
		//TODO
	}

	//提交验证码
	@Override
	public void inviateCode(EditText tel, EditText code) {

	}

	//重置密码
	@Override
	public void resetpassword(EditText psw, EditText psw2) {

	}

	@Override
	public void bindView(ResetPswContract.View view) {
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
	class TimeCount extends CountDownTimer {
		public TimeCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);// 参数依次为总时长,和计时的时间间隔
		}

		@Override
		public void onFinish() {// 计时完毕时触发
			view.setEditTextIsTrue();
			view.setTimeOutView();
		}

		@Override
		public void onTick(long millisUntilFinished) {// 计时过程显示
			view.setEditTextIsFalse();
			view.setTimeOutView();

		}
	}
}
