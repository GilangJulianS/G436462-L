package com.gilang.ganeshalife;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.gilang.custom.HomePagerAdapter;
import com.gilang.custom.Value;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

/**
 * Created by macair on 3/26/16.
 */
public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private MaterialViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);
	    mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
		    @Override
		    public HeaderDesign getHeaderDesign(int page) {
			    switch (page) {
				    case 0:
					    return HeaderDesign.fromColorResAndUrl(
							    R.color.blue,
							    "http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2014/06/wallpaper_51.jpg");
				    case 1:
					    return HeaderDesign.fromColorResAndUrl(
							    R.color.green,
							    "https://fs01.androidpit.info/a/63/0e/android-l-wallpapers-630ea6-h900.jpg");
				    case 2:
					    return HeaderDesign.fromColorResAndUrl(
							    R.color.cyan,
							    "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
				    case 3:
					    return HeaderDesign.fromColorResAndUrl(
							    R.color.red,
							    "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
			    }

			    //execute others actions if needed (ex : modify your header logo)

			    return null;
		    }
	    });
	    ViewPager pager = mViewPager.getViewPager();
	    pager.setAdapter(new HomePagerAdapter(getSupportFragmentManager(), this));

	    mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
	    mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());




	    Toolbar toolbar = mViewPager.getToolbar();
	    toolbar.setTitle("");
	    setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
//
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.nav_read_now){
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
            finish();
        } else if(id == R.id.nav_bookmark){
            Intent i = new Intent(this, NormalActivity.class);
            i.putExtra(Value.FRAGMENT_TYPE, Value.FRAGMENT_BOOKMARK);
            startActivity(i);
            finish();
        }else if(id == R.id.nav_my_library){
            Intent i = new Intent(this, NormalActivity.class);
            i.putExtra(Value.FRAGMENT_TYPE, Value.FRAGMENT_LIBRARY);
            startActivity(i);
            finish();
        }else if(id == R.id.nav_explore){
	        Intent i = new Intent(this, NormalActivity.class);
	        i.putExtra(Value.FRAGMENT_TYPE, Value.FRAGMENT_EXPLORE);
	        startActivity(i);
	        finish();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
