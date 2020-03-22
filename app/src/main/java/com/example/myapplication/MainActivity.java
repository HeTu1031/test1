package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "MainActivity");
        Button loginbutton=(Button) findViewById(R.id.loginbutton);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account,password;
                EditText accountedit= (EditText) findViewById(R.id.accountedit);//根据ID找到对象
                account=accountedit.getText().toString();//拿到输入值
                EditText passwordedit= (EditText) findViewById(R.id.passwordedit);
                password=passwordedit.getText().toString();
                CheckBox agree=(CheckBox)findViewById(R.id.agree);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);//弹出框
                if(account.equals("")||password.equals("")){
                    builder.setTitle("登录失败");
                    builder.setMessage("输入不可为空");
                }else if(!agree.isChecked()){
                    builder.setTitle("登录失败");
                    builder.setMessage("请阅读并同意用户须知");
                }else{
                    builder.setTitle("登录成功");
                    String me="欢迎用户"+account+"登录";
                    builder.setMessage(me);
                    Log.v("MainActivity",me);//输出日志
                }
                builder.show();
            }
        });
    }
}
