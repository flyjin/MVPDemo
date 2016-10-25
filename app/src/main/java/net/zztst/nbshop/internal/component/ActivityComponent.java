package net.zztst.nbshop.internal.component;

import net.zztst.nbshop.internal.PerActivity;
import net.zztst.nbshop.internal.module.ActivityModule;
import net.zztst.nbshop.view.activity.LoginActivity;
import net.zztst.nbshop.view.activity.ResetPswActivity;
import net.zztst.nbshop.view.activity.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
	void inject(SplashActivity SplashActivity);
	void inject(LoginActivity LoginActivity);
	void inject(ResetPswActivity ResetPswActivity);

}
