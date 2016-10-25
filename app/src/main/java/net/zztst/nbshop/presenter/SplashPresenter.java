package net.zztst.nbshop.presenter;

import android.content.Context;
import android.os.AsyncTask;

import net.zztst.nbshop.NBShpApplication;
import net.zztst.nbshop.contract.SplashContract;
import net.zztst.nbshop.internal.ActivityContext;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016/8/20.
 */
public class SplashPresenter implements SplashContract.Presenter {
	private static final short SPLASH_SHOW_SECONDS = 1;
	private long mShowMainTime;
	private SplashContract.View view;
	private Context context;
	private NBShpApplication application;

	@Inject
	public SplashPresenter(@ActivityContext Context context, NBShpApplication application) {
		this.context = context;
		this.application = application;
	}


	@Override
	public void bindView(SplashContract.View view) {
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
	private void showView() {
		AsyncTask<String, String, String> showMainTask = new AsyncTask<String, String, String>() {
			@Override
			protected String doInBackground(String[] params) {
				if (System.currentTimeMillis() < mShowMainTime) {
					try {
						long sleepTime = mShowMainTime - System.currentTimeMillis();
						if (sleepTime > 0) {
							Thread.sleep(mShowMainTime - System.currentTimeMillis());
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				return null;
			}

			@Override
			protected void onPostExecute(String o) {
					view.toMainActivity();
					view.close();
			}
		};

		showMainTask.execute();
	}

	@Override
	public void initData() {
		mShowMainTime = System.currentTimeMillis() + SPLASH_SHOW_SECONDS * 2000;
		showView();
	}
}
