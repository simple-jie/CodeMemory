package com.simple_jie.codememory.di2.component;

import com.simple_jie.codememory.presentation.dagger2.DataBase;

/**
 * Created by Xingbo.Jie on 27/3/17.
 */
//@Subcomponent(modules = DatabaseImplModule.class)
public interface DatabaseComponent {
    DataBase database();
//    @Subcomponent.Builder
//    interface Builder {
//        Builder databaseImplModule(DatabaseImplModule databaseImplModule);
//        DatabaseComponent build();
//    }
}
