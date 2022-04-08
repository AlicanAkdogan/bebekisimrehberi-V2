package com.alican.bebeksimrehberi.F3;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alican.bebeksimrehberi.R;

import java.util.ArrayList;

public class ThirdFragment extends Fragment {

    private RecyclerView thirdRv;
    private Toolbar f3Toolbar;

    private ArrayList<thirdName> thirdNameArrayList;
    private thirdAdapter adapter;

    private ImageView settingsImage;
    private TextView settingsText;
    private Switch settingsSwitch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.third_fragment,container,false);

        f3Toolbar = rootView.findViewById(R.id.f3Toolbar);
        f3Toolbar.setTitle("Ayarlar");
        ((AppCompatActivity)getActivity()).setSupportActionBar(f3Toolbar);

        thirdRv = rootView.findViewById(R.id.thirdRv);
        thirdRv.setHasFixedSize(true);
        thirdRv.setLayoutManager(new LinearLayoutManager(getContext()));

        settingsImage = rootView.findViewById(R.id.settingsImage);
        //settingsText = rootView.findViewById(R.id.settingsTextView);
        //settingsSwitch = rootView.findViewById(R.id.settingsSwitch);


/*
       settingsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked){
                   ((AppCompatActivity)getActivity()).getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
               }else{
                  ((AppCompatActivity)getActivity()).getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
               }
           }
       });
 */

        thirdNameArrayList = new ArrayList<>();
        thirdNameArrayList.add(new thirdName(0,R.drawable.star,"Uygulamamızı Değerlendir"));
        thirdNameArrayList.add(new thirdName(1,R.drawable.information,"Uygulama Sürümü"));
        thirdNameArrayList.add(new thirdName(2,R.drawable.contact,"İletişim"));

        adapter = new thirdAdapter(getContext(),thirdNameArrayList);
        thirdRv.setAdapter(adapter);

        return rootView;

    }
}

































































