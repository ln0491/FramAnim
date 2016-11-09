package com.ghg.framanim.dialog;

import android.content.Context;
import android.util.Log;

import com.ghg.framanim.util.L;


public class MsProgressDialog {

    private static CustomProgressDialog mDialog;

    public static void show(Context context) {
        try {
            if (mDialog == null || !mDialog.isShowing()) {
                mDialog = new CustomProgressDialog(context);
            }
            mDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
            mDialog = null;
        } catch (Error error) {
            error.printStackTrace();
            Log.e("aa", error.getMessage());
            mDialog = null;
        }

    }

    public static void dismiss() {
        try {
            if (mDialog != null && mDialog.isShowing()) {
                mDialog.dismiss();
            }
            mDialog = null;
        } catch (Exception e) {
            e.printStackTrace();
            L.d("vivi", e.getMessage());
            mDialog = null;
        } catch (Error error) {
            error.printStackTrace();
            L.d("vivi", error.getMessage());
            mDialog = null;
        }
    }

    
   
}
