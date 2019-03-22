package com.example.ninerstudentorgboard;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Post {

    String postString, user, location, dateString;
    int id;
    ArrayList<Comment> commentArrayList;



    public Post(String postString, String user, int id) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat df;
        df = DateFormat.getDateInstance(DateFormat.LONG);
        dateString = df.format(date);
        commentArrayList =new ArrayList<Comment>();

        this.postString = postString;
        this.user = user;
        this.id = id;
    }

    public void addComment(String commentString, String user){
        Comment c = new Comment(commentString, user, commentArrayList.size());
        commentArrayList.add( c );
    }

    public String getComment(int i){

        return commentArrayList.get(i).getCommentString() ;

    }

    public Post() {
    }

    public String getPostString() {
        return postString;
    }

    public void setPostString(String postString) {
        this.postString = postString;
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

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
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
