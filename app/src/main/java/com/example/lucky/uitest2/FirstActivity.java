package com.example.lucky.uitest2;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;


public class FirstActivity extends Activity {
    private Button bt_new,bt_exit,bt_myprofile,bt_browse;
    private int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        bt_new = (Button)findViewById(R.id.bt_start_new);
        bt_exit = (Button)findViewById(R.id.bt_exit_app);
        bt_myprofile = (Button)findViewById(R.id.bt_my_profile);
        bt_browse = (Button)findViewById(R.id.bt_browse_services);
        bt_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,NewServiceLogActivity.class);
                startActivity(intent);
            }
        });
        bt_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i += 1;
                if (i <= 1){
                    Toast.makeText(FirstActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
                }
                else {
                    i = 0;
                    finish();
                }
            }
        });
        bt_myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "个人信息", Toast.LENGTH_SHORT).show();
            }
        });
        bt_browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "浏览服务信息", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
