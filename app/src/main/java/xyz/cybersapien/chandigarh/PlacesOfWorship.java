package xyz.cybersapien.chandigarh;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlacesOfWorship extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Creating an ArrayList of Object Place with information like Place Name, Address and the Image Drawable Id
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.mansa_devi_temple), getString(R.string.mansa_devi_address),R.drawable.mansa_devi));
        places.add(new Place(getString(R.string.saketri_temple), getString(R.string.saketri_address),R.drawable.saketri));
        places.add(new Place(getString(R.string.nada_sahib_gurudwara), getString(R.string.nada_sahib_address),R.drawable.nada_sahib));
        places.add(new Place(getString(R.string.chandi_mandir), getString(R.string.chandi_mandir_address),R.drawable.chandi_mandir));
        places.add(new Place(getString(R.string.sai_temple), getString(R.string.sai_mandir_chandigarh),R.drawable.sai));

        //Creating a custom Array Adapter for this Tourist Attractions
        PlacesAdapter placesAdapter = new PlacesAdapter(this, places);

        //Calling a listView to attach the Places Adapter to and then attaching it
        ListView mainListView = (ListView) findViewById(R.id.places_list);
        mainListView.setAdapter(placesAdapter);


        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog dialog = new Dialog(context);

                final String contact = places.get(position).getContactNumber();
                dialog.setContentView(R.layout.dialog_popup);
                dialog.setTitle(places.get(position).getPlaceName());

                TextView headingView = (TextView) dialog.findViewById(R.id.heading_view);
                headingView.setText(places.get(position).getPlaceName());

                TextView addressView = (TextView) dialog.findViewById(R.id.dialog_address);
                addressView.setText(places.get(position).getAddress());

                TextView phoneView = (TextView) dialog.findViewById(R.id.dialog_contact_tel);
                if (!contact.equals(Place.NO_CONTACT_INFO)){
                    phoneView.setText(contact);
                    phoneView.setVisibility(View.VISIBLE);
                    phoneView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            final Intent callIntent = new Intent(Intent.ACTION_DIAL);
                            callIntent.setData(Uri.parse("tel:" + contact));
                            startActivity(callIntent);
                        }
                    });
                } else {
                    phoneView.setVisibility(View.GONE);
                }

                dialog.show();
            }
        });
    }
}
