package net.zztst.nbshop.internal.module;

import android.app.Activity;
import android.content.Context;

import net.zztst.nbshop.internal.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Arron on 16/7/25.
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return mActivity;
    }
}
