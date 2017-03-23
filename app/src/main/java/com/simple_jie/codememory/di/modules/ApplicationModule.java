package com.simple_jie.codememory.di.modules;

import android.app.Application;
import android.content.Context;

import com.simple_jie.codememory.utility.JobThreadExecutor;
import com.simple_jie.codememory.utility.UIPostExecutionThread;
import com.simple_jie.domain.executor.PostExecutionThread;
import com.simple_jie.domain.executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Xingbo.Jie on 25/2/17.
 */
@Module
public class ApplicationModule {
    private final Application application;
    public ApplicationModule(Application app) {
        this.application = app;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    public ThreadExecutor provideThreadExecutor(JobThreadExecutor threadExecutor) {
        return threadExecutor;
    }

    @Provides
    @Singleton
    public PostExecutionThread providePostExecutionThread(UIPostExecutionThread thread) {
        return thread;
    }
}
