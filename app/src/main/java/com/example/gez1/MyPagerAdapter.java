package com.example.gez1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.gez1.Fragments.FragmentAciklama;
import com.example.gez1.Fragments.FragmentKonum;

public class MyPagerAdapter extends FragmentStateAdapter{

    public MyPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FragmentAciklama();
            case 1:
                return new FragmentKonum();
            default:
                return new FragmentAciklama();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }




}