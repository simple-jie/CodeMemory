package com.simple_jie.codememory.presentation.dagger;

import com.simple_jie.codememory.di.PerActivity;

import javax.inject.Inject;

/**
 * Created by Xingbo.Jie on 27/3/17.
 */
@PerActivity
public class PerActivtiyCofferMaker implements ICoffeeMaker {

    @Inject
    public PerActivtiyCofferMaker() {
    }

    @Override
    public void make() {
    }
}
