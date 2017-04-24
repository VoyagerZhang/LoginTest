package com.ant.logintest.ui;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.ant.logintest.Evetbind;
import com.ant.logintest.R;
import com.ant.logintest.bean.User;
import com.ant.logintest.databinding.ActivityMainBinding;
import com.ant.logintest.presenter.MainPresenter;
import com.ant.logintest.view.MainView;
import dalvik.system.BaseDexClassLoader;


public class MainActivity extends AppCompatActivity implements MainView {

  private EditText name;
  private EditText password;
  private Button login;
  private MainPresenter mMainPresenter;
  private String username;
  private String user_password;
  private ProgressDialog mProgressDialog;
  private User user;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//    setContentView(R.layout.activity_main);
//    initview();
//    onclick();
    Handler handler = new Handler();

    mProgressDialog = new ProgressDialog(this);
    mMainPresenter = new MainPresenter(this);
    ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    user = new User();
    Evetbind event = new Evetbind(user);
    binding.setEvent(event);

  }

//  private void initview() {
//    name = (EditText) findViewById(R.id.name);
//    password = (EditText) findViewById(R.id.password);
//    login = (Button) findViewById(R.id.login);
//

//  }

  public void login(View view) {
    // 判断是否为空
    boolean flag = mMainPresenter.notNull(user);
    // 不为空时，执行登陆
    if (flag) {
      mProgressDialog.show();
      mMainPresenter.login(user);    // 1.第一步
    } else {
      Toast.makeText(MainActivity.this, "账号或密码为空", Toast.LENGTH_SHORT).show();
    }
  }
//  public OnClickListener  oc;
// Button button.setOnClickListene(OnClickListener oc);
//  // 点击事件
//  private void onclick() {
//    login.setOnClickListener(new OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        username = name.getText().toString().trim();
//        user_password = password.getText().toString().trim();
//        User user = new User();
//        user.user_name = username;
//        user.user_passsword = user_password;
//        // 判断是否为空
//        boolean flag = mMainPresenter.notNull(user);
//        // 不为空时，执行登陆
//        if (flag) {
//          mProgressDialog.show();
//          mMainPresenter.login(user);    // 1.第一步
//        }else {
//          Toast.makeText(MainActivity.this, "账号或密码为空", Toast.LENGTH_SHORT).show();
//        }
//      }
//    });


  @Override  // 5. 第五部
  public void loginSuccess() {
    runOnUiThread(new Runnable() {  // 6. 第六步
      @Override
      public void run() {
        mProgressDialog.dismiss();  // 7. 第七步
        Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
      }
    });
  }

  @Override
  public void loginError() {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        mProgressDialog.dismiss();
        Toast.makeText(MainActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
      }
    });
  }

//  @Override
//  public void login(MainModelBean mainModelBean) {
//    String name = mainModelBean.getName();
//    String password = mainModelBean.getPassword();
//
//    if (username.equals(name) && password.equals(user_password)) {
//      Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
//    } else {
//      Toast.makeText(this, "密码或账户错误", Toast.LENGTH_SHORT).show();
//    }
//
//  }
}
