package com.simple_jie.codememory.presentation.dagger;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simple_jie.codememory.R;
import com.simple_jie.codememory.di.HasComponent;
import com.simple_jie.codememory.di.components.DaggerSimpleComponent;
import com.simple_jie.codememory.presentation.BaseFragment;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

/**
 * Created by Xingbo.Jie on 26/3/17.
 */

public class DaggerSimpleFragment extends BaseFragment {

    DaggerSimpleComponent simpleComponent;

    @Inject
    ICoffeeMaker coffeeMaker; // sigleton maker

    @Inject
    @Named("nomal")
    ICoffeeMaker nomalCoffeeMaker;

    @Inject
    @Named("each")
    ICoffeeMaker eachCoffeeMaker;


    @Inject
    Provider<PerActivtiyCofferMaker> perActivtiyCofferMakerProvider;

    @Inject
    Provider<NomalCofferMaker> nomalCofferMakerProvider;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("dagger", "onAttach");
        if (context instanceof HasComponent) {
            simpleComponent = ((HasComponent<DaggerSimpleComponent>) context).getComponent();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("dagger", "onCreate fragment");
        simpleComponent.inject(this);
        Log.d("dagger", "onCreate fragment 1");

        logObject();

        providerInject();
    }

    private void logObject() {
        Log.d("dagger", "coffeeMaker in fragment:" + coffeeMaker.hashCode());
        Log.d("dagger", "nomalCoffeeMaker in fragment:" + nomalCoffeeMaker.hashCode());
        Log.d("dagger", "eachCoffeeMaker in fragment:" + eachCoffeeMaker.hashCode());
    }

    private void providerInject() {
        // Provider inject
        for (int i = 0; i < 2; i++) {
            Log.d("dagger", "provider PerActivtiyCofferMaker in fragment : " + perActivtiyCofferMakerProvider.get().hashCode());
            Log.d("dagger", "provider NomalCofferMaker in fragment : " + nomalCofferMakerProvider.get().hashCode());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dagger, container, false);
    }
}
