package dev.raghav.civilgate.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import dev.raghav.civilgate.Frag_granades.Home;
import dev.raghav.civilgate.Parsingfiles.LoginReg.Login_Responce;
import dev.raghav.civilgate.R;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
   Response<Login_Responce> response;
   Fragment mainFragment =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//putt home frags
        mainFragment = new Home();
        LoadGodamnFrags(mainFragment);
        //
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(1).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(2).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(3).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(4).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(5).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(6).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(7).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(8).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(9).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(10).setActionView(R.layout.menu_image);
        navigationView.getMenu().getItem(11).setActionView(R.layout.menu_image);
        navigationView.setItemIconTintList(null);
//        response = getIntent().getStringArrayExtra("respoce");

//        Toast.makeText(this, ""+response.body().getResponce() , Toast.LENGTH_SHORT).show();
    }

    private Fragment LoadGodamnFrags(Fragment mainFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.dasboard_frame , mainFragment);
        fragmentTransaction.commit();
        return  mainFragment;
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

        if (id == R.id.nav_homepage) {
            // Handle the camera action
        } else if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_buy_package) {

        } else if (id == R.id.nav_my_test) {

        }
        else if (id == R.id.nav_group) {

        } else if (id == R.id.nav_bookmark) {

        } else if (id == R.id.nav_news) {

        } else if (id == R.id.nav_offers) {

        } else if (id == R.id.nav_ex_offer) {

        }else if (id == R.id.nav_ask_expert) {

        }else if (id == R.id.nav_rate_us) {

        }else if (id == R.id.logout) {

        }else if (id == R.id.aboutus) {
            Intent aboutIntent = new Intent(MainActivity.this , About_all.class);
            startActivity(aboutIntent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
