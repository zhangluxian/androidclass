package cn.edu.sdwu.android.classroom.sn170507180109;

import android.app.NotificationManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class demo01_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo01_style4);
        //在JAVA中获取字符串资源
        String content=getString(R.string.hello);
        Log.i(demo01_4.this.toString(),content);


        String sms=getString(R.string.sms);
        sms=String.format(sms,100,"张三");
        Log.i(demo01_4.this.toString(),sms);
        //获取数组资源
        Resources resourcces=getResources();
        int[] intArr=resourcces.getIntArray(R.array.intArr);
        for(int i=0;i<intArr.length;i++){
            Log.i(demo01_4.this.toString(),intArr[i]+"");
        }
        //字符串数组
        String[] strArr=resourcces.getStringArray(R.array.strArr);
        for (int i=0;i<strArr.length;i++){

            Log.i(demo01_4.this.toString(),strArr[i]+"");
        }
        //获取普通类型的 数组
        TypedArray typedArray=resourcces.obtainTypedArray(R.array.commanArr);
        ImageView imageView=(ImageView)findViewById(R.id.demo01_4_iv);
        int resId=typedArray.getResourceId(0,0);
        imageView.setImageResource(resId);

        String str=typedArray.getString(1);
        Log.i(demo01_4.this.toString(),str);
        //注册上下文菜单
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.demo01_4_11);
        registerForContextMenu(linearLayout);

         XmlPullParser xmlPullParser=resourcces.getXml(R.xml.words);
        try {
            while (xmlPullParser.getEventType()!=XmlPullParser.END_DOCUMENT){
                if (xmlPullParser.getEventType()==XmlPullParser.START_TAG){
                    //判断一下是否是word元素（words直接跳过）
                    if(xmlPullParser.getName().equals("word")){
                        String word=xmlPullParser.getAttributeValue(0);
                        Log.i(demo01_4.class.toString(),word);

                    }
                }
                xmlPullParser.next();
            }
        }catch (Exception e){
            Log.e(demo01_4.class.toString(),e.toString());
        }
        //使用NotificationManager取消通知
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(101);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //记载自定义菜单资源
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.mymenu1,menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.mymenu_item1:
                Toast.makeText(this,"item1",Toast.LENGTH_SHORT).show();
            case R.id.mymenu_item2:
                Toast.makeText(this,"item2",Toast.LENGTH_SHORT).show();
            case R.id.mymenu_item3:
                Toast.makeText(this,"item3",Toast.LENGTH_SHORT).show();
                break;
    }
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //基于回调事件处理
        //根据菜单项的ID进行区分
        switch(item.getItemId()){
            case R.id.mymenu_item1:
                Toast.makeText(this,"item1",Toast.LENGTH_SHORT).show();
            case R.id.mymenu_item2:
                Toast.makeText(this,"item2",Toast.LENGTH_SHORT).show();
            case R.id.mymenu_item3:
                Toast.makeText(this,"item3",Toast.LENGTH_SHORT).show();
                break;
        }
       return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载自定义的菜单资源
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.mymenu1,menu);
        return true;
    }
}