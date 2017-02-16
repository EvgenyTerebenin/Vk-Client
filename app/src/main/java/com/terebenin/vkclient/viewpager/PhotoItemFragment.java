package com.terebenin.vkclient.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.terebenin.vkclient.R;
import com.terebenin.vkclient.models.newsItem.Photo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.terebenin.vkclient.adapter.RecyclerViewAdapter.EXTRA_PHOTOLIST;
import static com.terebenin.vkclient.adapter.RecyclerViewAdapter.EXTRA_POSITION;

public class PhotoItemFragment extends Fragment {

    @BindView(R.id.uiImageViewPhotoItem) ImageView ivPhotoItem;
    ArrayList<Photo> photos;
    int position;


    static PhotoItemFragment newInstance(int position) {
//        ArrayList<Photo> photolist = null;
        PhotoItemFragment photoItemFragment = new PhotoItemFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(EXTRA_POSITION, position);
//        arguments.putParcelableArrayList(EXTRA_PHOTOLIST, photos);
        photoItemFragment.setArguments(arguments);
        return photoItemFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        photos = getActivity().getIntent().getParcelableArrayListExtra(EXTRA_PHOTOLIST);
        photos = getArguments().getParcelableArrayList(EXTRA_PHOTOLIST);
//        position = getActivity().getIntent().getIntExtra(EXTRA_POSITION, position);
        position = getArguments().getInt(EXTRA_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ButterKnife.bind(this, getView());
        View view = inflater.inflate(R.layout.fragment_photo_item, null);
        Picasso.with(getActivity()).load(photos.get(position).getPhoto_604()).into(ivPhotoItem);

        return view;
    }
}

