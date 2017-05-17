package com.example.fresh.getfresh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fresh.getfresh.helpjars.MyDatabase;
import com.example.fresh.getfresh.helpjars.Training;

import java.util.ArrayList;

public class ZweiersplitActivity extends AppCompatActivity
{
    TextView setb;
    TextView widb;
    TextView sett;
    TextView widt;
    TextView setbi;
    TextView widbi;
    TextView setr;
    TextView widr;
    TextView setbe;
    TextView widbe;
    TextView setba;
    TextView widba;
    TextView sets;
    TextView wids;
    TextView setbe2;
    TextView widbe2;

    MyDatabase db;
    ArrayList<Training> trainingsliste;
    boolean auf;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2erspli);
        /*
        setb=(TextView)findViewById(R.id.);
        widb=(TextView)findViewById(R.id.);
        sett=(TextView)findViewById(R.id.);
        widt=(TextView)findViewById(R.id.);
        setbi=(TextView)findViewById(R.id.);
        widbi=(TextView)findViewById(R.id.);
        setr=(TextView)findViewById(R.id.);
        widr=(TextView)findViewById(R.id.);
        setbe=(TextView)findViewById(R.id.);
        widbe=(TextView)findViewById(R.id.);
        setba=(TextView)findViewById(R.id.);
        widba=(TextView)findViewById(R.id.);
        sets=(TextView)findViewById(R.id.);
        wids=(TextView)findViewById(R.id.);
        setbe2=(TextView)findViewById(R.id.);
        widbe2=(TextView)findViewById(R.id.);
        */

        //#####
        db = new MyDatabase(this);
        Bundle c = getIntent().getExtras();
        auf=c.getInt("training") != 0;
        //trainingsliste=db.loadUebungen(c.getInt("training") != 0);
        ausfuellen();
    }

    public void onClickErnaehrungsplan2(View v)    {
        Intent intent = new Intent(getApplicationContext(), ErnahrungsplanActivity.class);
        Bundle c = getIntent().getExtras();
        Bundle b = new Bundle();
        b.putInt("training",c.getInt("training"));
        intent.putExtras(b);
        startActivity(intent);
    }

    private void ausfuellen(){
        setb.setText(db.getTraining(auf,"Brust").getSaetze());
        widb.setText(db.getTraining(auf,"Brust").getWiederholungen());
        if (auf) {
            sett.setText(db.getTraining(auf, "Trizeps").getSaetze());
            widt.setText(db.getTraining(auf, "Trizeps").getWiederholungen());
            setb.setText(db.getTraining(auf,"Bizeps").getSaetze());
            widb.setText(db.getTraining(auf,"Bizeps").getWiederholungen());
        }else {
            sett.setText(db.getTraining(auf, "Arme").getSaetze());
            widt.setText(db.getTraining(auf, "Arme").getWiederholungen());
        }
        setr.setText(db.getTraining(auf,"Ruecken").getSaetze());
        widr.setText(db.getTraining(auf,"Ruecken").getWiederholungen());
        setbe.setText(db.getTraining(auf,"Beine").getSaetze());
        widbe.setText(db.getTraining(auf,"Beine").getWiederholungen());
        setba.setText(db.getTraining(auf,"Bauch").getSaetze());
        widba.setText(db.getTraining(auf,"Bauch").getWiederholungen());
        sets.setText(db.getTraining(auf,"Schultern").getSaetze());
        wids.setText(db.getTraining(auf,"Schultern").getWiederholungen());
        setbe2.setText(db.getTraining(auf,"Beine").getSaetze());
        widbe2.setText(db.getTraining(auf,"Beine").getWiederholungen());
    }


}
