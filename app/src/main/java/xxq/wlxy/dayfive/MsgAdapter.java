package xxq.wlxy.dayfive;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    List <Msg> list ;
    @Override
    public MsgAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,parent,false);
        return new ViewHolder(view);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
        public ViewHolder(View itemView) {
            super(itemView);
            leftLayout = itemView.findViewById(R.id.left_layout);
            rightLayout = itemView.findViewById(R.id.right_layout);
            leftMsg = itemView.findViewById(R.id.left_msg);
            rightMsg = itemView.findViewById(R.id.right_msg);
        }
    }

    @Override
    public void onBindViewHolder(MsgAdapter.ViewHolder holder, int position) {
            Msg msg = list.get(position);
            if(msg.getType()==Msg.TYPE_REECIVED){
                holder.leftLayout.setVisibility(View.VISIBLE);
                holder.rightLayout.setVisibility(View.GONE);
                holder.leftMsg.setText(msg.getContent());
            }else if(msg.getType()==Msg.TYPE_SENT){
                holder.rightLayout.setVisibility(View.VISIBLE);
                holder.leftLayout.setVisibility(View.GONE);
                holder.rightMsg.setText(msg.getContent());
            }
    }
    public MsgAdapter( List<Msg> list){
        this.list =list;
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}
