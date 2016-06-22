package com.itseasyright.app.ubook;

import android.support.annotation.IdRes;
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

        // TODO: NV Simplify codes - Method
        //for Animation
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        switch (menuItemId){
            case R.id.homeTabButton:

                tabIndex = 1;
                if(selectedIndex > tabIndex)
                {
                    ft.setCustomAnimations(R.anim.slide_in_left, R.anim.abc_fade_out);
                }
                else
                {
                    ft.setCustomAnimations(R.anim.slide_in_right, R.anim.abc_fade_out);

                }
                selectedIndex = tabIndex;

                ft.replace(R.id.fragmentContainer, new HomeFragment(), "HOME");
                // Start the animated transition.
                ft.commit();
                break;

            case R.id.plannerTabButton:

                tabIndex = 2;
                if(selectedIndex > tabIndex)
                {
                    ft.setCustomAnimations(R.anim.slide_in_left, R.anim.abc_fade_out);
                }
                else
                {
                    ft.setCustomAnimations(R.anim.slide_in_right, R.anim.abc_fade_out);

                }
                selectedIndex = tabIndex;

                ft.replace(R.id.fragmentContainer, new PlannerFragment(), "PLANNER");
                // Start the animated transition.
                ft.commit();
                break;

            case R.id.exploreTabButton:

                tabIndex = 3;
                if(selectedIndex > tabIndex)
                {
                    ft.setCustomAnimations(R.anim.slide_in_left, R.anim.abc_fade_out);
                }
                else
                {
                    ft.setCustomAnimations(R.anim.slide_in_right, R.anim.abc_fade_out);

                }
                selectedIndex = tabIndex;

                ft.replace(R.id.fragmentContainer, new ExploreFragment(), "EXPLORE");
                // Start the animated transition.
                ft.commit();
                break;

            case R.id.networkTabButton:

                tabIndex = 4;
                if(selectedIndex > tabIndex)
                {
                    ft.setCustomAnimations(R.anim.slide_in_left, R.anim.abc_fade_out);
                }
                else
                {
                    ft.setCustomAnimations(R.anim.slide_in_right, R.anim.abc_fade_out);

                }
                selectedIndex = tabIndex;

                ft.replace(R.id.fragmentContainer, new NetworkFragment(), "NETWORK");
                // Start the animated transition.
                ft.commit();
                break;

            case R.id.profileTabButton:

                tabIndex = 5;
                if(selectedIndex > tabIndex)
                {
                    ft.setCustomAnimations(R.anim.slide_in_left, R.anim.abc_fade_out);
                }
                else
                {
                    ft.setCustomAnimations(R.anim.slide_in_right, R.anim.abc_fade_out);

                }
                selectedIndex = tabIndex;

                ft.replace(R.id.fragmentContainer, new ProfileFragment(), "PROFILE");
                // Start the animated transition.
                ft.commit();
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
