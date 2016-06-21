package com.itseasyright.app.ubook;

import android.support.annotation.IdRes;
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
        switch (menuItemId){
            case R.id.homeTabButton:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragmentContainer, new HomeFragment(), "HOME").
                        commit();
                break;
            case R.id.plannerTabButton:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragmentContainer, new PlannerFragment(), "PLANNER").
                        commit();
                break;
            case R.id.exploreTabButton:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragmentContainer, new ExploreFragment(), "EXPLORE").
                        commit();
                break;
            case R.id.networkTabButton:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragmentContainer, new NetworkFragment(), "NETWORK").
                        commit();
                break;
            case R.id.profileTabButton:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragmentContainer, new ProfileFragment(), "PROFILE").
                        commit();
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
