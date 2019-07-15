package xxq.wlxy.dayfive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<Fruit> list = new ArrayList<Fruit>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recler_view);
        initFruits();
        recyclerView = findViewById(R.id.recl_1);
       // LinearLayoutManager layoutManager = new LinearLayoutManager(ReclerViewActivity.this);
        //水平布局默认垂直布局
      //  layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //网格布局
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        FruitAdapterView fruitAdapterView = new FruitAdapterView(list);
        fruitAdapterView.setOnItemClick(new FruitAdapterView.OnItemClick() {
            @Override
            public void onItemClick(int pos) {
                Toast.makeText(ReclerViewActivity.this, pos+"", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextClick() {

            }
        });
        recyclerView.setAdapter(fruitAdapterView);
    }
    private void initFruits() {
        for (int i =0;i<50;i++){
            Fruit fruit = new Fruit();
//            Random random = new Random();
//            int len = random.nextInt(20)+1;
//            StringBuffer stringBuffer = new StringBuffer();
//            for (int j=0;j<len;j++)
//                stringBuffer.append("小黄人西瓜");
//            fruit.setName(stringBuffer.toString());
            fruit.setName("西瓜黄人类型");
            fruit.setImg(R.mipmap.fruit);
            list.add(fruit);
        }
    }
}
