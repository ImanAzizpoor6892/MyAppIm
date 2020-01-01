package com.example.myappim;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;


import IMFramework.IDatabaseHandler;
import IMFramework.IRecyclerView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentSell extends Fragment {
  private View root;
  private ArrayList<MyContact> mData;
  private IRecyclerView adapter;
  private EditText edtIdKala, edtNumberKala;
  private SeekBar seekBarOffer;
  private Button btnAdd;
  private int offer;
  private TextView txtShowK,tvShResultDay,tvShOffers,tvShSod,tvShNums;
  private int idKala,numberK,offerK;
  SQLiteDatabase database;
  IDatabaseHandler databaseHandler;
  String NameK;
  int nums,resultSell, sod;





  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    root = inflater.inflate(R.layout.layout_fragment_sell, container, false);

    edtIdKala = root.findViewById(R.id.edt_id_k);
    edtNumberKala = root.findViewById(R.id.edt_count_kala);
    seekBarOffer = root.findViewById(R.id.seekBar);
    btnAdd = root.findViewById(R.id.button);
    txtShowK = root.findViewById(R.id.txt_show_name_k);
    tvShNums = root.findViewById(R.id.tv_show_nums);
    tvShOffers = root.findViewById(R.id.tv_show_offers);
    tvShResultDay = root.findViewById(R.id.tv_show_result_day);
    tvShSod = root.findViewById(R.id.tv_show_sod);
    offer = seekBarOffer.getProgress();
    mData = new ArrayList<>();
    databaseHandler = new IDatabaseHandler(this.getContext());
    database = databaseHandler.getWritableDatabase();


    RecyclerView recyclerView = root.findViewById(R.id.recycler_sell);
    recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    adapter = new IRecyclerView(this.getContext(), mData);
    recyclerView.setAdapter(adapter);





    seekBarOffer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        offerK = (progress);
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {
      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });


    btnAdd.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {



        Cursor cursor = database.rawQuery("SELECT * FROM tblKala WHERE idKala Like '" + Integer.parseInt(edtIdKala.getText().toString()) + "'", null);
        if (cursor.getCount() == 0) {

        } else {
          int id, idK, fiK = 0, fiMayeK = 0, priceNoOffer, priceOffer, profit;
          while (cursor.moveToNext()) {
            NameK = cursor.getString(cursor.getColumnIndex("name"));
            id = cursor.getInt(cursor.getColumnIndex("id"));
            idK = cursor.getInt(cursor.getColumnIndex("idKala"));
            fiK = cursor.getInt(cursor.getColumnIndex("fi"));
            fiMayeK = cursor.getInt(cursor.getColumnIndex("fiMaye"));
            offerK = cursor.getInt(cursor.getColumnIndex("offer"));
          }
            numberK = Integer.parseInt(edtNumberKala.getText().toString());

            priceNoOffer = fiK * numberK;
            priceOffer = priceNoOffer - ((priceNoOffer * offerK) / 100);
            profit = priceOffer - (fiMayeK * numberK);


           nums += numberK;
            resultSell += priceNoOffer;
            sod += profit;


          mData.add(new MyContact(txtShowK.getText().toString(), offerK, fiK, priceNoOffer, priceOffer, numberK, profit));
          adapter.notifyDataSetChanged();

        }
        cursor.close();




      tvShNums.setText("" + nums);
        tvShSod.setText("" + sod);
        tvShResultDay.setText("" + resultSell);





      }
    });

    edtIdKala.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
      }
      @Override
      public void afterTextChanged(Editable s) {
        try {
          txtShowK.setText(searchIDKala(Integer.parseInt(s.toString())));
          btnAdd.setEnabled(true);

        } catch (Exception e) {

        }

      }

    });
    return root;
  }

  public void insertData() {
    String query1 = "INSERT INTO 'tblKala' ('idKala','name','fi','fiMaye','offer') VALUES( 101,'LAMP 10 Wat',18000,15000,2)";
    database.execSQL(query1);
    String query2 = "INSERT INTO 'tblKala' ('idKala','name','fi','fiMaye','offer') VALUES( 102,'LAMP 50 Wat',110000,100000,7)";
    database.execSQL(query2);
    String query3 = "INSERT INTO 'tblKala' ('idKala','name','fi','fiMaye','offer') VALUES( 103,'LAMP 20 Wat',40000,32000,3)";
    database.execSQL(query3);
    String query4 = "INSERT INTO 'tblKala' ('idKala','name','fi','fiMaye','offer') VALUES( 104,'LAMP 40 Wat',85000,75000,4)";
    database.execSQL(query4);
  }

  public String searchIDKala(int IDK) {
    Cursor cursor = database.rawQuery("SELECT * FROM tblKala WHERE idKala Like '" + IDK + "'", null);
    if (cursor.getCount() == 0) {
      return "موجود نیست";
    } else {
      while (cursor.moveToNext()) {
        NameK = cursor.getString(cursor.getColumnIndex("name"));

      }
    }
    cursor.close();
    return NameK;
  }


}
