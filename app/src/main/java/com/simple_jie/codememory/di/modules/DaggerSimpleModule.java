package com.simple_jie.codememory.di.modules;

import android.util.Log;

import com.simple_jie.codememory.di.PerActivity;
import com.simple_jie.codememory.presentation.BaseActivity;
import com.simple_jie.codememory.presentation.dagger.ICoffeeMaker;
import com.simple_jie.codememory.presentation.dagger.NomalCofferMaker;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Xingbo.Jie on 26/3/17.
 */
@Module
public class DaggerSimpleModule extends ActivityModule {
    public DaggerSimpleModule(BaseActivity activity) {
        super(activity);
    }

    @Provides
    @PerActivity
    @Named("nomal")
    public ICoffeeMaker provideCoffeeMaker(NomalCofferMaker coffeeMaker) {
        Log.d("dagger", "provideCoffeeMaker nomal");
        return coffeeMaker;
    }

    @Provides
    @Named("each")
    public ICoffeeMaker provideEachCoffeeMaker(NomalCofferMaker coffeeMaker) {
        Log.d("dagger", "provideEachCoffeeMaker nomal");
        return coffeeMaker;
    }
}
