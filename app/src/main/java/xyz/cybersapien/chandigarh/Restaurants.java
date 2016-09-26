package xyz.cybersapien.chandigarh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);

        //Creating an ArrayList of Place objects which will contain a number of Restaurants
        //The Place constructor here takes 4 input Parameters
        // Place Name, Place Address, Place Image and Official Contact number
        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Barbeque Nation","SCO 39\nMadhya Marg\nSector 26\nChandigarh",R.drawable.barbeque_nation,"(+91) 172 6060000"));
        places.add(new Place("24/7 Restaurant @ The Lalit","The Lalit\nRajiv Gandhi IT Park\nChandigarh",R.drawable.the_lalit,"(+91) 172 3007777"));
        places.add(new Place("Saffron","JW Marriott\nSector 35-B\nDakshin Marg\nChandigarh",R.drawable.saffron_marriott,"(+91) 172 3955555"));
        places.add(new Place("Gopals Sweets Restaurant & Cake Shop","SCO 8\nSector 35\nChandigarh",R.drawable.gopals,"(+91) 98 14 509221"));
        places.add(new Place("Pal Dhaba","SCO 151-152\nSector 28-D\nChandigarh",R.drawable.pal_dhabba,"(+91) 172 2650709"));
        places.add(new Place("Virgin Courtyard","SCO 1A\nSector 7-C\nChandigarh",R.drawable.virgin_courtyard,"(+91) 86 99 000999"));
        places.add(new Place("Pirates Of Grill","SCO 313\nElante Mall\nChandigarh",R.drawable.pirates_of_grill,"(+91) 172 4016444"));
        places.add(new Place("Masala Grill","SCO 1&2\nThe Cove\nSector 5\nPanchkula",R.drawable.masala_grill,"(+91) 172 6670919"));

        //Creating a PlacesAdapter for this Activity and the places ArrayList
        PlacesAdapter hotelAdapter = new PlacesAdapter(this, places);

        //Creating a listView to attach the said Places adapter
        ListView placesList = (ListView) findViewById(R.id.places_list);
        placesList.setAdapter(hotelAdapter);
    }
}
