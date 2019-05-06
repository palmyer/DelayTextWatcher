package com.palmy.delaytextwatcher;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * 输入间隔小于一定时间(500ms)则不执行回调的TextWatcher
 *
 * @author palmy
 * @date 2018/6/1
 */

public class DelayTextWatcher implements TextWatcher {
    private static final String TAG = "DelayTextWatcher";
    /**
     * 输入延时生效时间(ms)
     */
    private static final int DELAY = 500;
    private Disposable mDisposable;
    private SearchCallback mCallback;

    public DelayTextWatcher(SearchCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //取消订阅
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }

    @Override
    public void afterTextChanged(final Editable s) {
        //延时(delay ms)后回调内容，如果取消了订阅则停止此次回调
        Observable.just(s.toString())
                .delay(DELAY, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(String value) {
                        mCallback.getKeywords(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, e.getCause() + "," + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface SearchCallback {
        /**
         * 获取EditText内容的回调
         *
         * @param keywords 关键字
         */
        void getKeywords(String keywords);
    }
}
