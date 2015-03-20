package com.tanjulia.photoeditor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 /**
 * Created by Tania on 3/15/2015.
 */
public class BackGround extends Fragment{

    private static TextView topMeme;
    private static TextView bottomMeme;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom, container, false);

        topMeme = (TextView) view.findViewById(R.id.topText);
        bottomMeme = (TextView) view.findViewById(R.id.textView2);


        return view;

    }

    public void makeMeme(String top, String bottom){
        topMeme.setText(top);
        bottomMeme.setText(bottom);

    }



}
