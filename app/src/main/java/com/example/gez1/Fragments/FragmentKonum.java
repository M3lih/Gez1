package com.example.gez1.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gez1.R;
import com.google.android.material.tabs.TabItem;

public class FragmentKonum extends Fragment {

TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_konum,
                container, false);

        Intent ıntent3 = getActivity().getIntent();
        String yerKonum = ıntent3.getStringExtra("yerKonum");


        textView = view.findViewById(R.id.txtKonum);
        textView.setText(yerKonum);

return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}