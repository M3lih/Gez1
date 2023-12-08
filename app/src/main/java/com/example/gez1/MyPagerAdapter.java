package com.example.gez1;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gez1.Fragments.FragmentAciklama;
import com.example.gez1.Fragments.FragmentKonum;

public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // Her bir sekme için ilgili fragment'ı döndürün
        switch (position) {
            case 0:
                return new FragmentAciklama();
            case 1:
                return new FragmentKonum();
            // Diğer sekme durumları ekleyebilirsiniz.
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Toplam sekme sayısını döndürün
        return 2; // Örneğin, 2 sekme
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Her sekme için başlık belirleyin
        switch (position) {
            case 0:
                return "Sekme 1";
            case 1:
                return "Sekme 2";
            // Diğer sekme başlıklarını ekleyebilirsiniz.
            default:
                return null;
        }
    }
}