package net.zztst.nbshop.internal.component;

import android.content.Context;

import net.zztst.nbshop.NBShpApplication;
import net.zztst.nbshop.data.ApiService;
import net.zztst.nbshop.internal.ApplicationContext;
import net.zztst.nbshop.internal.module.ActivityModule;
import net.zztst.nbshop.internal.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 *  ApplicationComponent
 * Created by Administrator on 2016/8/19.
 */
@Singleton
@Component(modules ={ApplicationModule.class, ActivityModule.class})
public interface ApplicationComponent {
	void inject(NBShpApplication application);



	@ApplicationContext
	Context context();

	NBShpApplication application();

	ApiService apiService();


}
