package com.itseasyright.app.ubook;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.itseasyright.app.ubook.fragments.ExploreFragment;
import com.itseasyright.app.ubook.fragments.HomeFragment;
import com.itseasyright.app.ubook.fragments.NetworkFragment;
import com.itseasyright.app.ubook.fragments.PlannerFragment;
import com.itseasyright.app.ubook.fragments.ProfileFragment;
import com.itseasyright.app.ubook.views.ViewPagerAdapter;
import com.itseasyright.app.ubook.views.adapters.NonSwipeableViewPager;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class ContainerActivity extends AppCompatActivity implements OnMenuTabClickListener {
    private BottomBar mBottomBar;

    private NonSwipeableViewPager nonSwipeableViewPager;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    int tabIndex;
    int selectedIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        nonSwipeableViewPager = (NonSwipeableViewPager) findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new HomeFragment(), "HOME");
        viewPagerAdapter.addFragment(new PlannerFragment(), "PLANNER");
        viewPagerAdapter.addFragment(new ExploreFragment(), "EXPLORE");
        viewPagerAdapter.addFragment(new NetworkFragment(), "NETWORK");
        viewPagerAdapter.addFragment(new ProfileFragment(), "PROFILE");

        viewPagerAdapter.notifyDataSetChanged();
        nonSwipeableViewPager.setAdapter(viewPagerAdapter);

        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItems(R.menu.main_menu);
        mBottomBar.setOnMenuTabClickListener(this);
    }

    @Override
    public void onMenuTabSelected(@IdRes int menuItemId) {

        switch (menuItemId){
            case R.id.homeTabButton:
                //for Animation
                nonSwipeableViewPager.setCurrentItem(0);
                break;

            case R.id.plannerTabButton:
                nonSwipeableViewPager.setCurrentItem(1);
                break;

            case R.id.exploreTabButton:
                nonSwipeableViewPager.setCurrentItem(2);
                break;

            case R.id.networkTabButton:
                nonSwipeableViewPager.setCurrentItem(3);
                break;

            case R.id.profileTabButton:
                nonSwipeableViewPager.setCurrentItem(4);
                break;

            default:
                break;
        }
    }

    @Override
    public void onMenuTabReSelected(@IdRes int menuItemId) {

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
    }
}
