package com.gilang.ganeshalife;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.gilang.custom.Value;
import com.gilang.fragment.BookmarkFragment;
import com.gilang.fragment.CategoryListFragment;
import com.gilang.fragment.DetailFragment;
import com.gilang.fragment.ProfileFragment;

/**
 * Created by Gilang on 12/04/2016.
 */
public class CollapseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapse);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapseLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        collapseLayout.setExpandedTitleColor(Color.TRANSPARENT);

        Intent caller = getIntent();
        Bundle extras;
        int fragmentType = -1;
        if(caller != null){
            extras = caller.getExtras();
            if(extras != null){
                fragmentType = extras.getInt(Value.FRAGMENT_TYPE);
            }
        }
        FragmentManager manager = getSupportFragmentManager();
        if(fragmentType == Value.FRAGMENT_DETAIL) {
            manager.beginTransaction()
                    .replace(R.id.container, DetailFragment.newInstance(this))
                    .commit();
        }else if(fragmentType == Value.FRAGMENT_CATEGORY_LIST){
            manager.beginTransaction()
                    .replace(R.id.container, CategoryListFragment.newInstance(this))
                    .commit();
        }else if(fragmentType == Value.FRAGMENT_PROFILE){
            manager.beginTransaction()
                    .replace(R.id.container, ProfileFragment.newInstance(this))
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        FragmentManager manager = getSupportFragmentManager();
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(manager.getBackStackEntryCount() > 0){
            manager.popBackStack();
        }else {
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
        if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

}
