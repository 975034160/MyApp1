package com.zhbr.mvp.main.fragment3;

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
import android.widget.TextView;

import com.zhbr.R;

public class FragmentMy extends Fragment {

    private ViewModelMy mViewModel;

//    private ImageView im ;

    public static FragmentMy newInstance() {
        return new FragmentMy();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
//        im = view.findViewById(R.id.iv_logo);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ViewModelMy.class);
        // TODO: Use the ViewModel

        //获取activity中的TextView组件
        TextView tv_bar_title = getActivity().findViewById(R.id.tv_bar_title);

        //获取Fregment中的TextView组件
        //TextView tv_bar_title = getView.findViewById(R.id.tv_bar_title);
        tv_bar_title.setText("我的");


        //初始化的时候从viewModel中读取
//        im.setRotation(mViewModel.rotation);
//        final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(im,"rotation",0,0);
//        objectAnimator.setDuration(500);
//        im.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!objectAnimator.isRunning()){
//                    objectAnimator.setFloatValues(im.getRotation(),im.getRotation()+90);
//                    //给viewModel中的记录也加
//                    mViewModel.rotation+=90;
//                    objectAnimator.start();
//                }
//            }
//        });

    }

}
