package com.simple_jie.codememory.presentation.dagger;

import javax.inject.Inject;

import dagger.Reusable;

/**
 * Created by Xingbo.Jie on 27/3/17.
 */
@Reusable
public class ReusableCoffeeMaker implements ICoffeeMaker {

    @Inject
    public ReusableCoffeeMaker() {
    }

    @Override
    public void make() {

    }
}
