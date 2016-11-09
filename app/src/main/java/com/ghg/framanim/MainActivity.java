package com.ghg.framanim;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ghg.framanim.dialog.CustomProgressDialog;
import com.ghg.framanim.dialog.MsProgressDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnShow;
    private Button mBtnHide;
    private ImageView mIv;
    private AnimationDrawable mAnimationDrawable;
    private CustomProgressDialog mCpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
    }




    private void initView() {

        mBtnShow = (Button) findViewById(R.id.btnShow);
        mBtnHide = (Button) findViewById(R.id.btnHide);
        mIv = (ImageView) findViewById(R.id.iv);

    }

    private void initData() {

        mAnimationDrawable = (AnimationDrawable) getResources().getDrawable(R.drawable.dialog_loading);
        mIv.setBackgroundDrawable(mAnimationDrawable);



        initAnim();
    }

    private void initAnim() {


    }

    private void initListener() {
        mBtnShow.setOnClickListener(this);
        mBtnHide.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnShow:
                start();
                break;
            case R.id.btnHide:
                stop();
                break;
        }
    }



    private void start() {
        if(mAnimationDrawable!=null && ! mAnimationDrawable.isRunning()){
            mAnimationDrawable.start();
        }

        MsProgressDialog.show(this);

    }
    private void stop() {
        if(mAnimationDrawable!=null && mAnimationDrawable.isRunning()){
            mAnimationDrawable.stop();
        }
        MsProgressDialog.dismiss();

    }
}
