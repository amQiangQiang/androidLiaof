package xxq.wlxy.dayfive;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_zidingyi,btn_yinru,listview1,reclerview,liaotian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCollector.addActivity(this);
        btn_zidingyi = findViewById(R.id.btn_zidingyi);
        btn_zidingyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ItemActivity.class);
                startActivity(intent);
                Log.d("", "onClick: ");
            }
        });
        btn_yinru = findViewById(R.id.btn_yinru);
        btn_yinru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,YinruActivity.class);
                startActivity(intent);
                Log.d("", "onClick: ");
            }
        });
        listview1= findViewById(R.id.listview11);
        listview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,ListViewTestActivity.class);
                startActivity(intent);
                Log.d("", "onClick: ");
            }
        });
        reclerview = findViewById(R.id.reclerView);
        reclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ReclerViewActivity.class);
                startActivity(intent);
                Log.d("", "onClick: ");
            }
        });
        liaotian = findViewById(R.id.liaotian);
        liaotian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LiaotianActivity.class);
                startActivity(intent);
                Log.d("", "onClick: ");
            }
        });
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.add_item:
               Intent intent = new Intent(Intent.ACTION_VIEW);
               intent.setData(Uri.parse("tel:10086"));
               startActivity(intent);
               break;
           case  R.id.remove_item:
               Toast.makeText(this, "clickmove...", Toast.LENGTH_SHORT).show();
               break;
       }
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
