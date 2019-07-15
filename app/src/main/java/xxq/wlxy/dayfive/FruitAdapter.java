package xxq.wlxy.dayfive;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resource;
    public FruitAdapter(@NonNull Context context, int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        ViewHolder viewHolder;
        //convertView复用机制   当首次加载会根据屏幕的大小加载相应的多个的item  当手
        //去滑动的时候  上部的item将被遮挡  下部的item将会显示
        //这时候的android系统就面临 是回收item还是缓存起来   这里的convertView就是复用机制
        //当滑动下面的item的时候  就会去复用相应的item  不保证顺序复用  随机复用  但是总是会依次复用完的
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(resource,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.fruit_img = convertView.findViewById(R.id.fruit_img);
            viewHolder.fruit_name = convertView.findViewById(R.id.fruit_name);
            convertView.setTag(viewHolder);//将viewHolder存储在convertView中
            Log.d("wlxy" + position, "创建新convertView,设置tagId:"+viewHolder.toString());


        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();//从convertView取出viewHolder进行复用
            Log.d("wlxy" + position, "复用:"+viewHolder.toString());
        }
        viewHolder.fruit_img.setImageResource(fruit.getImg());
        viewHolder.fruit_name.setText(fruit.getName());
        return convertView;
    }
    class ViewHolder{
        ImageView fruit_img;
        TextView fruit_name;
    }
}
