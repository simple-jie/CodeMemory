package com.simple_jie.codememory.presentation.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.simple_jie.codememory.App;
import com.simple_jie.codememory.R;

import javax.inject.Inject;

public class SubcomponentActivity extends AppCompatActivity {

//    @Inject
//    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcomponent);
//        App.getApplicationComponent2().inject(this);


//        Log.d("SubcomponentActivity", dataBase.toString());
    }
}
