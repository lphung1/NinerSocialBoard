package com.example.ninerstudentorgboard;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ninerstudentorgboard.JavaClasses.Comment;
import com.example.ninerstudentorgboard.JavaClasses.Post;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class NewCommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_comment);
        getSupportActionBar().hide();
        TextView postString = findViewById(R.id.detailsTextView);
        TextView eventNameTextView = findViewById(R.id.eventNameTextViewPostItem);
        TextView tagTV = findViewById(R.id.tagTextViewPostItem);
        final ImageView heart = findViewById(R.id.likesImageView);
        final TextView likesCount = findViewById(R.id.likeCounterTextView);
        final TextView commentCount = findViewById(R.id.commentsCountTextView);
        TextView postCreateDateTV = findViewById(R.id.dateTextView);
        final ImageView postImage = findViewById(R.id.imageView_Stored_Image_Post);


        if(getIntent() != null && getIntent().getExtras() != null){


            final int position = getIntent().getExtras().getInt("POST_POSITION");
            final Post post = MainActivity.postArrayList.get(position);

            postString.setText(post.getPostString());

            commentCount.setText(Integer.toString(post.getCommentCount()));
            eventNameTextView.setText(post.getTitle());
            postCreateDateTV.setText(post.getPostDateString());

            //set image
            postImage.setImageURI(post.getStoredImage());

            likesCount.setText(Integer.toString(post.getLikesCount()));
            tagTV.setText(post.getTag());

            final ArrayList<String> commentStringList = new ArrayList<String>();

            for(int i = 0; i < post.getCommentCount(); i++){
                commentStringList.add(post.getComment(i));
            }


            final CustomAdapterCommentList adapter = new CustomAdapterCommentList(NewCommentActivity.this, R.layout.comment_item, post.getCommentArrayList());

            ListView listView = findViewById(R.id.commentListView_newCommentActivity);
            listView.setAdapter(adapter);

            ImageView addCommentButton = findViewById(R.id.addCommentImageView);
            final EditText commentEditText = findViewById(R.id.AddCommentEditText);

            //add comment button
            addCommentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("New Comment Activity", "Add comment button pressed");

                        Log.d("New Comment Activity", commentEditText.getText().toString());
                        MainActivity.postArrayList.get(position).addComment(commentEditText.getText().toString(), "Me");
                        Log.d("NewComAct-CommentCount", " " + MainActivity.postArrayList.get(position).getCommentArrayListSize());
                        commentStringList.add(commentEditText.getText().toString());
                        commentEditText.setText("");
                        commentCount.setText(Integer.toString(MainActivity.postArrayList.get(position).getCommentCount()));
                        adapter.notifyDataSetChanged();



                }
            });

            listView.setAdapter(adapter);

            /*
        Calculate how long ago post was made
        sets the time difference for the posts
         */
            Calendar cal = Calendar.getInstance();

            DateFormat fm = DateFormat.getDateInstance(DateFormat.FULL);
            Date currentTimeStamp = cal.getTime();
            Date postTimeStamp = post.getTimestamp();
            fm.format(currentTimeStamp);
            fm.format(postTimeStamp);
            int secondsInMil = 1000;
            int minInMil = 60000;
            int hourInMil = minInMil * 60;
            int dayInMil = hourInMil * 24;

            long timeDifference = currentTimeStamp.getTime() - postTimeStamp.getTime();
            // if less than 60 seconds have passed, display seconds ago
            if( timeDifference < minInMil ) {
                long d = ((currentTimeStamp.getTime() - postTimeStamp.getTime()) / secondsInMil);
                postCreateDateTV.setText(post.getPostDateString() + "\n" + d + "s ago");
            }
            //if more than 60 seconds have past, display minutes ago
            else if(timeDifference < hourInMil ){
                long d = ((currentTimeStamp.getTime() - postTimeStamp.getTime()) / minInMil );
                postCreateDateTV.setText(post.getPostDateString() + "\n" + d + " minutes ago");
            }
            else if(timeDifference < dayInMil){
                long d = ((currentTimeStamp.getTime() - postTimeStamp.getTime()) / hourInMil );
                postCreateDateTV.setText(post.getPostDateString() + "\n" + d + " hours ago");
            }
            else if (timeDifference > dayInMil ){
                long d = ((currentTimeStamp.getTime() - postTimeStamp.getTime()) / dayInMil );
                postCreateDateTV.setText(post.getPostDateString() + "\n" + d + " days ago");
            }
        }









    }
}
