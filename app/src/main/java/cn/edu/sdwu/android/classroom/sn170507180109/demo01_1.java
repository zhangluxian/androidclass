package cn.edu.sdwu.android.classroom.sn170507180109;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class demo01_1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo01_style1);
        RadioGroup radioGroup=(RadioGroup) findViewById(R.id.demo01_1);//找到事件源
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                //第2个参数代表当前选中的radiobutton的ID
                RadioButton radioButton=(RadioButton) findViewById(i);
                Object object=radioButton.getTag();
                TextView textView=(TextView) findViewById(R.id.demo01_2);
                if(object!=null&&object.toString().equals("1")){
                    textView.setText("right");
                }else{
                    textView.setText("wrong");
                }
            }
        });//设置监听器
    }


}