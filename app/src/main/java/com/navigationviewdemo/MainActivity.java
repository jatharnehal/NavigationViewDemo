package com.navigationviewdemo;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.navigationviewdemo.Fragment.*;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setNavigationDrawer();
    }

    private void setNavigationDrawer() {

        drawerLayout=findViewById(R.id.drawer_layout);

        NavigationView navigationView=findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment=null;

                int itemId=item.getItemId();

                if(itemId==R.id.first)
                {
                    fragment=new FirstFragment();
                }
                else if(itemId==R.id.second)
                {
                    fragment=new SecondFragment();
                }
                else if(itemId==R.id.third)
                {
                    fragment=new ThirdFragment();
                }
                Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();

                if(fragment!=null)
                {
                    FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame,fragment);
                    transaction.commit();
                    drawerLayout.closeDrawers();
                    return true;
                }
                return false;
            }
        });

    }
}
