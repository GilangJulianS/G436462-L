package com.itb.hmif.ganeshalife.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.itb.hmif.ganeshalife.R;
import com.itb.hmif.ganeshalife.controller.MainController;
import com.itb.hmif.ganeshalife.fragment.LoginFragment;

/**
 * Created by Yanfa on 5/12/2016.
 */
public class LoginActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fm;
    private MainController mainController;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_login_bg);

        fm = getSupportFragmentManager();
        mainController = new MainController();
        sharedPreferences = getSharedPreferences(getString(R.string.preferences_name), MODE_PRIVATE);

        String token = sharedPreferences.getString("token", "");

//        if(!token.equals("")){
//            Log.d("preferences", "token : " + token);
//            String username = sharedPreferences.getString("username", "");
//            String registrationId = sharedPreferences.getString("registerId", "");
//            mainController.USERNAME = username;
//            mainController.AUTH_TOKEN = token;
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
//        }else{
            fm.beginTransaction().replace(R.id.fragmentPlace,
                    new LoginFragment())
                    .setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
//        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home) {
            super.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return true;
    }
}
