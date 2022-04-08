package com.alican.bebeksimrehberi;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.alican.bebeksimrehberi.F1.Names;
import com.alican.bebeksimrehberi.F2.secondName;

import java.util.ArrayList;

public class NamesDao {

    public ArrayList<Names> tumİsimler(Database vt){

        ArrayList<Names> modelArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM babynames",null);

        while (c.moveToNext()){
            Names m1 = new Names(c.getInt(c.getColumnIndex("name_id")),
                    c.getString(c.getColumnIndex("name")),
                    c.getString(c.getColumnIndex("name_explanation")),
                    c.getString(c.getColumnIndex("fav"))
            );

            modelArrayList.add(m1);

        }

        return modelArrayList;
    }

    public ArrayList<secondName> favList(Database vt){

        ArrayList<secondName> modelArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();

        //Cursor c = db.rawQuery("SELECT * FROM babynames",null);
        Cursor c = db.rawQuery("SELECT * FROM babynames WHERE fav='1'",null);

        while (c.moveToNext()){
            secondName m1 = new secondName(c.getInt(c.getColumnIndex("name_id")),
                    c.getString(c.getColumnIndex("name")),
                    c.getString(c.getColumnIndex("name_explanation")),
                    c.getString(c.getColumnIndex("fav"))
            );

            modelArrayList.add(m1);

        }

        return modelArrayList;
    }

    public ArrayList<Names> kelimeAra(Database vt,String aramaKelime){

        ArrayList<Names> modelArrayList = new ArrayList<>();
        SQLiteDatabase db = vt.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM babynames WHERE name like '%"+aramaKelime+"%'",null);

        while (c.moveToNext()){
            Names m1 = new Names(c.getInt(c.getColumnIndex("name_id")),
                    c.getString(c.getColumnIndex("name")),
                    c.getString(c.getColumnIndex("name_explanation")),
                    c.getString(c.getColumnIndex("fav"))
            );

            modelArrayList.add(m1);

        }

        return modelArrayList;
    }

    public void isimSil(Database vt, int name_id){

        SQLiteDatabase dbx = vt.getWritableDatabase();
        dbx.delete("babynames","name_id=?",new String[]{String.valueOf(name_id)});
        dbx.close();

    }

    public void isimGuncelle(Database vt, int name_id, String fav){

        SQLiteDatabase dbx = vt.getWritableDatabase();
        ContentValues degerler = new ContentValues();

        degerler.put("fav", fav);

        dbx.update("babynames",degerler,"name_id=?",new String[]{String.valueOf(name_id)});
        dbx.close();

    }

}
