package net.mysirg.navibarrecylerview;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import net.mysirg.navibarrecylerview.Fragment.FragmentCamera;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout mDawerLayout;
    NavigationView mNavigationView;
    ActionBarDrawerToggle mToggle;
    Toolbar mToolbar;
    RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(mToolbar);
        findids();

        ActionBarDrawerToggle mToggle = new ActionBarDrawerToggle(
                this, mDawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();


        setListener();


       // FragmentManager fragmentManager= getSupportFragmentManager();



    }

    private void findids() {

        mDawerLayout= findViewById(R.id.drawer_layout);
        mNavigationView=findViewById(R.id.nav_view);
        mToolbar=findViewById(R.id.toolbar);
        mRelativeLayout=findViewById(R.id.container_layout);

    }
    @Override
    public void onBackPressed() {
        mDawerLayout =  findViewById(R.id.drawer_layout);
        if (mDawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public void setListener()
    {
        mNavigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment= null;

        switch (menuItem.getItemId()){


            case R.id.camera_id :
                fragment= new FragmentCamera();
                break;

        }
        mDawerLayout.closeDrawer(GravityCompat.START);
        return true;


    }
}
