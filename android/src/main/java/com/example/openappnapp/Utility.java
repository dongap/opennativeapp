package com.example.openappnapp;

import android.app.Activity;
import android.widget.Toast;

public class Utility {

    public static boolean isEmptyVal(String s) {
        return s == null || s.trim().equals("") || s.isEmpty() || s.equals("null") || s.length() == 0;
    }

    public static void ShowToast(Activity activity, String msg) {
        if (msg != null) {
            Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
        }
    }

}