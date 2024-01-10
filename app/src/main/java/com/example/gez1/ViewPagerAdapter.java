package com.example.gez1;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gez1.Fragments.EgitimFragment;
import com.example.gez1.Fragments.GeziFragment;
import com.example.gez1.Fragments.RestoranFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new GeziFragment();
            case 1:
                return new EgitimFragment();
            case 2:
                return new RestoranFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3; // Number of tabs
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Set tab titles
        switch (position) {
            case 0:
                return "Gezi";
            case 1:
                return "Egitim";
            case 2:
                return "Restoran";
        }
        return null;
    }
}