package com.simple_jie.codememory.di.components;

import com.simple_jie.codememory.di.PerActivity;
import com.simple_jie.codememory.di.modules.DaggerSimpleModule;
import com.simple_jie.codememory.presentation.dagger.DaggerSimple2Activity;
import com.simple_jie.codememory.presentation.dagger.DaggerSimpleActivity;
import com.simple_jie.codememory.presentation.dagger.DaggerSimpleFragment;

import dagger.Component;

/**
 * Created by Xingbo.Jie on 26/3/17.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = DaggerSimpleModule.class)
public interface DaggerSimpleComponent extends ActivityComponent {
    void inject(DaggerSimpleActivity daggerSimple);
    void inject(DaggerSimple2Activity daggerSimple);
    void inject(DaggerSimpleFragment fragment);
}
