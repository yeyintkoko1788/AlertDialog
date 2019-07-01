package com.yeyint.customdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.yeyint.customalertdialog.CustomAlertDialog;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_default)
    Button btn_default;

    @BindView(R.id.btn_noactionbar)
    Button btn_noactionbar;

    @BindView(R.id.dialog_type_group)
    RadioGroup dialog_type_group;

    @BindView(R.id.et_title)
    EditText et_title;

    @BindView(R.id.et_message)
    EditText et_message;

    @BindView(R.id.et_positive)
    EditText et_positive;

    @BindView(R.id.et_negative)
    EditText et_negative;

    @BindView(R.id.btn_curve)
    Button btn_curve;

    @BindView(R.id.btn_fill)
    Button btn_fill;

    private CustomAlertDialog.DialogType type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        btn_default.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(CustomAlertDialog.DialogStyle.DEFAULT);
            }
        });

        btn_noactionbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(CustomAlertDialog.DialogStyle.NO_ACTION_BAR);
            }
        });

        btn_curve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(CustomAlertDialog.DialogStyle.CURVE);
            }
        });

        btn_fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(CustomAlertDialog.DialogStyle.FILL_STYLE);
            }
        });
    }

    private void showAlert(CustomAlertDialog.DialogStyle style){
        int radioButtonID = dialog_type_group.getCheckedRadioButtonId();
        View radioButton = dialog_type_group.findViewById(radioButtonID);
        int idx = dialog_type_group.indexOfChild(radioButton);
        getDialogType(idx);
        final CustomAlertDialog dialog = new CustomAlertDialog(this, style);
        dialog.setAlertMessage(et_message.getText().toString());
        if (style != CustomAlertDialog.DialogStyle.FILL_STYLE){
            dialog.setAlertTitle(et_title.getText().toString());
        }
        dialog.setPositiveButton(et_positive.getText().toString(), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),et_positive.getText().toString(),Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.setNegativeButton(et_negative.getText().toString(), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),et_negative.getText().toString(),Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        dialog.setDialogType(type);
        if (style == CustomAlertDialog.DialogStyle.NO_ACTION_BAR){
            dialog.setDialogImage(getDrawable(R.drawable.ic_warning_black_24dp));
        }
        dialog.create();
        dialog.show();
    }

    private void getDialogType(int index){
        switch (index){
            case 0:
                type = CustomAlertDialog.DialogType.DEFAULT;
                break;
            case 1:
                type = CustomAlertDialog.DialogType.ERROR;
                break;
            case 2:
                type = CustomAlertDialog.DialogType.SUCCESS;
                break;
            case 3:
                type = CustomAlertDialog.DialogType.INFO;
                break;
            case 4:
                type = CustomAlertDialog.DialogType.WARNING;
                break;
                default:
                    type = CustomAlertDialog.DialogType.DEFAULT;
        }
    }
}
