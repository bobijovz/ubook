package com.itseasyright.app.ubook.fragments.ProfileContent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itseasyright.app.ubook.R;

/**
 * Created by Nico on 2/16/2017.
 */

public class ProfileEducation extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_education, container, false);
    }
}
