package xxq.wlxy.dayfive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ActivityCollector.addActivity(this);
        setContentView(R.layout.activity_item);
        ItemView itemView1 = findViewById(R.id.re_1);
        ItemView itemView2 = findViewById(R.id.re_2);
        ItemView itemView3 = findViewById(R.id.re_3);
        itemView1.setTopbarClickListener(new ItemView.topbarClickListener() {
            @Override
            public void leftBtnClick() {
                ActivityCollector.finishAll();
                //killprocess杀死当前进程
                android.os.Process.killProcess(android.os.Process.myPid());
            }

            @Override
            public void rightBtnClick() {
                Toast.makeText(ItemActivity.this, "ddr", Toast.LENGTH_SHORT).show();
            }
        });
//        itemView1.setView("年龄","18",true);
//        itemView2.setView("地址","重庆文理学院",false);
//        itemView3.setView("状态","",true);
    }

}
