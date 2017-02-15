package com.terebenin.vkclient.newsfeed;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.terebenin.vkclient.R;

/**
 * Created by evgeny on 15.02.17.
 */

public class PhotoItemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_photoitem);
    }
}

