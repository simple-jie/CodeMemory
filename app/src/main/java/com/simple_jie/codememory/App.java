package com.simple_jie.codememory;

import android.app.Application;

import com.simple_jie.codememory.di.components.ApplicationComponent;
import com.simple_jie.codememory.di.components.DaggerApplicationComponent;
import com.simple_jie.codememory.di.modules.ApplicationModule;
import com.simple_jie.codememory.di2.component.ApplicationComponent2;

/**
 * Created by Xingbo.Jie on 21/3/17.
 */

public class App extends Application {

    private static App instance;
    private ApplicationComponent applicationComponent;
    private ApplicationComponent2 applicationComponent2;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

//        applicationComponent2 = DaggerApplicationComponent2.create();
    }


    public static ApplicationComponent getApplicationComponent() {
        return instance.applicationComponent;
    }
    public static ApplicationComponent2 getApplicationComponent2() {
        return instance.applicationComponent2;
    }
}

