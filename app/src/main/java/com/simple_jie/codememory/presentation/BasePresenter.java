package com.simple_jie.codememory.presentation;

/**
 * Created by Xingbo.Jie on 24/2/17.
 */

public interface BasePresenter<T extends BaseView> {
    void setView(T view);
    void start();
}
