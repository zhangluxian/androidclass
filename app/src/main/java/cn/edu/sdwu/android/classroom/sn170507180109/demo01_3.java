package cn.edu.sdwu.android.classroom.sn170507180109;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class demo01_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo01_style3);
    }
    public void toast1(View view){
        Toast.makeText(this,"toast1",Toast.LENGTH_SHORT).show();
    }
    public void toast2(View view){
        Toast toast=Toast.makeText(this,"toast2",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

    }
    public void toast3(View view){
        //加载自定义布局文件，将其转换为一个View类的实力
        LayoutInflater layoutInflater=getLayoutInflater();
        View view1=layoutInflater.inflate(R.layout.demo01_4,null);
        //设置文本
        TextView textView=(TextView)view1.findViewById(R.id.toast_tv);
        textView.setText("toast3");

        Toast toast=new Toast(this);
        toast.setView(view1);//设置界面
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();


    }
}
