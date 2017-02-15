package com.terebenin.vkclient.newsfeed;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.terebenin.vkclient.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by evgeny on 15.02.17.
 */

public class PhotoItemActivity extends AppCompatActivity {

    @BindView(R.id.uiImageViewPhotoItem) ImageView ivPhotoItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_photoitem);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        String EXTRA_PHOTO_ITEM_URL = bundle.getString("EXTRA_PHOTO_ITEM_URL");
        Toast.makeText(this, EXTRA_PHOTO_ITEM_URL, Toast.LENGTH_SHORT).show();
        Picasso.with(getApplicationContext()).load(EXTRA_PHOTO_ITEM_URL).into(ivPhotoItem);
    }
}

