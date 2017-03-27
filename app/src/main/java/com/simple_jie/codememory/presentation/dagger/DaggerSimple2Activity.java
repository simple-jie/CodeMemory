package com.simple_jie.codememory.presentation.dagger;

import android.os.Bundle;
import android.util.Log;

import com.simple_jie.codememory.R;
import com.simple_jie.codememory.di.components.DaggerDaggerSimpleComponent;
import com.simple_jie.codememory.di.modules.DaggerSimpleModule;
import com.simple_jie.codememory.presentation.BaseActivity;

import javax.inject.Inject;

public class DaggerSimple2Activity extends BaseActivity {

    @Inject
    ReusableCoffeeMaker reusableCoffeeMaker;


    @Override
    protected void onCreateA(Bundle savedInstanceState) {
        setContentView(R.layout.activity_dagger_simple2);

        DaggerDaggerSimpleComponent.builder()
                .applicationComponent(getApplicationComponent())
                .daggerSimpleModule(new DaggerSimpleModule(this))
                .build()
                .inject(this);

        logObject();
    }


    private void logObject() {
        Log.d("dagger", "reusableCoffeeMaker in Simple2:" + reusableCoffeeMaker.hashCode());
    }
}
