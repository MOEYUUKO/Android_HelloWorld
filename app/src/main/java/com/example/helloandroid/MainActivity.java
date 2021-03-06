package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;        //声明变量
    private Button button2;
    private Button button4;
    private Button button7;
    private Button button9;
    private Button button10;
    private Button button12;
    private Button button14;
    private Button button13;
    private Button button16;

    private TextView textView;
    private TextView textView2;
    private TextView TextView_version;
    private TextView TextView_SDK;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView_version = (TextView)findViewById(R.id.TextView_version);
        TextView_version.setText("V"+version(this));
        TextView_SDK = (TextView)findViewById(R.id.textView_SDK);
        TextView_SDK.setText("Android "+Build.VERSION.RELEASE+"\nSDK "+Build.VERSION.SDK);

        button = (Button)findViewById(R.id.button); //绑定组件
        textView = (TextView) findViewById(R.id.textView);//绑定组件
        final String[] data={"Hello world!","你好世界!","こんにちは世界！","안녕하세요 세상!",
                                            "Hallo Welt!","Привет, мир!","สวัสดีโลก","(๑＞ڡ＜)☆"};
                                            //字符串数组

        i=1;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("变量i", String.valueOf(i));   //日志输出-检查变量
                textView.setText(data[i]);                //操作textView
                if (i==data.length-1){                    //和数组变量相同就归零 不然数组超出 软件会崩溃
                    i=0;
                }else {
                    i=i+1;
                }
            }
        });
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("新建窗口", "Main2Activity");
                Intent intent=new Intent(MainActivity.this,Main2Activity.class); //新建意图
                startActivity(intent);
            }
        });
        button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("新建窗口", "Main3Activity");
                Intent intent=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
            }
        });
        button7 = (Button)findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("新建窗口", "Main4Activity");
                Intent intent=new Intent(MainActivity.this,Main4Activity.class);
                startActivity(intent);
            }
        });
        button9 = (Button)findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("新建窗口", "ViewPagerActivity");
                Intent intent=new Intent(MainActivity.this,ViewPagerActivity.class);
                startActivity(intent);
            }
        });
        button10 = (Button)findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("新建窗口", "random");
                Intent intent=new Intent(MainActivity.this,Main6Activity.class);
                startActivity(intent);
            }
        });
        button12 = (Button)findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("新建窗口", "动画");
                Intent intent=new Intent(MainActivity.this,Main8Activity.class);
                startActivity(intent);
            }
        });
        button14 = (Button)findViewById(R.id.button14);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("新建窗口", "剪刀石头布");
                Intent intent=new Intent(MainActivity.this,Main7Activity.class);
                startActivity(intent);
            }
        });
        button16 = (Button)findViewById(R.id.button16);
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("新建窗口", "进度条");
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        button13 = (Button)findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("新建窗口", "冒泡");
                Intent intent=new Intent(MainActivity.this,Main9Activity.class);
                startActivity(intent);
            }
        });

        textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"+1S",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static String version(Context context) {  //读取软件版本号
        PackageManager manager = context.getPackageManager();
        String code = "0";
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            code = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return code;
    }

}
