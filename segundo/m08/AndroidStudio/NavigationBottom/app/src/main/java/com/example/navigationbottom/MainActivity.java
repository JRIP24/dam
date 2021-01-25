package com.example.navigationbottom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout frameLayout;
    private Fragment homeFragment;
    private Fragment profileFragment;
    private Fragment settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hooks
        mMainNav = findViewById(R.id.main_nav);
        frameLayout = findViewById(R.id.main_frame);

        mMainNav.setItemBackgroundResource(R.color.design_default_color_primary_dark);

        //homeFragment = new HomeFragment();
        homeFragment = HomeFragment.newInstance("home1", "home2");
        //profileFragment = new ProfileFragment();
        profileFragment = ProfileFragment.newInstance("profile1", "profile2");
        //settingsFragment = new SettingsFragment();
        settingsFragment = SettingsFragment.newInstance("Setting1", "Setting2");

        displayFragment(homeFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.nav_home:
                        mMainNav.setItemBackgroundResource(R.color.design_default_color_on_primary);
                        displayFragment(homeFragment);
                        return true;

                    case R.id.nav_profile:
                        mMainNav.setItemBackgroundResource(R.color.design_default_color_on_secondary);
                        displayFragment(profileFragment);
                        return true;

                    case R.id.nav_settings:
                        mMainNav.setItemBackgroundResource(R.color.design_default_color_secondary_variant);
                        displayFragment(settingsFragment);
                        return true;

                    default:
                        return false;

                }


            }
        });

    }

    private void displayFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);

        fragmentTransaction.commit();
    }
}