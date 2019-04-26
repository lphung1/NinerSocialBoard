package com.example.ninerstudentorgboard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ninerstudentorgboard.JavaClasses.Comment;
import com.example.ninerstudentorgboard.JavaClasses.Post;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.view.FrameMetrics.ANIMATION_DURATION;

public class CustomAdapterCommentList extends ArrayAdapter<Comment> {



    public CustomAdapterCommentList(@NonNull Context context, int resource, ArrayList<Comment> objects) {
        super(context, resource, objects);

    }



    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        final Comment comment = this.getItem(position);

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.comment_item, parent, false);
        TextView titleTextView = convertView.findViewById(R.id.comment_textview_commentitem);

        Log.d("Comment string", comment.getCommentString());

        titleTextView.setText(comment.getCommentString());



        return convertView;

    }





}
