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
import javax.inject.Provider;

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
    ICoffeeMaker nomalCoffeeMaker; // perActivity

    @Inject
    @Named("each")
    ICoffeeMaker eachCoffeeMaker; // each

    @Inject
    @Named("each")
    Lazy<ICoffeeMaker> lazyCoffeeMaker; // lazy

    // compile error
    //@Inject
    //Provider<SingletonCoffeeMaker> perActivtiyCofferMakerProvider;


    @Inject
    Provider<PerActivtiyCofferMaker> perActivtiyCofferMakerProvider;

    @Inject
    Provider<NomalCofferMaker> nomalCofferMakerProvider;

    DaggerSimpleComponent daggerSimpleComponent;


    @Override
    protected void onCreateA(Bundle savedInstanceState) {
        Log.d("dagger", "onCreateA 1");
        //before fragment initialize
        getComponent().inject(this);
        Log.d("dagger", "onCreateA 2");
//      logObject();

        // fragment initialize
        setContentView(R.layout.activity_dagger);

        logObject();

        //after fragment initialize
//      getComponent().inject(this);
//      logObject();

        // lazy inject
        lazyInject();

        providerInject();
    }

    private void logObject() {
        Log.d("dagger", "coffeeMaker in activity:" + coffeeMaker.hashCode());
        Log.d("dagger", "nomalCoffeeMaker in activity:" + nomalCoffeeMaker.hashCode());
        Log.d("dagger", "eachCoffeeMaker in activity:" + eachCoffeeMaker.hashCode());
    }

    private void lazyInject() {
        Observable.timer(5, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        Log.d("dagger", "lazyCoffeeMaker " + lazyCoffeeMaker.get().hashCode());
                    }
                });
    }

    private void providerInject() {
        // Provider inject
        for (int i = 0; i < 2; i++) {
            Log.d("dagger", "provider PerActivtiyCofferMaker in activity : " + perActivtiyCofferMakerProvider.get().hashCode());
            Log.d("dagger", "provider NomalCofferMaker in activity : " + nomalCofferMakerProvider.get().hashCode());
        }
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
