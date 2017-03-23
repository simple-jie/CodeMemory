/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.simple_jie.domain.interactor;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * PerActivity
 * Default subscriber base class to be used whenever you want default error handling.
 */
public class DefaultObserver<T> implements Observer<T> {
    Disposable disposable;

    @Override
    public void onComplete() {
        // no-op by default.
    }

    @Override
    public void onError(Throwable e) {
        // no-op by default.
    }

    @Override
    public void onSubscribe(Disposable d) {
        disposable = d;
    }

    @Override
    public void onNext(T t) {
        // no-op by default.
    }

    public void dispose() {
        if (disposable != null && disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
