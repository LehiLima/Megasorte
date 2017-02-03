package com.lehi.megasorte;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SecoesAdapter mSecoesPagerAdapter;
    private Menu mMenu;
    private DBHelper mydb;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private Jogo mJogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSecoesPagerAdapter = new SecoesAdapter(getSupportFragmentManager(),this);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSecoesPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected

                Fragment fragment = ((SecoesAdapter)mViewPager.getAdapter()).getFragment(position);
                if(position==0 && fragment!=null){

                    mMenu.setGroupVisible(R.id.jogos,true);
                    mMenu.setGroupVisible(R.id.meus_jogos,false);
                    mMenu.setGroupVisible(R.id.sobremenu,true);
                    fragment.onResume();
                }else if (position==1 && fragment!=null){
                    mMenu.setGroupVisible(R.id.jogos,false);
                    mMenu.setGroupVisible(R.id.meus_jogos,true);
                    mMenu.setGroupVisible(R.id.sobremenu,true);
                    fragment.onResume();
                }else if (position==3 && fragment!=null){
                    fragment.onResume();
                }else {
                    mMenu.setGroupVisible(R.id.jogos,false);
                    mMenu.setGroupVisible(R.id.meus_jogos,false);
                    mMenu.setGroupVisible(R.id.sobremenu,true);
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.mMenu = menu;
        // mostra soment os menus que são do fragmento 1
        mMenu.setGroupVisible(R.id.jogos,true);
        mMenu.setGroupVisible(R.id.meus_jogos,false);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.seleciona) {
            Intent intent = new Intent(this, selecionarActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.action_settings){
            Intent intent = new Intent(this, ConferirJogo_Activity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.conferir_jogo_manual){
            Intent intent = new Intent(this, ConferirJogoManualActivity.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.sobre){
            Intent intent = new Intent(this, SobreActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("onStop Main Meus jogos","onStop Main Meus jogos");
    }
}
