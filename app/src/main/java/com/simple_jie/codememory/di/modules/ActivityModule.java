package com.simple_jie.codememory.di.modules;

import android.util.Log;

import com.simple_jie.codememory.di.PerActivity;
import com.simple_jie.codememory.presentation.BaseActivity;
import com.simple_jie.codememory.presentation.ScreenLifecycle;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Xingbo.Jie on 25/2/17.
 */
@Module
public class ActivityModule {
    private BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    BaseActivity providerActivity() {
        return activity;
    }

    @Provides
    @PerActivity
    ScreenLifecycle.Provider providerScreenLifecycleProvider() {
        return activity.getLifecycleProvider();
    }
}
