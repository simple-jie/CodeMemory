package com.simple_jie.codememory.di.components;

import com.simple_jie.codememory.di.PerActivity;
import com.simple_jie.codememory.di.modules.ActivityModule;

import dagger.Component;

/**
 * Created by Xingbo.Jie on 25/2/17.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
}
