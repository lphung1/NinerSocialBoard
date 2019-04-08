package com.example.ninerstudentorgboard.JavaClasses;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Comment implements Serializable {

    String commentString, user, dateString;
    int commentId;

    public Comment(String commentString, String user, int comID) {

        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat df;
        df = DateFormat.getDateInstance(DateFormat.LONG);
        dateString = df.format(date);

        this.commentString = commentString;
        this.user = user;
        this.commentId = comID;
    }

    public Comment() {
    }

    public String getCommentString() {
        return commentString;
    }

    public void setCommentString(String commentString) {
        this.commentString = commentString;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }


    public String toString() {
        return commentString;
    }
}
