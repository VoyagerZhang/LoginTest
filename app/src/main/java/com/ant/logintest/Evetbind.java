package com.ant.logintest;

import android.text.Editable;
import android.text.TextWatcher;
import com.ant.logintest.bean.User;

/**
 * Created by Administrator on 2017/4/21.
 */

public class Evetbind {

  private User mUser;

  public Evetbind(User user) {
    mUser = user;
  }

  public TextWatcher namewatcher = new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
      mUser.user_name = s.toString().trim();
    }
  };

  public TextWatcher passwordwatcher = new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
      mUser.user_passsword = s.toString().trim();
    }
  };
}
