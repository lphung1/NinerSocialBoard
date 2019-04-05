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

import java.util.ArrayList;

public class NewCommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_comment);

        TextView postString = findViewById(R.id.detailsTextView);
        TextView eventNameTextView = findViewById(R.id.eventNameTextViewPostItem);
        TextView tagTV = findViewById(R.id.tagTextViewPostItem);
        final ImageView heart = findViewById(R.id.likesImageView);
        final TextView likesCount = findViewById(R.id.likeCounterTextView);
        final TextView commentCount = findViewById(R.id.commentsCountTextView);
        TextView postCreateDateTV = findViewById(R.id.dateTextView);


        if(getIntent() != null && getIntent().getExtras() != null){
            final Post post = (Post) getIntent().getExtras().getSerializable("POST");


            postString.setText(post.getPostString());

            commentCount.setText(Integer.toString(post.getCommentCount()));
            eventNameTextView.setText(post.getTitle());
            postCreateDateTV.setText(post.getPostDateString());

            likesCount.setText(Integer.toString(post.getLikesCount()));
            tagTV.setText(post.getTag());

            final ArrayList<String> commentStringList = new ArrayList<String>();

            for(int i = 0; i < post.getCommentCount(); i++){
                commentStringList.add(post.getComment(i));
            }


            final ArrayAdapter<String> basicCommentAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, commentStringList);
            ListView listView = findViewById(R.id.commentListView_newCommentActivity);
            listView.setAdapter(basicCommentAdapter);

            ImageView addCommentButton = findViewById(R.id.addCommentImageView);
            final EditText commentEditText = findViewById(R.id.AddCommentEditText);

            //add comment button
            addCommentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("New Comment Activity", "Add comment button pressed");
                    MainActivity.postArrayList.get(post.getId()).addComment(commentEditText.getText().toString(), "Me");
                    commentStringList.add(commentEditText.getText().toString());
                    basicCommentAdapter.notifyDataSetChanged();
                    commentEditText.setText("");
                    commentCount.setText(Integer.toString(MainActivity.postArrayList.get(post.getId()).getCommentCount()));

                }
            });
        }









    }
}
