package com.simple_jie.codememory.di.components;

import com.simple_jie.codememory.di.PerActivity;
import com.simple_jie.codememory.di.modules.ActivityModule;
import com.simple_jie.codememory.presentation.home.MainActivity;

import dagger.Subcomponent;

/**
 * Created by Xingbo.Jie on 25/2/17.
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
}
