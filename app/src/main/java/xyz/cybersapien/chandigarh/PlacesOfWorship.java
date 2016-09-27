package xyz.cybersapien.chandigarh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlacesOfWorship extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Creating an ArrayList of Object Place with information like Place Name, Address and the Image Drawable Id
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Mata Mansa Devi Temple", "Mansa Devi Complex\nSector 4\nPanchkula",R.drawable.mansa_devi));
        places.add(new Place("Saketri Shiva Temple", "Saketri\nPanchkula",R.drawable.saketri));
        places.add(new Place("Nada Sahib Gurudwara", "Nada Sahib\nPanchkula",R.drawable.nada_sahib));
        places.add(new Place("Pracheen Chandi Mandir", "Bhagwanpur\nPanchkula",R.drawable.chandi_mandir));
        places.add(new Place("Sai Baba Temple", "Sector 29\nChandigarh",R.drawable.sai));

        //Creating a custom Array Adapter for this Tourist Attractions
        PlacesAdapter placesAdapter = new PlacesAdapter(this, places);

        //Calling a listView to attach the Places Adapter to and then attaching it
        ListView mainListView = (ListView) findViewById(R.id.places_list);
        mainListView.setAdapter(placesAdapter);
    }
}
