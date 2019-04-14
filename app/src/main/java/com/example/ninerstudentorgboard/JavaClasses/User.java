package com.example.ninerstudentorgboard.JavaClasses;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

        //User class attributes
        String username, userEmail;
        int userID, postCount;
        ArrayList<Post> mypostArrayList;
        ArrayList<Post> likePostArrayList;

        //Constructor
        public User(String username, String userEmail, int userID){
            this.username = username;
            this.userEmail = userEmail;
            this.userID = userID;
            postCount = 0;
            commentCount = 0;
            postArrayList = new ArrayList<Post>();
        }

        //Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public ArrayList<Post> getMypostArrayListPostArrayList() {
        return mypostArrayList;
    }

    public ArrayList<Post> getLikePostArrayList() {
        return likePostArrayList;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

}
