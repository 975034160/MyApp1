package com.zhbr.mvp.main.fragment;

import android.animation.ObjectAnimator;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zhbr.R;

public class FragmentOrder extends Fragment {

    private ViewModelOrder mViewModel;
    private ImageView im ;
    public static FragmentOrder newInstance() {
        return new FragmentOrder();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        im = view.findViewById(R.id.iv_logo);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ViewModelOrder.class);
        // TODO: Use the ViewModel
        //初始化的时候从viewModel中读取
        im.setRotation(mViewModel.rotation);
        final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(im,"rotation",0,0);
        objectAnimator.setDuration(500);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!objectAnimator.isRunning()){
                    objectAnimator.setFloatValues(im.getRotation(),im.getRotation()+90);
                    //给viewModel中的记录也加
                    mViewModel.rotation+=90;
                    objectAnimator.start();
                }
            }
        });
    }

}
