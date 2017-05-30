package com.sunh.comutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.sunh.comutils.view.TopBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.topbar)
    TopBarUtils topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        topbar.setTopBarClickListener(new TopBarUtils.TopBarClickListener() {
            @Override
            public void onLeftClick() {
                Toast.makeText(MainActivity.this,"left",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightClck() {
                Toast.makeText(MainActivity.this,"right",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
