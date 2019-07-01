package com.yeyint.customalertdialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CustomAlertDialog extends AlertDialog {

    private Context context;
    private View view;
    public enum DialogType {
        DEFAULT,
        ERROR,
        SUCCESS,
        INFO,
        WARNING
    }

    public enum DialogStyle{
        DEFAULT,
        NO_ACTION_BAR,
        CURVE,
        FILL_STYLE
    }

    private Button positiveButton;
    private Button negativeButton;
    private TextView positiveText;
    private TextView negativeText;
    private TextView alertMessage;
    private TextView alertTitle;
    private LinearLayout llTitleLayout;
    private ImageView dialogImage;
    private LinearLayout mainLayout;

    private DialogStyle style = DialogStyle.DEFAULT;
    private DialogType type = DialogType.DEFAULT;

    public CustomAlertDialog(@NonNull Context context, DialogStyle dialogStyle) {
        super(context,R.style.MyDialogTheme);
        this.context = context;
        switch (dialogStyle){
            case DEFAULT:
                initialize(context);
                style = DialogStyle.DEFAULT;
                break;
            case NO_ACTION_BAR:
                initializeNoActionBar(context);
                style = DialogStyle.NO_ACTION_BAR;
                break;
            case CURVE:
                initializeCurve(context);
                style = DialogStyle.CURVE;
                break;
            case FILL_STYLE:
                initializeFill(context);
                style = DialogStyle.FILL_STYLE;
                break;
            default:
                initialize(context);
                break;
        }
        setDialogType(type);

    }

    protected CustomAlertDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = li.inflate(R.layout.default_alert, null);
        initialize(context);
    }

    protected CustomAlertDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = li.inflate(R.layout.default_alert, null);
        initialize(context);
    }

    private void initialize(Context context){
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = li.inflate(R.layout.default_alert, null);

        positiveButton = view.findViewById(R.id.btn_positive);
        negativeButton = view.findViewById(R.id.btn_negative);
        alertMessage = view.findViewById(R.id.alert_message);
        alertTitle = view.findViewById(R.id.alert_title);
        llTitleLayout = view.findViewById(R.id.ll_title_layout);

        setCancelable(true);
        setView(view);
        setCanceledOnTouchOutside(true);
    }

    private void initializeNoActionBar(Context context){
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = li.inflate(R.layout.no_actionbar_dialog, null);

        positiveText = view.findViewById(R.id.btn_positive);
        negativeText = view.findViewById(R.id.btn_negative);
        alertMessage = view.findViewById(R.id.alert_message);
        alertTitle = view.findViewById(R.id.alert_title);
        dialogImage = view.findViewById(R.id.iv_dialog);

        setCancelable(true);
        setView(view);
        setCanceledOnTouchOutside(true);
    }

    private void initializeCurve(Context context){
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = li.inflate(R.layout.curve_layout, null);

        positiveButton = view.findViewById(R.id.btn_positive);
        negativeButton = view.findViewById(R.id.btn_negative);
        alertMessage = view.findViewById(R.id.alert_message);
        alertTitle = view.findViewById(R.id.alert_title);

        setCancelable(true);
        setView(view);
        setCanceledOnTouchOutside(true);
    }

    private void initializeFill(Context context){
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = li.inflate(R.layout.fill_dialog, null);

        positiveButton = view.findViewById(R.id.btn_positive);
        negativeButton = view.findViewById(R.id.btn_negative);
        alertMessage = view.findViewById(R.id.alert_message);
        dialogImage = view.findViewById(R.id.iv_dialog);
        mainLayout = view.findViewById(R.id.main_layout);

        setCancelable(true);
        setView(view);
        setCanceledOnTouchOutside(true);
    }

    public void setAlertMessage(String message){
        alertMessage.setText(message);
    }

    public void setPositiveButton(String name, View.OnClickListener onClickListener){
        switch (style){
            /*case DEFAULT:
                positiveButton.setVisibility(View.VISIBLE);
                positiveButton.setText(name);
                positiveButton.setOnClickListener(onClickListener);
                break;*/
            case NO_ACTION_BAR:
                positiveText.setVisibility(View.VISIBLE);
                positiveText.setText(name);
                positiveText.setOnClickListener(onClickListener);
                break;
                default:
                    positiveButton.setVisibility(View.VISIBLE);
                    positiveButton.setText(name);
                    positiveButton.setOnClickListener(onClickListener);
                    break;

        }

    }

    public void setNegativeButton(String name, View.OnClickListener onClickListener){
        switch (style){
            /*case DEFAULT:
                negativeButton.setVisibility(View.VISIBLE);
                negativeButton.setText(name);
                negativeButton.setOnClickListener(onClickListener);
                break;*/
            case NO_ACTION_BAR:
                negativeText.setVisibility(View.VISIBLE);
                negativeText.setText(name);
                negativeText.setOnClickListener(onClickListener);
                break;
                default:
                    negativeButton.setVisibility(View.VISIBLE);
                    negativeButton.setText(name);
                    negativeButton.setOnClickListener(onClickListener);
                    break;

        }
    }

    public void setAlertTitle(String title){
        alertTitle.setText(title);
    }

    public void setDialogType(DialogType type){
        this.type = type;
        switch (type){
            case INFO:
                setColor(context.getResources().getColor(R.color.colorInfo),
                        context.getResources().getColor(R.color.colorInfoTran),
                        context.getResources().getDrawable(R.drawable.info_btn),
                        context.getResources().getDrawable(R.drawable.cancel_info_btn),
                        context.getResources().getDrawable(R.drawable.info_fill_btn),
                        context.getResources().getDrawable(R.drawable.round_layout_info));
                break;
            case ERROR:
                setColor(context.getResources().getColor(R.color.colorError),
                        context.getResources().getColor(R.color.colorErrorTran),
                        context.getResources().getDrawable(R.drawable.error_btn),
                        context.getResources().getDrawable(R.drawable.cancel_error_btn),
                        context.getResources().getDrawable(R.drawable.error_fill_btn),
                        context.getResources().getDrawable(R.drawable.round_layout_error));
                break;
            case DEFAULT:
                setColor(context.getResources().getColor(R.color.colorDefault),
                        context.getResources().getColor(R.color.colorDefaultTran),
                        context.getResources().getDrawable(R.drawable.default_btn),
                        context.getResources().getDrawable(R.drawable.cancel_default_btn),
                        context.getResources().getDrawable(R.drawable.default_fill_btn),
                        context.getResources().getDrawable(R.drawable.round_layout_default));
                break;
            case SUCCESS:
                setColor(context.getResources().getColor(R.color.colorSuccess),
                        context.getResources().getColor(R.color.colorSuccessTran),
                        context.getResources().getDrawable(R.drawable.success_btn),
                        context.getResources().getDrawable(R.drawable.cancel_success_btn),
                        context.getResources().getDrawable(R.drawable.success_fill_btn),
                        context.getResources().getDrawable(R.drawable.round_layout_success));
                break;
            case WARNING:
                setColor(context.getResources().getColor(R.color.colorWarning),
                        context.getResources().getColor(R.color.colorWarningTran),
                        context.getResources().getDrawable(R.drawable.warning_btn),
                        context.getResources().getDrawable(R.drawable.cancel_warnign_btn),
                        context.getResources().getDrawable(R.drawable.warning_fill_btn),
                        context.getResources().getDrawable(R.drawable.round_layout_warning));
                break;
        }
    }

    private void setColor(int color,int colorTran, Drawable positiveDrawable, Drawable negativeDrawable, Drawable fillDrawable, Drawable layout){
        switch (style){
            case DEFAULT:
                llTitleLayout.setBackgroundColor(color);
                positiveButton.setBackground(positiveDrawable);
                negativeButton.setBackground(negativeDrawable);
                negativeButton.setTextColor(color);
                break;
            case NO_ACTION_BAR:
                positiveText.setTextColor(color);
                negativeText.setTextColor(color);
                dialogImage.setColorFilter(color);
                setDialogImageType();
                break;
            case CURVE:
                positiveButton.setBackground(fillDrawable);
                break;
            case FILL_STYLE:
                mainLayout.setBackground(layout);
                dialogImage.setColorFilter(context.getResources().getColor(R.color.colorWhite));
                setDialogImageType();


        }
    }

    public void setDialogImage(Drawable image, int color){
        Glide.with(context)
                .asDrawable()
                .load(image)
                .into(dialogImage);
        dialogImage.setColorFilter(color);
    }

    private void setDialogImageType(){
        switch (type){
            case DEFAULT:
                Glide.with(context)
                        .asDrawable()
                        .load(R.drawable.ic_android_blue_24dp)
                        .into(dialogImage);
                break;
            case WARNING:
                Glide.with(context)
                        .asDrawable()
                        .load(R.drawable.ic_warning_black_24dp)
                        .into(dialogImage);
                break;
            case SUCCESS:
                Glide.with(context)
                        .asDrawable()
                        .load(R.drawable.ic_check_box_white_24dp)
                        .into(dialogImage);
                break;
            case ERROR:
                Glide.with(context)
                        .asDrawable()
                        .load(R.drawable.ic_error_black_24dp)
                        .into(dialogImage);
                break;
            case INFO:
                Glide.with(context)
                        .asDrawable()
                        .load(R.drawable.ic_info_outline_black_24dp)
                        .into(dialogImage);
                break;
        }
    }

    public void setImageSize(int width , int height){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
        params.setMargins(20,20,20,20);
        dialogImage.setLayoutParams(params);
    }
}
