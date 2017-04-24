package com.ant.logintest.presenter;

/**
 * Created by Administrator on 2017/4/19.
 */

public interface Presenter<V> {

  void attachView(V view);

  void detachView();

}
