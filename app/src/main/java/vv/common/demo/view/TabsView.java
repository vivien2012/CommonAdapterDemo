package vv.common.demo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import vv.common.demo.R;
import vv.common.demo.ui.MainActivity;

/**
 * Created by vivien on 16/10/25.
 */
public class TabsView extends LinearLayout {


    TextView tab_left;

    TextView tab_right;

    OnTabChangeListener mOnTabChangeListener;

    private OnClickListener onLeftClickListener;
    private OnClickListener onRightClickListener;

    public TabsView(Context context) {
        super(context);
        init(context);
    }

    public TabsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TabsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {
        View.inflate(context, R.layout.activity_tabs_view, this);
        this.setClipChildren(false);
        tab_left = (TextView) findViewById(R.id.tab_left);
        tab_right = (TextView) findViewById(R.id.tab_right);
        initListener();
        tab_left.setOnClickListener(onLeftClickListener);
        tab_right.setOnClickListener(onRightClickListener);
    }

    private void initListener() {
        onLeftClickListener = new OnClickListener() {
            @Override
            public void onClick(View view) {
                tab_left.setTextColor(getResources().getColor(android.R.color.holo_blue_light));
                tab_right.setTextColor(getResources().getColor(android.R.color.darker_gray));
                if (mOnTabChangeListener != null) {
                    mOnTabChangeListener.onTabSelect(MainActivity.TAB_LEFT_INDEX);
                }
            }
        };

        onRightClickListener = new OnClickListener() {
            @Override
            public void onClick(View view) {
                tab_left.setTextColor(getResources().getColor(android.R.color.darker_gray));
                tab_right.setTextColor(getResources().getColor(android.R.color.holo_blue_light));
                if (mOnTabChangeListener != null) {
                    mOnTabChangeListener.onTabSelect(MainActivity.TAB_RIGHT_INDEX);
                }
            }
        };
    }

    public interface OnTabChangeListener {
        void onTabSelect(int index);
    }


    public void setOnTabChangeListener(OnTabChangeListener mOnTabChangeListener) {
        this.mOnTabChangeListener = mOnTabChangeListener;
    }
}
