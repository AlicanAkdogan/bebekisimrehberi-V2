package com.alican.bebeksimrehberi.F2;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alican.bebeksimrehberi.Database;
import com.alican.bebeksimrehberi.F1.Names;
import com.alican.bebeksimrehberi.F1.NamesAdapter;
import com.alican.bebeksimrehberi.NamesDao;
import com.alican.bebeksimrehberi.R;

import java.util.List;

public class secondAdapter extends RecyclerView.Adapter<secondAdapter.cardTasarimTutucu> {

    private Context mContext;
    private List<secondName> secondNameList;
    private Database vt;

    public secondAdapter(Context mContext, List<secondName> secondNameList, Database vt) {
        this.mContext = mContext;
        this.secondNameList = secondNameList;
        this.vt = vt;
    }

    public class cardTasarimTutucu extends RecyclerView.ViewHolder {

        private TextView nameText2, namesExp2;
        private ImageView favImageView;

        public cardTasarimTutucu(@NonNull View itemView) {
            super(itemView);

            nameText2 = itemView.findViewById(R.id.nameText2);
            namesExp2 = itemView.findViewById(R.id.namesExp2);
            favImageView = itemView.findViewById(R.id.favImageView);
        }
    }


    @NonNull
    @Override
    public secondAdapter.cardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_card_design,parent,false);
        vt = new Database(mContext);
        return new cardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull secondAdapter.cardTasarimTutucu holder, int position) {

        final secondName secondName = secondNameList.get(position);

        //holder.namesText.setText(names.getName());
        //holder.namesExplanationText.setText(names.getNames_explanation());

        holder.nameText2.setText(secondName.getName());
        holder.namesExp2.setText(secondName.getNames_explanation());

        if (secondName.getFav().equals("1")){
            holder.favImageView.setImageResource(R.drawable.fav_active);
        }

        holder.favImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (secondName.getFav().equals("1")){


                    Toast.makeText(mContext,"Favori Listesinden Çıkarıldı",Toast.LENGTH_LONG).show();
                    holder.favImageView.setImageResource(R.drawable.fav_inactive);
                    new NamesDao().isimGuncelle(vt,secondName.getName_id(),"0");

                    secondNameList = new NamesDao().favList(vt);
                    notifyDataSetChanged();


                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return secondNameList.size();
    }


}


