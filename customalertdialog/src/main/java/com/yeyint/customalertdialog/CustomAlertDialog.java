package com.yeyint.customalertdialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CustomAlertDialog extends AlertDialog {

    private Context context;
    private View view;
    private AlertDialog alertDialog = null;

    public CustomAlertDialog(@NonNull Context context) {
        super(context,R.style.MyDialogTheme);
        this.context = context;
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = li.inflate(R.layout.default_alert, null);
        initialize(context, view);
    }

    protected CustomAlertDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = li.inflate(R.layout.default_alert, null);
        initialize(context,view);
    }

    protected CustomAlertDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = li.inflate(R.layout.default_alert, null);
        initialize(context,view);
    }

    private void initialize(Context context,View alertView){
        setCancelable(true);
        setView(alertView);
        setCanceledOnTouchOutside(true);
    }

    public void setAlertMessage(String message){
        TextView textView = view.findViewById(R.id.alert_message);
        textView.setText(message);
    }

    public void setPositiveButton(String name, View.OnClickListener onClickListener){
        Button positiveButton = view.findViewById(R.id.btn_positive);
        positiveButton.setText(name);

        positiveButton.setOnClickListener(onClickListener);
    }

    public void setNegativeButton(String name, View.OnClickListener onClickListener){
        Button negativeButton = view.findViewById(R.id.btn_negative);
        negativeButton.setText(name);

        negativeButton.setOnClickListener(onClickListener);
    }

    public void setAlertTitle(String title){
        TextView textView = view.findViewById(R.id.alert_title);
        textView.setText(title);
    }

}
