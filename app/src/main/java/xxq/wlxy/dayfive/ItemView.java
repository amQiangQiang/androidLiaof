package xxq.wlxy.dayfive;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ItemView extends RelativeLayout {

    private ImageView img;
    private TextView tv_lefttitle;
    private TextView tv_righttitle;
    public interface topbarClickListener{
        void leftBtnClick();
        void rightBtnClick();
    }

    private topbarClickListener listener;

    public void setTopbarClickListener(topbarClickListener ls){
        this.listener = ls;
    }
    public ItemView(Context context, AttributeSet attrs) {
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.activity_relative,this);
        tv_lefttitle = findViewById(R.id.tv_lefttitle);
        tv_righttitle = findViewById(R.id.tv_righttitle);
        img = findViewById(R.id.img);
        TypedArray typedArray =  context.obtainStyledAttributes(attrs,R.styleable.ItemView);
        String leftName = typedArray.getString(R.styleable.ItemView_leftName);
        String rightName = typedArray.getString(R.styleable.ItemView_rightName);
        boolean imgFlag = typedArray.getBoolean(R.styleable.ItemView_imgFlag,false);
        setView(leftName,rightName,imgFlag);
        typedArray.recycle();
        tv_lefttitle.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                listener.leftBtnClick();
            }
        });


        tv_righttitle.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                listener.rightBtnClick();
            }
        });
    }

    public void setView(String leftTitle,String rightTitle,boolean flag){
            if (leftTitle!=null)
                tv_lefttitle.setText(leftTitle);
            if(rightTitle!=null)
                tv_righttitle.setText(rightTitle);
            if(flag)
                img.setVisibility(View.VISIBLE);
            else
                img.setVisibility(View.GONE);
    }

}
