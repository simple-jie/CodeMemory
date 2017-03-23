package com.simple_jie.domain.interactor;


import com.simple_jie.domain.executor.PostExecutionThread;
import com.simple_jie.domain.executor.ThreadExecutor;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Xingbo.Jie on 21/6/16.
 */
public abstract class UseCase<ARGS, RESULT> {
    private final ThreadExecutor mThreadExecutor;
    private final PostExecutionThread mPostExecutionThread;

    public UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        mThreadExecutor = threadExecutor;
        mPostExecutionThread = postExecutionThread;
    }

    /**
     * Builds an {@link io.reactivex.Observable} which will be used when executing the current {@link UseCase}.
     */
    protected abstract Observable<RESULT> buildUseCaseObservable(ARGS args);

    /**
     * Executes the current use case.
     *
     * @param observer The guy who will be listen to the observable build
     *                          with {@link #buildUseCaseObservable(ARGS args)}.
     */
    @SuppressWarnings("unchecked")
    public void execute(DefaultObserver<RESULT> observer, ARGS args) {
        buildUseCaseObservable(args).subscribeOn(Schedulers.from(mThreadExecutor))
                .observeOn(mPostExecutionThread.getScheduler())
                .subscribe(observer);

    }
}
