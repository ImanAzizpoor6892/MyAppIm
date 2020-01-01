package com.example.myappim;

import IMFramework.IDatabaseHandler;
import IMFramework.fragment.IFragment;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;



public class MainActivity extends AppCompatActivity {
  BottomNavigationView navigationView;
  FrameLayout frameLayout;
  AppCompatActivity appCompatActivity;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      navigationView = findViewById(R.id.nav_id);
      frameLayout = findViewById(R.id.frame_lay);
      appCompatActivity = this;




      navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
          switch (menuItem.getItemId()) {
            case R.id.nav_sell:
              navigationView.setItemBackgroundResource(R.color.colorPrimary);
              new IFragment(new FragmentSell(), appCompatActivity, R.id.frame_lay);

              return true;

            case R.id.nav_buyer:
              navigationView.setItemBackgroundResource(R.color.colorPrimary);
              new IFragment(new FragmentBuyer(), appCompatActivity, R.id.frame_lay);
              return true;

            case R.id.nav_store:
              navigationView.setItemBackgroundResource(R.color.colorPrimaryDark);
              new IFragment(new FragmentStore(), appCompatActivity, R.id.frame_lay);
              return true;

            case R.id.nav_status:
              navigationView.setItemBackgroundResource(R.color.design_default_color_primary);
              new IFragment(new FragmentStatus(), appCompatActivity, R.id.frame_lay);
              return true;

            case R.id.nav_setting:
              navigationView.setItemBackgroundResource(R.color.colorSunFlower);
              new IFragment(new FragmentSetting(), appCompatActivity, R.id.frame_lay);
              return true;

            default:

              return false;
          }

        }
      });

    }








}
