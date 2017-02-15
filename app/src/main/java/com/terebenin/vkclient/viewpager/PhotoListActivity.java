package com.terebenin.vkclient.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
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

public class PhotoListActivity extends FragmentActivity {

    @BindView(R.id.uiImageViewPhotoItem) ImageView ivPhotoItem;
    @BindView(R.id.uiViewPager) ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_viewpager);
        ButterKnife.bind(this, viewPager);
        Bundle bundle = getIntent().getExtras();
        String EXTRA_PHOTO_ITEM_URL = bundle.getString("EXTRA_PHOTO_ITEM_URL");
        Toast.makeText(this, EXTRA_PHOTO_ITEM_URL, Toast.LENGTH_SHORT).show();
        Picasso.with(getApplicationContext()).load(EXTRA_PHOTO_ITEM_URL).into(ivPhotoItem);
    }
}

