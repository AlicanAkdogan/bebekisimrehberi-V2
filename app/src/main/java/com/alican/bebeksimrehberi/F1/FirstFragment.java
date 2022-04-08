package com.alican.bebeksimrehberi.F1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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

public class FirstFragment extends Fragment implements View.OnCreateContextMenuListener, SearchView.OnQueryTextListener {

    private RecyclerView rv;
    private ArrayList<Names> namesArrayList;
    private NamesAdapter adapter;

    private Toolbar f1Toolbar;
    private Database vt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.first_fragment,container,false);
        setHasOptionsMenu(true);

        f1Toolbar = rootView.findViewById(R.id.f1Toolbar);
        f1Toolbar.setTitle("Bebek İsim Rehberi");
        ((AppCompatActivity)getActivity()).setSupportActionBar(f1Toolbar);

        vt = new Database(getActivity());
        veritabaniKopyala();

        rv = rootView.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        /*
        namesArrayList = new ArrayList<>();
        namesArrayList.add(new Names(1,"gfdgfdgd","gfdgdfg","0"));
        */

        namesArrayList = new NamesDao().tumİsimler(vt);

        adapter = new NamesAdapter(getContext(),namesArrayList,vt);
        rv.setAdapter(adapter);


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

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        getActivity().getMenuInflater().inflate(R.menu.toolbar_search,menu);
        MenuItem item = menu.findItem(R.id.action_ara);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.e("Gönderilen Arama",query);
        aramaYap(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("Harf Girdikçe",newText);
        aramaYap(newText);
        return false;
    }

    public void aramaYap(String aramaKelime){

        namesArrayList = new NamesDao().kelimeAra(vt,aramaKelime);

        adapter = new NamesAdapter(getContext(),namesArrayList,vt);
        rv.setAdapter(adapter);

    }
}































