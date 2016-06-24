package com.itseasyright.app.ubook.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itseasyright.app.ubook.R;
import com.itseasyright.app.ubook.fragments.ProfileContent.ProfileAchievement;
import com.itseasyright.app.ubook.fragments.ProfileContent.ProfileExperience;
import com.itseasyright.app.ubook.fragments.ProfileContent.ProfileFeed;
import com.itseasyright.app.ubook.fragments.ProfileContent.ProfileInformation;
import com.itseasyright.app.ubook.views.ViewPagerAdapter;

/**
 * Created by jovijovs on 21/06/2016.
 */
public class ProfileFragment extends Fragment {
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.profileViewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.profileTabButton);
        tabLayout.addTab(tabLayout.newTab().setText("FEED"));
        tabLayout.addTab(tabLayout.newTab().setText("INFO"));
        tabLayout.addTab(tabLayout.newTab().setText("ACHIEVEMENT"));
        tabLayout.addTab(tabLayout.newTab().setText("EXPERIENCE"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        viewPagerAdapter = new ViewPagerAdapter(getFragmentManager());
        viewPagerAdapter.addFragment(new ProfileFeed(), "FEED");
        viewPagerAdapter.addFragment(new ProfileInformation(), "INFO");
        viewPagerAdapter.addFragment(new ProfileAchievement(), "ACHIEVEMENT");
        viewPagerAdapter.addFragment(new ProfileExperience(), "EXPERIENCE");
        viewPagerAdapter.notifyDataSetChanged();
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
