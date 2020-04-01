package cn.edu.sdwu.android.classroom.sn170507180109;

import android.app.WallpaperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static android.R.attr.button;

public class demo01 extends AppCompatActivity {

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


    }
       //2).实现事件监听类,该监听类是一个特殊的java类，必须实现一个XXXlistener接口
  class MyClickListener implements View.OnClickListener{

    @Override
    public void onClick(View view) {
      Log.i(demo01.class.toString(),"button click");
    }
  }
}
