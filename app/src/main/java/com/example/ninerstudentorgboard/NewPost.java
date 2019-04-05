package com.example.ninerstudentorgboard;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ninerstudentorgboard.JavaClasses.Post;

import java.util.Calendar;

import static com.example.ninerstudentorgboard.MainActivity.postArrayList;

public class NewPost extends AppCompatActivity {

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Button submitButton;
    private  TextView eventTitleTV;
    private EditText eventTitleEditText;
    private TextView tagEditText;
    private boolean dateSet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        mDisplayDate = findViewById(R.id.selectDateTextView);
        submitButton = findViewById(R.id.submit_newPost);
        tagEditText = findViewById(R.id.tagEditText_newPost);
        eventTitleEditText = findViewById(R.id.postTitleEditText_newPost);
        final EditText postContent = findViewById(R.id.postEditText_newPost);

        //submits entreis when submit button is pressed
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = postContent.getText().toString();
                Log.d("Post Content", "" + text);
                Post thisPost = new Post(text, "User1", postArrayList.size());

                thisPost.setTag(tagEditText.getText().toString());
                thisPost.setTitle(eventTitleEditText.getText().toString());
                if(dateSet) {
                    thisPost.setEventDateString(mDisplayDate.getText().toString());
                }
                postArrayList.add(thisPost);
                Log.d("Arraylist size", "" + postArrayList.size());
                finish();
            }
        });

        //lets user select date
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        NewPost.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                dateSet = true;
            }
        });




        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d("DatePicker", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };



    }
}

