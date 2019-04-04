package com.example.ninerstudentorgboard;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ninerstudentorgboard.JavaClasses.Post;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Post> {

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<Post> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        Post post = this.getItem(position);

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.post_item, parent, false);
        TextView postString = convertView.findViewById(R.id.detailsTextView);
        //ImageView appImage = convertView.findViewById(R.id.appImageView);

        postString.setText(post.getPostString());



        return convertView;
    }


}
