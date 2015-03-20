package com.tanjulia.photoeditor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;


public class top_section_fragment extends Fragment {

    private static EditText one;
    private static EditText two;

    //make an interface object
    top_section_fragmentListener activityTop;


    public interface top_section_fragmentListener{
        //Get the strings and pass it on
        public void SwagCreate(String top, String bottom);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            //create an interface to talk to the main activity
            activityTop = (top_section_fragmentListener) activity;

        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.topp, container, false) ;

        one= (EditText) view.findViewById(R.id.one);
        two= (EditText) view.findViewById(R.id.two);

        final Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        buttonClicked(v);
                    }
                }

        );


        return view;
    }

    public void buttonClicked(View v){
        //Get the top and botton string
        activityTop.SwagCreate(one.getText().toString(),two.getText().toString());
    }

}
