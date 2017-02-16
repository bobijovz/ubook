package com.itseasyright.app.ubook.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.itseasyright.app.ubook.R;
import com.itseasyright.app.ubook.fragments.ProfileContent.ProfileEducation;
import com.itseasyright.app.ubook.fragments.ProfileContent.ProfileExperience;
import com.itseasyright.app.ubook.fragments.ProfileContent.ProfileFeed;
import com.itseasyright.app.ubook.fragments.ProfileContent.ProfileInformation;
import com.itseasyright.app.ubook.fragments.ProfileContent.ProfileSkills;
import com.itseasyright.app.ubook.views.ViewPagerAdapter;

/**
 * Created by jovijovs on 21/06/2016.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;
    private ImageView imageEdit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.profileViewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.profileTabButton);
        imageEdit = (ImageView) view.findViewById(R.id.image_edit_profile);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_rss_feed_black_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_info_black_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_school_black_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_work_black_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_star_black_24dp));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPagerAdapter = new ViewPagerAdapter(getFragmentManager());
        viewPagerAdapter.addFragment(new ProfileFeed(), "FEED");
        viewPagerAdapter.addFragment(new ProfileInformation(), "INFO");
        viewPagerAdapter.addFragment(new ProfileEducation(), "EDUCATION");
        viewPagerAdapter.addFragment(new ProfileExperience(), "EXPERIENCE");
        viewPagerAdapter.addFragment(new ProfileSkills(), "SKILLS");
        viewPagerAdapter.notifyDataSetChanged();
        viewPager.setAdapter(viewPagerAdapter);
        imageEdit.setOnClickListener(this);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_edit_profile:
                Toast.makeText(getContext(), "Edit!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
