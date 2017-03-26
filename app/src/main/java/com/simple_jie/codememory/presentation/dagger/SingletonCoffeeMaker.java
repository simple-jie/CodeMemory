package com.simple_jie.codememory.presentation.dagger;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Xingbo.Jie on 26/3/17.
 */
@Singleton
public class SingletonCoffeeMaker implements ICoffeeMaker {

    @Inject
    public SingletonCoffeeMaker() {
    }

    @Override
    public void make() {

    }
}
