package com.yeyint.customalertdialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

class AlertView extends CardView {

    private Context context;
    private View view;

    public AlertView(@NonNull Context context) {
        super(context);
        this.context = context;
        view = initialize(context);
    }

    public AlertView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        view = initialize(context);
    }

    public AlertView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        view = initialize(context);
    }

    private View initialize(Context context){
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return li.inflate(R.layout.default_alert, this);
    }
}
