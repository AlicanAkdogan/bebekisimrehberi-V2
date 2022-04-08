package com.alican.bebeksimrehberi.F1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.alican.bebeksimrehberi.Database;
import com.alican.bebeksimrehberi.NamesDao;
import com.alican.bebeksimrehberi.R;

import java.util.List;

public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.cardTasarimTutucu> {

    private Context mContext;
    private List<Names> namesList;
    private Database vt;

    public NamesAdapter(Context mContext, List<Names> namesList, Database vt) {
        this.mContext = mContext;
        this.namesList = namesList;
        this.vt = vt;
    }

    public class cardTasarimTutucu extends RecyclerView.ViewHolder {

        //private TextView namesText, namesExplanationText;
        private TextView nameText2, namesExp2;
        private ImageView favImageView;
        private CardView cardView;

        public cardTasarimTutucu(@NonNull View itemView) {
            super(itemView);

            //namesText = itemView.findViewById(R.id.namesText);
            //namesExplanationText = itemView.findViewById(R.id.namesExplanationText);

            nameText2 = itemView.findViewById(R.id.nameText2);
            namesExp2 = itemView.findViewById(R.id.namesExp2);
            favImageView = itemView.findViewById(R.id.favImageView);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }

    @NonNull
    @Override
    public cardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //vt = new Database(mContext);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_card_design,parent,false);
        vt = new Database(mContext);
        return new cardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cardTasarimTutucu holder, int position) {

        final Names names = namesList.get(position);

        holder.nameText2.setText(names.getName());
        holder.namesExp2.setText(names.getNames_explanation());

        if (names.getFav().equals("1")){
            holder.favImageView.setImageResource(R.drawable.fav_active);
        }else if(names.getFav().equals("0")){
            holder.favImageView.setImageResource(R.drawable.fav_inactive);
        }

        holder.favImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(names.getFav().equals("0")){

                    Toast.makeText(mContext,"Favori Eklendi",Toast.LENGTH_LONG).show();
                    holder.favImageView.setImageResource(R.drawable.fav_active);
                    new NamesDao().isimGuncelle(vt,names.getName_id(),"1");

                    namesList = new NamesDao().tumİsimler(vt);
                    notifyDataSetChanged();

                }else if (names.getFav().equals("1")){


                    Toast.makeText(mContext,"Favori Listesinden Çıkarıldı",Toast.LENGTH_LONG).show();
                    holder.favImageView.setImageResource(R.drawable.fav_inactive);
                    new NamesDao().isimGuncelle(vt,names.getName_id(),"0");

                    namesList = new NamesDao().tumİsimler(vt);
                    notifyDataSetChanged();


                }else{
                    Toast.makeText(mContext,"Bir Sorun Oluştur, Tekrar deneyiniz..",Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return namesList.size();
    }

}






































