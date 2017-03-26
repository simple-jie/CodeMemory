package com.simple_jie.codememory.utility;

import android.content.Context;
import android.content.Intent;

import com.simple_jie.codememory.presentation.dagger.DaggerSimpleActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Xingbo.Jie on 24/2/17.
 */
@Singleton
public class Navigator {

    @Inject
    public Navigator() {
    }


    public void goToDaggerSimple(Context context) {
        context.startActivity(new Intent(context, DaggerSimpleActivity.class));
    }
}
