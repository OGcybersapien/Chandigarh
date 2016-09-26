package xyz.cybersapien.chandigarh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class TouristAttraction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Creating an ArrayList of Object Place with information like Place Name, Address and the Image Drawable Id
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Rock Garden", "Sector 9\nChandigarh",R.drawable.rock_garden));
        places.add(new Place("Sukhna Lake", "Sector 1\nChandigarh",R.drawable.sukhna_lake));
        places.add(new Place("Garden of Silence", "Lake Walking Way\nChandigarh",R.drawable.garden_of_silence));
        places.add(new Place("Zakir Hussain Rose Garden", "Sector 16-B\nChandigarh",R.drawable.rose_garden));
        places.add(new Place("Open Hand Monument", "Sector 1\nChandigarh",R.drawable.open_hand ));
        places.add(new Place("Government Museum and Art Gallery", "Sector 10-C\nChandigarh",R.drawable.museum_of_art));
        places.add(new Place("ChattBir Zoo", "Birr Chatt\nSAS Nagar\nChandigarh",R.drawable.chattbir_zoo));
        places.add(new Place("The Tower of Shadows","Sector 1\nChandigarh",R.drawable.tower_of_silence));
        places.add(new Place("National Gallery of Portraits","Sector 17\nChandigarh", R.drawable.national_gallery_of_portraits));

        //Sorting of the ArrayList and a Custom Comparator for correct comparison of Objects
        //Although not really necessary, I felt the need to do this here
        Collections.sort(places, new Comparator<Place>() {
            @Override
            public int compare(Place o1, Place o2) {
                return o1.getPlaceName().compareTo(o2.getPlaceName());
            }
        });

        //Creating a custom Array Adapter for this Tourist Attractions
        PlacesAdapter placesAdapter = new PlacesAdapter(this, places);

        //Calling a listView to attach the Places Adapter to and then attaching it
        ListView mainListView = (ListView) findViewById(R.id.places_list);
        mainListView.setAdapter(placesAdapter);
    }
}
