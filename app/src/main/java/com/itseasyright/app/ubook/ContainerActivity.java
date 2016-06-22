package com.itseasyright.app.ubook;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.itseasyright.app.ubook.fragments.ExploreFragment;
import com.itseasyright.app.ubook.fragments.HomeFragment;
import com.itseasyright.app.ubook.fragments.NetworkFragment;
import com.itseasyright.app.ubook.fragments.PlannerFragment;
import com.itseasyright.app.ubook.fragments.ProfileFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class ContainerActivity extends AppCompatActivity implements OnMenuTabClickListener {
    private BottomBar mBottomBar;
    int tabIndex;
    int selectedIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItems(R.menu.main_menu);
        mBottomBar.setOnMenuTabClickListener(this);

    }

    @Override
    public void onMenuTabSelected(@IdRes int menuItemId) {

        switch (menuItemId){
            case R.id.homeTabButton:
                //for Animation
                tabAnimation(1, new HomeFragment(), "HOME");
                break;

            case R.id.plannerTabButton:
                tabAnimation(2, new PlannerFragment(), "PLANNER");
                break;

            case R.id.exploreTabButton:
                tabAnimation(3, new ExploreFragment(), "EXPLORE");
                break;

            case R.id.networkTabButton:
                tabAnimation(4, new NetworkFragment(), "NETWORK");
                break;

            case R.id.profileTabButton:
                tabAnimation(5, new ProfileFragment(), "PROFILE");
                break;

            default:
                break;
        }
    }

    public void tabAnimation(int tabIndex, Fragment fragment,String name)
    {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if(selectedIndex > tabIndex)
        {
            ft.setCustomAnimations(R.anim.slide_in_left, R.anim.abc_fade_out);
        }
        else
        {
            ft.setCustomAnimations(R.anim.slide_in_right, R.anim.abc_fade_out);
        }
        selectedIndex = tabIndex;
        ft.replace(R.id.fragmentContainer,  fragment, name);
        ft.commit();
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
