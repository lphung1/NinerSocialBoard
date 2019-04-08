package com.example.ninerstudentorgboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ninerstudentorgboard.JavaClasses.Post;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {

        public static ArrayList<Post> postArrayList = new ArrayList<Post>();
        PostListFragment postListFragment = new PostListFragment();
        StudentOrgListFragment studentOrgListFragment = new StudentOrgListFragment();
        PostDetailsFragment postDetailsFragment = new PostDetailsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        populateSampleData();

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_main, studentOrgListFragment);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_main, postListFragment).commit();


        //on click listener for add post button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent i = new Intent(MainActivity.this, NewPost.class);
                startActivity(i);

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }//end oncreate


    @Override
    protected void onResume() {
        super.onResume();
        postListFragment.updateFragment1ListView();
        Log.d("On Resume Called", "Main Activity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        //postListFragment.updateFragment1ListView();
        Log.d("On Start Called", "Main Activity");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.org_list) {

            Log.d("MainActivity:", "Option orglist selected");


            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, studentOrgListFragment).commit();

        } else if (id == R.id.board_feed_menu) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, postListFragment).commit();

        } else if (id == R.id.official_events_menu) {

        } else if (id == R.id.saved_events_menu) {

        } else if (id == R.id.settings_menu) {

        } else if (id == R.id.log_out_menu) {
            Log.d("MainActivity:", "Option logout selected");

            startActivity(new Intent(MainActivity.this, SignUp.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }//end onNavigationItemSelected





    public void openFragmentDetailPostItem(Post p){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_main, postDetailsFragment).commit();
    }


    void populateSampleData(){

        Post p1 = new Post("Our club is meeting tonight at 7 for a pizza party, please stop by!", "User1", postArrayList.size());
        p1.setTitle("Pizza party");
        p1.setTag("#RandomClub");
        p1.setLikesCount(5);
        p1.addComment("I'll be there", "User2");
        postArrayList.add(p1);

        Post p2 = new Post("App ventures is having a meeting tomorrow, feel free to stop by.", "User4", postArrayList.size());
        p2.setTitle("Club Meeting");
        p2.setTag("#App Ventures");
        p2.setLikesCount(9);
        p2.addComment("I'll be there", "User4");
        postArrayList.add(p2);

        Post p3 = new Post("We're having a super smash bros ultimate tournament tomorrow at SAC, come to win a free switch", "User2", postArrayList.size());
        p3.setTitle("Smash Tournament");
        p3.setTag("#SmashUltimate, #GameClub");
        p3.setLikesCount(1);
        p3.addComment("You're gonna get wrecked", "Scrub1");
        p3.addComment("Who wanna get these hands", "FearlessJoe");
        postArrayList.add(p3);

        Post p4 = new Post("Anyone want to get together to study for the physics test today", "User2", postArrayList.size());
        p4.setTitle("Physics Test");
        p4.setTag("#PhysicsTest1201");
        p4.setLikesCount(3);
        p4.addComment("I'm struggling too", "User2");
        postArrayList.add(p4);


    }


}//end mainActivity class
