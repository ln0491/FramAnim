package com.ghg.framanim.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.ghg.framanim.R;

/**
 * @Description: 描述
 * @AUTHOR 刘楠  Create By 2016/11/9 0009 16:48
 */
public class CustomProgressDialog extends Dialog {

    private ImageView mIvProgress;
    private TextView mTvMessage;

    public CustomProgressDialog(Context context) {
        super(context, R.style.CustomProgressDialog);
    }

    public CustomProgressDialog(Context context, int themeResId) {
        super(context,  R.style.CustomProgressDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_progress_dialog);
        initView();
        initPro();

    }


    private void initView() {

        mIvProgress = (ImageView) findViewById(R.id.ivProgress);

        mTvMessage = (TextView) findViewById(R.id.tvMessage);



    }
    private void initPro() {
        getWindow().getAttributes().gravity = Gravity.CENTER;
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        // 设置背景层透明度
        lp.dimAmount = 0.2f;
        getWindow().setAttributes(lp);
        this.setCancelable(true);
        this.setCanceledOnTouchOutside(false);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //获取 ImageView上的帧动画
        AnimationDrawable animationDrawable = (AnimationDrawable) mIvProgress.getBackground();
        //开始播放
        animationDrawable.start();
    }
    /**
     * 给Dialog设置提示信息
     *
     * @param message
     */
    public void setMessage(CharSequence message) {
        if(message != null && message.length() > 0) {

            mTvMessage.setText(message);
            mTvMessage.invalidate();
        }
    }


    public void show() {
        if (!isShowing() && getContext() != null) {
            super.show();
        }
    }

    /**
     * 弹出自定义ProgressDialog
     *
     * @param context
     *            上下文
     * @param
     *
     * @param
     *
     * @param
     *
     * @return
     */
    public static CustomProgressDialog show(Context context) {
        CustomProgressDialog dialog = new CustomProgressDialog(context,
                R.style.CustomProgressDialog);
        dialog.setTitle("");
        dialog.setContentView(R.layout.custom_progress_dialog);
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        // 设置背景层透明度
        lp.dimAmount = 0.2f;
        dialog.getWindow().setAttributes(lp);
        dialog.show();
        return dialog;
    }
}
