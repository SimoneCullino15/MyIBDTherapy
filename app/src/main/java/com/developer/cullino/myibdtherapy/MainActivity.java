package com.developer.cullino.myibdtherapy;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    String[] pageTitle; // nomi dei 2 fragment (farmaci attuali e storico farmaci)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageTitle = new String[]{"ATTUALI", "STORICO"};

        TabLayout tabLayout = findViewById(R.id.tabLayout1); //tab dove metto i nomi dei fragment
        ViewPager viewPager = findViewById(R.id.viewPager1); //dove ci metterò layout dei fragment
        //adapter del viewPager (dove ci metto i fragment)
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(adapter);
        //listener per cambio fragment (scorrimento orizzontale)
        viewPager.addOnPageChangeListener(new WizardPageChangeListener());
        //attacco viewpager sotto tab
        tabLayout.setupWithViewPager(viewPager);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter{

        public int WIZARD_PAGES_COUNT = 2;
        Context context;

        public ViewPagerAdapter(FragmentManager fm, Context ctx) {
            super(fm);
            context = ctx;
        }

        @Override
        public Fragment getItem(int i) {
            switch (i){
                case 0 :
                    return new MainFragment(0,context);
                case 1:
                    return new MainFragment(1,context);
            }
            return new MainFragment(0,context);
        }

        @Override
        public int getCount() {
            return WIZARD_PAGES_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position){
            return pageTitle[position];
        }
    }

    private class WizardPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }

}

