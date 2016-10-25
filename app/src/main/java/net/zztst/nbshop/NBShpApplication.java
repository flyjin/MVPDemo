package net.zztst.nbshop;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import net.zztst.nbshop.internal.component.ApplicationComponent;
import net.zztst.nbshop.internal.component.DaggerApplicationComponent;
import net.zztst.nbshop.internal.module.ApplicationModule;

/**
 * Created by Administrator on 2016/8/19.
 */
public class NBShpApplication extends Application {
	public static Context mContext;
	private ApplicationComponent mComponent;

	public static NBShpApplication get(Context context) {
		return (NBShpApplication) context.getApplicationContext();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mContext = this;
		getAppComponent();
		//mComponent.inject(this);
		//初始化Logger
		Logger.init().hideThreadInfo().logLevel(LogLevel.FULL);
	}
	public ApplicationComponent getAppComponent() {
		if (mComponent == null) {
			mComponent = DaggerApplicationComponent.builder().
					applicationModule(new ApplicationModule(this)).
					build();
		}
		return mComponent;
	}

}
