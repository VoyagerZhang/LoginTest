package com.ant.logintest.presenter;

import com.ant.logintest.model.MainModelBean;

/**
 * Created by Administrator on 2017/4/19.
 * 作用是连接 model
 */

public interface CMainPresenter {
  // 参数；1.bean 对象
  void loadDataSuccess(MainModelBean mainModelBean);
  void loadDataFailure();

}
