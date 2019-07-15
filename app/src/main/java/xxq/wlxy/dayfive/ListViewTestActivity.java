package xxq.wlxy.dayfive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewTestActivity extends AppCompatActivity {
    private List<Fruit> list = new ArrayList<Fruit>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
       initFruits();
        FruitAdapter fruitAdapter = new FruitAdapter(ListViewTestActivity.this,R.layout.fruit_item,list);
        ListView listView = findViewById(R.id.lv_1);
        listView.setAdapter(fruitAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewTestActivity.this, list.get(position).toString(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void initFruits() {
        for (int i =0;i<50;i++){
            Fruit fruit = new Fruit();
            fruit.setName("黄人西瓜");
            fruit.setImg(R.mipmap.fruit);
            list.add(fruit);
        }
    }
}
