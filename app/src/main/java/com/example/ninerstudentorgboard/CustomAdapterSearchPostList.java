package com.example.ninerstudentorgboard;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.example.ninerstudentorgboard.JavaClasses.Post;

import java.util.ArrayList;

public class CustomAdapterSearchPostList extends ArrayAdapter<Post> {

    private Activity s_Activty;

    public CustomAdapterPostList(@NonNull Context context, int resource, ArrayList<Post> objects) {
        super(context, resource, objects);
    }

}
