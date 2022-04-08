package com.alican.bebeksimrehberi.F3;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.alican.bebeksimrehberi.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class thirdAdapter extends RecyclerView.Adapter<thirdAdapter.cardTasarimTutucu> {

    private Context mContext;
    private List<thirdName> thirdNameList;

    public thirdAdapter(Context mContext, List<thirdName> thirdNameList) {
        this.mContext = mContext;
        this.thirdNameList = thirdNameList;
    }

    public class cardTasarimTutucu extends RecyclerView.ViewHolder {

        private ImageView imageT;
        private TextView text;
        private CardView cardView3;

        public cardTasarimTutucu(@NonNull View itemView) {
            super(itemView);

            imageT = itemView.findViewById(R.id.settingsImage);
            text = itemView.findViewById(R.id.text);
            cardView3 = itemView.findViewById(R.id.cardView3);

        }
    }

    @NonNull
    @Override
    public thirdAdapter.cardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.third_card_design,parent,false);
        return new thirdAdapter.cardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull thirdAdapter.cardTasarimTutucu holder, int position) {

        final thirdName thirdName1 = thirdNameList.get(position);
        holder.text.setText(thirdName1.getText());

        //Picasso.get().load((thirdNameList.get(position).getImage())).into(holder.image);
        Picasso.get().load((thirdNameList.get(position).getImage())).into(holder.imageT);

        holder.cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position == 0){
                    //Toast.makeText(mContext,"Uygulama Puanlama",Toast.LENGTH_LONG).show();
                    ////Alert ile store yönlendirme

                    try {
                        mContext.startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("market://details?id=" + mContext.getPackageName())));
                    } catch (ActivityNotFoundException e) {
                        mContext.startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id=" + mContext.getPackageName())));
                    }

                }else if (position == 1){
                    //Toast.makeText(mContext,"uygulama Sürümü",Toast.LENGTH_LONG).show();
                    //Alert

                    AlertDialog.Builder ad = new AlertDialog.Builder(mContext);

                    ad.setTitle("Uygulama Sürümü");
                    ad.setMessage("2.0.0");
                    ad.setNegativeButton("Kapat", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    ad.create().show();

                }else if (position == 2){
                    //Toast.makeText(mContext,"İletişim",Toast.LENGTH_LONG).show();
                    //Alert

                    AlertDialog.Builder ad = new AlertDialog.Builder(mContext);

                    ad.setTitle("İletişim");
                    ad.setMessage("Mail : alican@aynadakiyazar.com");
                    ad.setNegativeButton("Kapat", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    ad.create().show();
                }

            }
        });



    }

    @Override
    public int getItemCount() {
        return thirdNameList.size();
    }


}
