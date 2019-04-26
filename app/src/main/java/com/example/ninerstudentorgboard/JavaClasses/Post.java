package com.example.ninerstudentorgboard.JavaClasses;

import android.net.Uri;
import android.support.annotation.Nullable;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Post implements Serializable {

    String postString, user, location, postDateString, eventDateString, tag, title;
    int id, commentCount, likesCount;
    ArrayList<Comment> commentArrayList;
    Uri storedImage;

    User author; //Stores reference to user that created the post.
    Date timestamp;

    public Post() {
    }

    public Post(String postString, String user, int postId) {

        Calendar cal = Calendar.getInstance();
        timestamp = cal.getTime();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        postDateString = df.format(timestamp);

        commentArrayList =new ArrayList<Comment>();
        commentCount = likesCount = 0;
        this.postString = postString;
        this.user = user;
        this.id = postId;
        this.storedImage = null;
    }

    public Post(String postString, String user, int postId, @Nullable Uri imageData) {

        Calendar cal = Calendar.getInstance();
        timestamp = cal.getTime();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        postDateString = df.format(timestamp);

        commentArrayList =new ArrayList<Comment>();
        commentCount = likesCount = 0;
        this.postString = postString;
        this.user = user;
        this.id = postId;
        this.storedImage = imageData;
    }

    public void addComment(String commentString, String user){
        Comment c = new Comment(commentString, user, commentArrayList.size());
        commentCount++;
        commentArrayList.add( c );
    }

    public String getComment(int i){

        return commentArrayList.get(i).getCommentString() ;

    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getEventDateString() {
        return eventDateString;
    }

    public void setEventDateString(String eventDateString) {
        this.eventDateString = eventDateString;
    }

    public void setTimestamp(Date d){
        timestamp = d;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addLike(){
        likesCount++;
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

    public int getCommentArrayListSize(){

        return commentArrayList.size();
    }

    public ArrayList<Comment> getCommentArrayList() {
        return commentArrayList;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public Uri getStoredImage(){
        return storedImage;
    }

    public void setAuthor(User A){
        this.author = A;
    }

    public User getAuthor(){
        return author;
    }
}

