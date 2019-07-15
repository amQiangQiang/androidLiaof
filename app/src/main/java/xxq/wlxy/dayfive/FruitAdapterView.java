package xxq.wlxy.dayfive;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapterView extends RecyclerView.Adapter<FruitAdapterView.ViewHolder>  {
   private List<Fruit> list;
   private OnItemClick onItemClick;



    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView fritimg;
        TextView fruitname;
        public ViewHolder(View view){
            super(view);
            fritimg = view.findViewById(R.id.fruit_img);
            fruitname = view.findViewById(R.id.fruit_name);
        }
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public FruitAdapterView(List<Fruit> fruitList){
        list = fruitList;
    }
    @Override
    public FruitAdapterView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FruitAdapterView.ViewHolder holder, int position) {
        Fruit fruit = list.get(position);
        //获取position
        holder.getAdapterPosition();
        //为每个item设置position
        holder.itemView.setTag(position);
        //为每个item设置单击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onItemClick((Integer) v.getTag());
            }
        });
        holder.fritimg.setImageResource(fruit.getImg());
        holder.fruitname.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public interface  OnItemClick{
        void onItemClick(int pos);
        void onTextClick();
    }
}
