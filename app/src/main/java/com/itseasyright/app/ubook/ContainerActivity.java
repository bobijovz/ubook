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
        // TODO: NV Add custom animations for switching of tabs
        //for Animation
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        switch (menuItemId){
            case R.id.homeTabButton:


                ft.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
                ft.replace(R.id.fragmentContainer, new HomeFragment(), "HOME");
                // Start the animated transition.
                ft.commit();
                break;

            case R.id.plannerTabButton:
                ft.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
                ft.replace(R.id.fragmentContainer, new PlannerFragment(), "PLANNER");
                // Start the animated transition.
                ft.commit();
                break;

            case R.id.exploreTabButton:
                ft.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
                ft.replace(R.id.fragmentContainer, new ExploreFragment(), "EXPLORE");
                // Start the animated transition.
                ft.commit();
                break;

            case R.id.networkTabButton:
                ft.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
                ft.replace(R.id.fragmentContainer, new NetworkFragment(), "NETWORK");
                // Start the animated transition.
                ft.commit();
                break;

            case R.id.profileTabButton:
                ft.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
                ft.replace(R.id.fragmentContainer, new ProfileFragment(), "PROFILE");
                // Start the animated transition.
                ft.commit();
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
