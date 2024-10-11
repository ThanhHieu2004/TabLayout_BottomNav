package com.example.tablayout_bottomnav;
import com.example.tablayout_bottomnav.R;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.tablayout_bottomnav.Fragment.HomePageFragement;
import com.example.tablayout_bottomnav.Fragment.SecondFragment;
import com.example.tablayout_bottomnav.Fragment.ThirdFragment;
import com.example.tablayout_bottomnav.Fragment.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    FrameLayout frameLayout;
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        tabLayout = (TabLayout) findViewById(R.id.idTablayout);
//        frameLayout = (FrameLayout) findViewById(R.id.idFrameLayout);
//        getSupportFragmentManager().beginTransaction().replace(R.id.idFrameLayout, new HomePageFragement()).
//                addToBackStack(null).commit();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                Fragment fragment = null;
//                switch(tab.getPosition()){
//                    case 0:{
//                        fragment = new HomePageFragement();
//                        break;
//                    }
//                    case 1:{
//                        fragment = new SecondFragment();
//                        break;
//                    }
//                    case 2:{
//                        fragment = new ThirdFragment();
//                        break;
//                    }
//                }
//                getSupportFragmentManager().beginTransaction().replace(R.id.idFrameLayout, fragment).
//                        setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });

        viewPager = findViewById(R.id.idViewPager);
        bottomNavigationView = findViewById(R.id.idBottomNavigation);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);

        // Drag ViewPager
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.news).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.users).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.favorite).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Log.d(String.valueOf(item.getItemId()), "Test id");
                switch (item.getItemId()){
//                    case R.id.news:
                    case 2131231035:
                        viewPager.setCurrentItem(0);
                        break;
//                    case R.id.users:
                    case 2131231207:
                        viewPager.setCurrentItem(1);
                        break;
//                    case R.id.favorite:
                    case 2131230904:
                        viewPager.setCurrentItem(2);
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });
    }
}