package com.simple_jie.codememory;

import android.app.Application;

import com.simple_jie.codememory.di.components.ApplicationComponent;
import com.simple_jie.codememory.di.components.DaggerApplicationComponent;
import com.simple_jie.codememory.di.modules.ApplicationModule;

/**
 * Created by Xingbo.Jie on 21/3/17.
 */

public class App extends Application {

    private static App instance;
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }


    public static ApplicationComponent getApplicationComponent() {
        return instance.applicationComponent;
    }
}

