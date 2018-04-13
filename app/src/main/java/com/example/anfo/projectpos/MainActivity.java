package com.example.anfo.projectpos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(null == savedInstanceState) {
            //set Main Content
            dasboard dasb = new dasboard();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.flContent,dasb).commit();

            toolbar.setTitle(R.string.menu_dasboard);
            navigationView.setCheckedItem(R.id.nav_dasbord);
        }
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
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (id == R.id.nav_dasbord) {
            dasboard dsbord = new dasboard();
            ft.replace(R.id.flContent,dsbord).commit();
            toolbar.setTitle(R.string.menu_dasboard);
        } else if (id == R.id.nav_toko) {
            DataToko fdatok = new DataToko();
            ft.replace(R.id.flContent,fdatok).commit();
        } else if (id == R.id.nav_barang) {
            Data_Barang fdabar = new Data_Barang();
            ft.replace(R.id.flContent,fdabar).commit();
        } else if (id == R.id.nav_pegawai) {
            data_karyawan fdakar = new data_karyawan();
            ft.replace(R.id.flContent,fdakar).commit();
        }
          else if (id == R.id.nav_laporan) {
            laporan flaporan = new laporan();
            ft.replace(R.id.flContent,flaporan).commit();
        }
          else if (id == R.id.nav_Transaksi) {
            transaksi ftransaksi = new transaksi();
            ft.replace(R.id.flContent,ftransaksi).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
