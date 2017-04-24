package com.ant.logintest.presenter;

import android.text.TextUtils;
import com.ant.logintest.model.MainModel;
import com.ant.logintest.bean.User;
import com.ant.logintest.view.MainView;

/**
 * Created by Administrator on 2017/4/19.
 * view 和 model层的桥梁，从model层获得数据后，返给view层。
 */

public class MainPresenter {

  private MainView mMainView;

  public MainPresenter(MainView mainView) {
    mMainView = mainView;
  }

  // 判断输入的账号和密码是否为空
  public boolean notNull(User user){
    if (TextUtils.isEmpty(user.user_name)||TextUtils.isEmpty(user.user_passsword)){
      return false;
    }else {
      return true;
    }
  }

  // 登陆方法，第二步
  public void login(final User user){
    new Thread(){
      @Override
      public void run() {
        MainModel model = new MainModel();  // 3.第三步
        if (model.getInfoAndTryLogin(user)){  // 4.第四步
          // 成功时，回调
          mMainView.loginSuccess();
        }else {
          // 失败时，回调
          mMainView.loginError();
        }
      }
    }.start();
  }

//  @Override
//  public void attachView(MainView view) {
//    this.mMainView = view;
//  }
//
//  @Override
//  public void detachView() {
//    this.mMainView = null;
//  }

//  @Override
//  public void loadDataSuccess(MainModelBean mainModelBean) {
//    mMainView.login(mainModelBean);
//  }
//
//  @Override
//  public void loadDataFailure() {
//
//  }

}
