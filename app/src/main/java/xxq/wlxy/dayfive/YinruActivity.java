package xxq.wlxy.dayfive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class YinruActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yinru);
        getSupportActionBar().hide();// 隐藏ActionBar
    }
}
