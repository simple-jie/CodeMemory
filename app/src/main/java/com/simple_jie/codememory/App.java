package com.simple_jie.codememory;

import android.app.Application;

import com.simple_jie.codememory.di.components.ApplicationComponent;
import com.simple_jie.codememory.di.components.DaggerApplicationComponent;

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
        applicationComponent = DaggerApplicationComponent.builder(). build();
    }


    public static ApplicationComponent getApplicationComponent() {
        return instance.applicationComponent;
    }
}

