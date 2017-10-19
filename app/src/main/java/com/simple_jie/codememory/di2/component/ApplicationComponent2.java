package com.simple_jie.codememory.di2.component;

import com.simple_jie.codememory.presentation.dagger2.DataBase;
import com.simple_jie.codememory.presentation.dagger2.SubcomponentActivity;

/**
 * Created by Xingbo.Jie on 27/3/17.
 */
//@Singleton
//@Component(modules = {ApplicationModule.class, DatabaseModul.class})
public interface ApplicationComponent2 {
    DataBase database();
    void inject(SubcomponentActivity activity);
}
