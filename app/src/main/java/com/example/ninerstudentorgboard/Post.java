package com.example.ninerstudentorgboard;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Post {

    String postString, user, location, postDateString, eventDateString, tag;
    int id;
    ArrayList<Comment> commentArrayList;


    public Post() {
    }

    public Post(String postString, String user, int postId) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat df;
        df = DateFormat.getDateInstance(DateFormat.LONG);
        postDateString = df.format(date);
        commentArrayList =new ArrayList<Comment>();

        this.postString = postString;
        this.user = user;
        this.id = postId;
    }

    public void addComment(String commentString, String user){
        Comment c = new Comment(commentString, user, commentArrayList.size());
        commentArrayList.add( c );
    }

    public String getComment(int i){

        return commentArrayList.get(i).getCommentString() ;

    }

    public String getEventDateString() {
        return eventDateString;
    }

    public void setEventDateString(String eventDateString) {
        this.eventDateString = eventDateString;
    }



    public String getPostString() {
        return postString;
    }

    public void setPostString(String postString) {
        this.postString = postString;
    }


    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPostDateString() {
        return postDateString;
    }

    public void setPostDateString(String postDateString) {
        this.postDateString = postDateString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumComments(){

        return commentArrayList.size();

    }



}
