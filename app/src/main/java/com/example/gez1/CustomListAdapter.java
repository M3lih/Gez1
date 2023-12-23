package com.example.gez1;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatCallback;
import androidx.cardview.widget.CardView;

import com.example.gez1.Fragments.FragmentAciklama;
import com.example.gez1.Models.MyModel;
import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import com.squareup.picasso.Picasso;


public class CustomListAdapter extends BaseAdapter {

    CardView cardsehir;
    TextView textView;


    Context c;
    ArrayList<MyModel> users;

    public CustomListAdapter(Context c, ArrayList<MyModel> users) {
        this.c = c;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public MyModel getItem(int position) {
        return this.users.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }


    public String getYerIsim(String yerIsim) {
        return yerIsim;
    }


    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(c).inflate(R.layout.json_data_list, viewGroup, false);
        }

        TextView txtYerIsim = (TextView) view.findViewById(R.id.txtYerIsim);
        ImageView imageView = view.findViewById(R.id.yerimg);
        cardsehir = view.findViewById(R.id.cardsehir);


        Object getrow = this.users.get(i);
        LinkedTreeMap<Object, Object> rowmap = (LinkedTreeMap) getrow;
        String yerIsim = rowmap.get("yerIsim").toString();
        String yerID = rowmap.get("yerID").toString();
        String yerAciklama = rowmap.get("yerAciklama").toString();
        String yerKonum = rowmap.get("yerKonum").toString();
        String yerKategori = rowmap.get("yerKategori").toString();
        String yerResim = rowmap.get("yerResim").toString();


        txtYerIsim.setText(yerIsim);
        Picasso.get().load(yerResim).into(imageView);


        cardsehir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(c,YerDetayActivity.class);
                intent.putExtra("yerIsim", yerIsim);
                intent.putExtra("yerID", yerID);
                intent.putExtra("yerAciklama", yerAciklama);
                intent.putExtra("yerKonum", yerKonum);
                intent.putExtra("yerKategori", yerKategori);
                intent.putExtra("yerResim", yerResim);


                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                c.startActivity(intent);




            }
        });


        return view;
    }


}