package lqf.com.pulldownchoosebutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class PullDownSelectionButton extends RelativeLayout  {
    private Context context;
    private SpinnerAdapter mAdapter;
    private SpinnerPopWindow mSpinerPopWindow;
    private View viewGroup;
    private TextView button;
    private List<String> mItems;
    OnItemSelectedListener listener;

    public PullDownSelectionButton(Context context) {
        this(context,null);
    }

    public PullDownSelectionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        initView(context,attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
         viewGroup = LayoutInflater.from(context).inflate(R.layout.pull_down_selection_button,this,true);
         LinearLayout linearLayout= viewGroup.findViewById(R.id.ll_layout);
         button = viewGroup.findViewById(R.id.bt_text);
         TypedArray typedArray= context.obtainStyledAttributes(attrs,R.styleable.PullDownSelectionButton);
         String ss= typedArray.getString(R.styleable.PullDownSelectionButton_text);
         int color=typedArray.getColor(R.styleable.PullDownSelectionButton_buttonTextColor,Color.parseColor("#ff00ff"));
         int backGround= typedArray.getResourceId(R.styleable.PullDownSelectionButton_background,R.drawable.bt_background);
         int btnTextSize  =typedArray.getDimensionPixelSize(R.styleable.PullDownSelectionButton_textSize,0);
        int btnTextWith  =typedArray.getDimensionPixelSize(R.styleable.PullDownSelectionButton_buttonWidth,LayoutParams.WRAP_CONTENT);
        int btnTextHeight  =typedArray.getDimensionPixelSize(R.styleable.PullDownSelectionButton_buttonHeight,LayoutParams.WRAP_CONTENT);
        if (btnTextSize != 0) {
            button.setTextSize(TypedValue.COMPLEX_UNIT_PX, btnTextSize);
        }
         button.setLayoutParams(new LinearLayout.LayoutParams(btnTextWith,btnTextHeight));
         button.setTextColor(color);
        if (!TextUtils.isEmpty(ss)){
            button.setText(ss);
        }
        linearLayout.setBackgroundResource(backGround);
        linearLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startPopWindow();
            }
        });
        typedArray.recycle();
    }

        public void setData(List<String> datas){
            mItems = datas;
            if (mItems!=null&&mItems.size()>0){
                button.setText(mItems.get(0));
            }
        }

    public void setOnItemSelectedListener(OnItemSelectedListener listener){
        this.listener = listener;
    }

    public void startPopWindow(){
        mAdapter = new SpinnerAdapter(context);
        mAdapter.refreshData(mItems, 0);
        mSpinerPopWindow = new SpinnerPopWindow(context);
        mSpinerPopWindow.setAdatper(mAdapter);
        mSpinerPopWindow.setItemListener(new OnItemSelectedListener(){
            @Override
            public void onItemSelected(int pos) {
                // TODO Auto-generated method stub
//                bt_dropdown.setBackgroundResource(R.drawable.down_arrow);
                button.setText(mItems.get(pos));
                listener.onItemSelected(pos);
            }
        });
        showSpinWindow();
    }

    private void showSpinWindow(){
        mSpinerPopWindow.setWidth(viewGroup.getWidth());
        mSpinerPopWindow.showAsDropDown(viewGroup);
    }

    public interface OnItemSelectedListener {
        void onItemSelected(int pos);
    }
}
