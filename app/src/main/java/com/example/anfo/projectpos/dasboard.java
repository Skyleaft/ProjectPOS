package com.example.anfo.projectpos;


import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class dasboard extends Fragment {

    @BindView(R.id.btn_toko) Button bt_toko;
    @BindView(R.id.btn_barang) Button bt_barang;
    @BindView(R.id.btn_pegawai) Button bt_pegawai;
    @BindView(R.id.btn_transaksi) Button bt_transaksi;
    @BindView(R.id.btn_laporan) Button bt_laporan;

    Button toko;


    public dasboard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dasboard, container, false);
        final LinearLayout rootlayout = (LinearLayout) v.findViewById(R.id.linearLayout);
        toko = v.findViewById(R.id.btn_toko);

        final Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        final NavigationView navigationView = (NavigationView) getActivity().findViewById(R.id.nav_view);

        toko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataToko datok = new DataToko();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.flContent,datok).addToBackStack(null).commit();

                toolbar.setTitle(R.string.menu_datatoko);
                navigationView.setCheckedItem(R.id.nav_toko);
            }
        });



        /*bt_toko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataToko datok = new DataToko();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.flContent,datok).commit();

                //toolbar.setTitle(R.string.menu_datatoko);
                //navigationView.setCheckedItem(R.id.nav_toko);
            }
        });*/

        return v;
    }

}
