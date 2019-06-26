package com.yeyint.customalertdialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

public class AlertDialog extends CardView {
    public AlertDialog(@NonNull Context context) {
        super(context);
        initialize(context);
    }

    public AlertDialog(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public AlertDialog(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    private void initialize(Context context){
        inflate(context, R.layout.default_alert, this);
    }
}
