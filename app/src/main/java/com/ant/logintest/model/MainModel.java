package com.ant.logintest.model;

import android.os.SystemClock;
import com.ant.logintest.bean.User;

/**
 * Created by Administrator on 2017/4/19. 具体处理，包括存储，检索，操做数据等
 */

public class MainModel {


  public boolean getInfoAndTryLogin(User user) {
    SystemClock.sleep(2000);   // 模拟从网络请求数据
    MainModelBean bean = new MainModelBean();
    bean.setName("123");
    bean.setPassword("123");
    // 参数；1.bean 对象  数据封入bean对象中
    //mCMainPresenter.loadDataSuccess(bean);
    String name = bean.getName();
    String password = bean.getPassword();

    // 登陆判断
    if (name.equals(user.user_name) && password.equals(user.user_passsword)) {
      return true;
    } else {
      return false;
    }

  }


}
