package cn.edu.sdwu.android.classroom.sn170507180109;

import android.app.WallpaperManager;
import android.content.Intent;
import android.media.MediaCodec;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.R.attr.button;

public class demo01 extends AppCompatActivity implements View.OnFocusChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载界面,不要写文件名，使用资源ID来引用资源
        setContentView(R.layout.demo01_style);
        //1).获取普遍界面组件:必须在setCountentView之后，调用findViewById方法
        Button button = (Button) findViewById(R.id.button1);
        ImageView imageView=(ImageView)findViewById(R.id.demo_mg);
        //3).调用事件源的set.XXXListener方法
        button.setOnClickListener(new MyClickListener());

        //3.使用内部匿名类注册监听器
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
               //设置壁纸（调用API）
                WallpaperManager wallpaperManager=(WallpaperManager) getSystemService(WALLPAPER_SERVICE);
               try{
                   wallpaperManager.setResource(R.raw.mg1);
               }catch (Exception e){
                   Log.e(demo01.class.toString(),e.toString());
               }

                return true;
            }
        });
        //坐标显示
        EditText email=(EditText) findViewById(R.id.demo_1_email);
         email.setOnFocusChangeListener(this);
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.demo_1_11);
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float x=motionEvent.getX();
                float y=motionEvent.getY();
                TextView textview=(TextView)findViewById(R.id.demo_1_tv);
                textview.setText("x:"+x+",y:"+y);
                return true;
            }
        });
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        //参数b代表是否获取焦点
        //判断邮箱地址的合法性
        EditText editText=(EditText)view;
        if(!b){
            String content=editText.getText().toString();//得到EditText的内容
            //判断邮箱地址的正确表达式
            String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern pattern=Pattern.compile(regEx1);
            Matcher matcher=pattern.matcher(content);
            TextView textView=(TextView)findViewById(R.id.demo_1_tv);
            if(matcher.matches()){
                textView.setText("");
            }else{
                textView.setText("email invalidate");
            }
        }
    }

    //2).实现事件监听类,该监听类是一个特殊的java类，必须实现一个XXXlistener接口
  class MyClickListener implements View.OnClickListener{

    @Override
    public void onClick(View view) {

        Log.i(demo01.class.toString(),"button click");
    }
  }
   public void  startMain(View view){
       //界面跳转
       Intent intent=new Intent(this,MainActivity.class);
       startActivity(intent);
   }
}
