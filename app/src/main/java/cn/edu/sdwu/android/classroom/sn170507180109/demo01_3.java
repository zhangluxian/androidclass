package cn.edu.sdwu.android.classroom.sn170507180109;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
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
    public void notification(View view){
        Notification.Builder builder=new Notification.Builder(this);
        //在构造器中，完成通知各种属性的设置
        builder.setContentTitle("title");
        builder.setContentText("message");
        builder.setWhen(System.currentTimeMillis());
        builder.setSmallIcon(android.R.drawable.ic_input_delete);//引用系统资源


        Intent intent=new Intent(this,demo01_4.class);//点击通知之后，跳转界面
        PendingIntent pendingintent=PendingIntent.getActivity(this,101,intent,PendingIntent.FLAG_CANCEL_CURRENT);//这个类代表代办的Intent
        builder.setContentIntent(pendingintent);
        //调用build方法，完成构造
        Notification notification=builder.build();
        //使用Notification，发送通知
        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(101,notification);

    }
    public void cancel_notification(View view){
        //使用Notification，发送通知
        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(101);
    }
    public void alert_dialog(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //在构造器中 设置对话框属性
        builder.setTitle("title");
        builder.setMessage("message");
        builder.setIcon(android.R.drawable.ic_dialog_email);
        builder.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //添加点击按键后的处理
                Toast.makeText(demo01_3.this,"confirm",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(demo01_3.this,"exit",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(demo01_3.this,"cancel",Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();

    }
}
