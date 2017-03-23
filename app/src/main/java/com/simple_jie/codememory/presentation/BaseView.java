package com.simple_jie.codememory.presentation;

/**
 * Created by Xingbo.Jie on 24/2/17.
 */

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
