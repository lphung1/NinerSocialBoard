package com.example.ninerstudentorgboard;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.animation.BounceInterpolator;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ninerstudentorgboard.JavaClasses.Post;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.view.FrameMetrics.ANIMATION_DURATION;


public class CustomAdapterPostList extends ArrayAdapter<Post> {

    private Activity m_activity;



    public CustomAdapterPostList(@NonNull Context context, int resource, ArrayList<Post> objects) {
        super(context, resource, objects);
    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        final Post post = this.getItem(position);

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.post_item, parent, false);
        TextView postString = convertView.findViewById(R.id.detailsTextView);
        TextView eventNameTextView = convertView.findViewById(R.id.eventNameTextViewPostItem);
        TextView tagTV = convertView.findViewById(R.id.tagTextViewPostItem);
        final ImageView heart = convertView.findViewById(R.id.likesImageView);
        final TextView likesCount = convertView.findViewById(R.id.likeCounterTextView);
        TextView commentCount = convertView.findViewById(R.id.commentsCountTextView);
        TextView postCreateDateTV = convertView.findViewById(R.id.dateTextView);
        final ImageView commentIV = convertView.findViewById(R.id.commentsCountImageView);

        //set comment button as listener
        commentIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Item post clicked", "From customadapter Item " + post.getPostString());
                PostDetailsFragment postDetailsFragment = new PostDetailsFragment();
                Context c = getContext();

                //getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_main, postDetailsFragment).commit();

                Intent i = new Intent(c, NewCommentActivity.class);
                i.putExtra("POST", post);
                c.startActivity(i);
            }
        });
        //set comment count as button as well for easy press
        commentCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Item post clicked", "From customadapter Item " + post.getPostString());
                PostDetailsFragment postDetailsFragment = new PostDetailsFragment();
                Context c = getContext();

                //getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_main, postDetailsFragment).commit();

                Intent i = new Intent(c, NewCommentActivity.class);
                i.putExtra("POST", post);
                c.startActivity(i);
            }
        });


        postString.setText(post.getPostString());

        commentCount.setText(Integer.toString(post.getCommentCount()));
        eventNameTextView.setText(post.getTitle());
        postCreateDateTV.setText(post.getPostDateString());

        likesCount.setText(Integer.toString(post.getLikesCount()));
        tagTV.setText(post.getTag());


            //set as the tag the position parameter and add like functionality
            heart.setTag(new Integer(position));
            heart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    post.addLike();

                    AnimatorSet animatorSet = new AnimatorSet();
                    likesCount.setText(Integer.toString(post.getLikesCount()));
                    ObjectAnimator bounceAnimX = ObjectAnimator.ofFloat(heart, "scaleX", 0.2f, 1f);
                    bounceAnimX.setDuration(ANIMATION_DURATION);
                    bounceAnimX.setInterpolator(new BounceInterpolator());

                    ObjectAnimator bounceAnimY = ObjectAnimator.ofFloat(heart, "scaleY", 0.2f, 1f);
                    bounceAnimY.setDuration(ANIMATION_DURATION);
                    bounceAnimY.setInterpolator(new BounceInterpolator());
                    bounceAnimY.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            heart.setImageResource(R.drawable.ic_like_active);
                        }
                    });

                    animatorSet.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                        }
                    });

                    animatorSet.play(bounceAnimX).with(bounceAnimY);
                    animatorSet.start();



                }
            });




        return convertView;

    }

}
