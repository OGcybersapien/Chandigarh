package xyz.cybersapien.chandigarh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Malls extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Creating an ArrayList of Object Place with information like Place Name, Address and the Image Drawable Id
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Elante Mall", "Industrial Area\nPhase 1\nChandigarh",R.drawable.elante_mall));
        places.add(new Place("TDI Mall", "Sector 17\nChandigarh", R.drawable.tdi_mall));
        places.add(new Place("DLF City Centre", "Plot no. 1 & 2\nRajeev Gandhi IT Park\nChandigarh", R.drawable.dlf_city_centre));
        places.add(new Place("City Emporium Shopping Mall", "Industrial Area\nPhase 1\nChandigarh",R.drawable.city_emporium));
        places.add(new Place("City Plaza","Sector 17\nChandigarh",R.drawable.sector_seventeen));
        places.add(new Place("North Country Mall","NH-21\nSector-117\nMohali, Chandigarh",R.drawable.ncm_mohali));
        places.add(new Place("Paras Down Town Square","Zirakpur\nChandigarh",R.drawable.paras_downtown_square));


        //Creating a custom Array Adapter for this Malls ArrayList
        PlacesAdapter mainAdapter = new PlacesAdapter(this, places);

        //Calling a listView to attach the Places Adapter to and then attaching it
        ListView mainListView = (ListView) findViewById(R.id.places_list);
        mainListView.setAdapter(mainAdapter);
    }
}
