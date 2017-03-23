package com.simple_jie.codememory.di.components;

import com.simple_jie.codememory.di.modules.ActivityModule;
import com.simple_jie.codememory.di.modules.ApplicationModule;
import com.simple_jie.codememory.di.modules.RepositoryModule;
import com.simple_jie.codememory.presentation.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Xingbo.Jie on 25/2/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class, RepositoryModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity activity);

    ActivityComponent plus(ActivityModule module);
}
