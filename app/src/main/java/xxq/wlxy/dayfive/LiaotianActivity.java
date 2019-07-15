package xxq.wlxy.dayfive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class LiaotianActivity extends AppCompatActivity {
    private RecyclerView msg_recyler_view;
    private EditText context;
    private Button send,receive;
    List<Msg> msglist = new ArrayList<Msg>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liaotian);
        initMsgs();
        setTitle("聊天界面测试");
        msg_recyler_view = findViewById(R.id.msg_recyler_view);
        context = findViewById(R.id.input_text);
        send = findViewById(R.id.send);
        LinearLayoutManager linearLayout = new LinearLayoutManager(LiaotianActivity.this);
        msg_recyler_view.setLayoutManager(linearLayout);
        final MsgAdapter msgAdapter = new MsgAdapter(msglist);
        msg_recyler_view.setAdapter(msgAdapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contentText = context.getText().toString();
                if(!"".equals(contentText)){
                    Msg msg = new Msg(contentText,Msg.TYPE_SENT);
                    msglist.add(msg);
                    msgAdapter.notifyItemInserted(msglist.size()-1);
                    msg_recyler_view.scrollToPosition(msglist.size()-1);
                    context.setText("");
                }
            }
        });
        receive = findViewById(R.id.receive);
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contentText = context.getText().toString();
                if(!"".equals(contentText)){
                    Msg msg = new Msg(contentText,Msg.TYPE_REECIVED);
                    msglist.add(msg);
                    // 列表position位置添加一条数据时可以调用，伴有动画效果，自动刷新
                    msgAdapter.notifyItemInserted(msglist.size()-1);
                    // 跳转到指定的item
                    msg_recyler_view.scrollToPosition(msglist.size()-1);
                    context.setText("");
                }
            }
        });


    }

    private void initMsgs() {
        Msg msg = new Msg("Hello xxq.",Msg.TYPE_REECIVED);
        msglist.add(msg);
        Msg msg1 = new Msg("Hello Who is thar?",Msg.TYPE_SENT);
        msglist.add(msg1);
        Msg msg2 = new Msg("This is Tom.Nice talking to you",Msg.TYPE_REECIVED);
        msglist.add(msg2);
    }
}
