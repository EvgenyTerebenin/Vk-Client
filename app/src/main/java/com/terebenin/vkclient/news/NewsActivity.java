package com.terebenin.vkclient.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.terebenin.vkclient.R;

import butterknife.ButterKnife;


/**
 * Created by evgeny on 25.01.17.
 */

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_logged_in);
        ButterKnife.bind(this);
    }
}
