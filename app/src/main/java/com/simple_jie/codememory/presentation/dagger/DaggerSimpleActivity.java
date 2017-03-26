package com.simple_jie.codememory.presentation.dagger;

import android.os.Bundle;
import android.util.Log;

import com.simple_jie.codememory.R;
import com.simple_jie.codememory.di.HasComponent;
import com.simple_jie.codememory.di.components.DaggerDaggerSimpleComponent;
import com.simple_jie.codememory.di.components.DaggerSimpleComponent;
import com.simple_jie.codememory.di.modules.DaggerSimpleModule;
import com.simple_jie.codememory.presentation.BaseActivity;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Lazy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class DaggerSimpleActivity extends BaseActivity implements HasComponent<DaggerSimpleComponent> {

    @Inject
    ICoffeeMaker coffeeMaker; // sigleton maker

    @Inject
    @Named("nomal")
    ICoffeeMaker nomalCoffeeMaker;

    @Inject
    @Named("each")
    ICoffeeMaker eachCoffeeMaker;

    @Inject
    @Named("each")
    Lazy<ICoffeeMaker> lazyCoffeeMaker;

    DaggerSimpleComponent daggerSimpleComponent;


    @Override
    protected void onCreateA(Bundle savedInstanceState) {
        Log.d("dagger", "onCreateA 1");
        //before fragment initialize
        getComponent().inject(this);
        Log.d("dagger", "onCreateA 2");
//        Log.d("dagger", "coffeeMaker in activity:" + coffeeMaker.hashCode());
//        Log.d("dagger", "nomalCoffeeMaker in activity:" + nomalCoffeeMaker.hashCode());
//        Log.d("dagger", "eachCoffeeMaker in activity:" + eachCoffeeMaker.hashCode());

        // fragment initialize
        setContentView(R.layout.activity_dagger);

        Log.d("dagger", "coffeeMaker in activity:" + coffeeMaker.hashCode());
        Log.d("dagger", "nomalCoffeeMaker in activity:" + nomalCoffeeMaker.hashCode());
        Log.d("dagger", "eachCoffeeMaker in activity:" + eachCoffeeMaker.hashCode());

        //after fragment initialize
//        getComponent().inject(this);
//        Log.d("dagger", "coffeeMaker in activity:" + coffeeMaker.hashCode());
//        Log.d("dagger", "nomalCoffeeMaker in activity:" + nomalCoffeeMaker.hashCode());
//        Log.d("dagger", "eachCoffeeMaker in activity:" + eachCoffeeMaker.hashCode());

        Observable.timer(5, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        Log.d("dagger", "lazyCoffeeMaker " + lazyCoffeeMaker.get().hashCode());
                    }
                });
    }

    @Override
    public DaggerSimpleComponent getComponent() {
        if (daggerSimpleComponent == null) {
            daggerSimpleComponent = DaggerDaggerSimpleComponent.builder()
                    .applicationComponent(getApplicationComponent())
                    .daggerSimpleModule(new DaggerSimpleModule(this))
                    .build();
        }
        return daggerSimpleComponent;
    }
}
