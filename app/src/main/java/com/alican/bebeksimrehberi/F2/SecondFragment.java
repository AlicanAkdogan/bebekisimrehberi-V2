package com.alican.bebeksimrehberi.F2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alican.bebeksimrehberi.Database;
import com.alican.bebeksimrehberi.DatabaseCopyHelper;
import com.alican.bebeksimrehberi.NamesDao;
import com.alican.bebeksimrehberi.R;

import java.io.IOException;
import java.util.ArrayList;

public class SecondFragment extends Fragment {

    private RecyclerView secondRV;
    private Toolbar f2Toolbar;
    private ArrayList<secondName> secondNameArrayList;
    private secondAdapter adapter;

    private Database vt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.second_fragment,container,false);

        f2Toolbar = rootView.findViewById(R.id.f2Toolbar);
        f2Toolbar.setTitle("Favoriler");
        ((AppCompatActivity)getActivity()).setSupportActionBar(f2Toolbar);

        vt = new Database(getActivity());
        veritabaniKopyala();

        secondRV = rootView.findViewById(R.id.secondRv);
        secondRV.setHasFixedSize(true);
        secondRV.setLayoutManager(new LinearLayoutManager(getContext()));

        /*
        secondNameArrayList = new ArrayList<>();
        secondNameArrayList.add(new secondName(1,"test","testset","0"));
        */

        secondNameArrayList = new NamesDao().favList(vt);

        adapter = new secondAdapter(getContext(),secondNameArrayList,vt);
        secondRV.setAdapter(adapter);

        return rootView;

    }

    public void veritabaniKopyala(){

        DatabaseCopyHelper databaseCopyHelper = new DatabaseCopyHelper(getActivity());
        try {
            databaseCopyHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        databaseCopyHelper.openDataBase();

    }
}





































