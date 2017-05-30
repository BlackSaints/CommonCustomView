package com.sunh.comutils.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sunh.comutils.R;

/**
 * 顶部导航栏功能
 * Created by sunh on 2017/5/29/029.
 */

public class TopBarUtils extends LinearLayout{

    private String TOPBGCOLOR = "#5677fc";
    private String TEXTDEFAULTCOLIR = "#ffffff";
    private Context context;
    private int topBgColor;
    private int leftBtnBg;
    private String leftBtnText;
    private int leftBtnSize;
    private int leftBtnColor;
    private String centerText;
    private int centerTextSize;
    private int centerTextColor;
    private String rightText;
    private int rightTextSize;
    private int rightTextColor;
    private int rightBtnBg1;
    private int rightBtnBg2;
    private int rightBtnBg3;
    private TextView tv_left_button;
    private TextView tv_left_text;
    private TextView tv_center_title;
    private TextView tv_right_text;
    private ImageView ib_right_bg1;
    private ImageView ib_right_bg2;
    private ImageView ib_right_bg3;
    private RelativeLayout lay_top;

    private TopBarClickListener listener;
    public TopBarUtils(Context context) {
        this(context,null);
    }


    public TopBarUtils(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public TopBarUtils(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.topbar_view,this,true);
        tv_left_button = (TextView) findViewById(R.id.tv_left_button);
        tv_left_text = (TextView) findViewById(R.id.tv_left_text);
        tv_center_title = (TextView) findViewById(R.id.tv_center_title);
        tv_right_text = (TextView) findViewById(R.id.tv_right_text);
        ib_right_bg1 = (ImageView) findViewById(R.id.ib_right_bg1);
        ib_right_bg2 = (ImageView) findViewById(R.id.ib_right_bg2);
        ib_right_bg3 = (ImageView) findViewById(R.id.ib_right_bg3);
        lay_top = (RelativeLayout) findViewById(R.id.lay_top);

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.TopBarUtils);
        topBgColor = typedArray.getColor(R.styleable.TopBarUtils_top_bg, Color.parseColor(TOPBGCOLOR));

        leftBtnBg = typedArray.getResourceId(R.styleable.TopBarUtils_left_btn_bg, R.drawable.left_btn_bg);
        leftBtnText = typedArray.getString(R.styleable.TopBarUtils_left_btn_text);
        leftBtnSize = (int) typedArray.getDimension(R.styleable.TopBarUtils_left_btn_text_size, 16);
        leftBtnColor = typedArray.getColor(R.styleable.TopBarUtils_left_btn_text_color, Color.parseColor(TEXTDEFAULTCOLIR));
        centerText = typedArray.getString(R.styleable.TopBarUtils_center_title_text);

        centerTextSize = (int) typedArray.getDimension(R.styleable.TopBarUtils_center_title_text_size, 20);
        centerTextColor = typedArray.getColor(R.styleable.TopBarUtils_center_title_text_color, Color.parseColor(TEXTDEFAULTCOLIR));

        rightText = typedArray.getString(R.styleable.TopBarUtils_right_btn_text);
        rightTextSize = (int) typedArray.getDimension(R.styleable.TopBarUtils_right_btn_text_size,16);
        rightTextColor = typedArray.getColor(R.styleable.TopBarUtils_right_btn_text_color, Color.parseColor(TEXTDEFAULTCOLIR));

        rightBtnBg1 = typedArray.getResourceId(R.styleable.TopBarUtils_right_btn1_bg, R.drawable.left_btn_bg);
        rightBtnBg2 = typedArray.getResourceId(R.styleable.TopBarUtils_right_btn2_bg, R.drawable.left_btn_bg);
        rightBtnBg3 = typedArray.getResourceId(R.styleable.TopBarUtils_right_btn3_bg, R.drawable.left_btn_bg);

        tv_left_text.setText(leftBtnText);
        tv_left_text.setTextSize(leftBtnSize);
        tv_left_text.setTextColor(leftBtnColor);
        tv_left_button.setBackgroundResource(leftBtnBg);
        tv_center_title.setText(centerText);
        tv_center_title.setTextSize(centerTextSize);
        tv_center_title.setTextColor(centerTextColor);

        tv_right_text.setText(rightText);
        tv_right_text.setTextSize(rightTextSize);
        tv_right_text.setTextColor(rightTextColor);

        ib_right_bg1.setBackgroundResource(rightBtnBg1);
        ib_right_bg2.setBackgroundResource(rightBtnBg2);
        ib_right_bg3.setBackgroundResource(rightBtnBg3);
        lay_top.setBackgroundColor(topBgColor);

        tv_left_text.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onLeftClick();
            }
        });

        tv_right_text.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRightClck();
            }
        });
    }

    public void setTopBarClickListener(TopBarClickListener listener){
        this.listener = listener;
    }

    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     */
    public int px2dip(float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     */
    public int dip2px(float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     */
    public int px2sp(float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     */
    public int sp2px(float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 设置监听接口
     */
    public interface TopBarClickListener {
        void onLeftClick();

        void onRightClck();
    }
}
