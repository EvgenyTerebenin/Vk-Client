package com.terebenin.vkclient.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.terebenin.vkclient.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoItemFragment extends Fragment {

    @BindView(R.id.uiImageViewPhotoItem) ImageView ivPhotoItem;
    private String photoUrl;
    static final String EXTRA_PHOTOURL = "EXTRA_PHOTOURL";

    static PhotoItemFragment newInstance(String photoUrl) {
        PhotoItemFragment photoItemFragment = new PhotoItemFragment();
        Bundle arguments = new Bundle();
        arguments.putString(EXTRA_PHOTOURL, photoUrl);
        photoItemFragment.setArguments(arguments);
        return photoItemFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photoUrl = getArguments().getString(EXTRA_PHOTOURL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_photo_item, container, false);
        ButterKnife.bind(this, view);
        Picasso.with(getActivity()).load(photoUrl).into(ivPhotoItem);

        return view;
    }
}

