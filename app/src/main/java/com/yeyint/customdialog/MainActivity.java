package com.yeyint.customdialog;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yeyint.customalertdialog.CustomAlertDialog;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn)
    Button btn;

    private android.support.v7.app.AlertDialog alertDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert();
            }
        });
    }

    private void showAlert(){
        final CustomAlertDialog dialog = new CustomAlertDialog(this);
        dialog.setAlertMessage("This dialog is created by Ye Yint Ko Ko. Date 26.6.2019.");
        dialog.setPositiveButton("Ok", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("Testing");
                dialog.dismiss();
            }
        });
        dialog.setNegativeButton("Close", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("Press");
                dialog.cancel();
            }
        });
        dialog.create();
        dialog.show();
    }
}
