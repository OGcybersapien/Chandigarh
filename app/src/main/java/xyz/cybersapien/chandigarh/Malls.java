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

public class Malls extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Creating an ArrayList of Object Place with information like Place Name, Address and the Image Drawable Id
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getString(R.string.elante_mall), getString(R.string.elante_address),R.drawable.elante_mall));
        places.add(new Place(getString(R.string.tdi_mall), getString(R.string.sector_17), R.drawable.tdi_mall));
        places.add(new Place(getString(R.string.dlf_city_centre), getString(R.string.city_centre_address), R.drawable.dlf_city_centre));
        places.add(new Place(getString(R.string.city_emporium), getString(R.string.city_emporium_address),R.drawable.city_emporium));
        places.add(new Place(getString(R.string.city_plaza),getString(R.string.sector_17),R.drawable.sector_seventeen));
        places.add(new Place(getString(R.string.north_country_mall),getString(R.string.ncm_address),R.drawable.ncm_mohali));
        places.add(new Place(getString(R.string.paras_down_town),getString(R.string.paras_downtown_address),R.drawable.paras_downtown_square));


        //Creating a custom Array Adapter for this Malls ArrayList
        PlacesAdapter mainAdapter = new PlacesAdapter(this, places);

        //Calling a listView to attach the Places Adapter to and then attaching it
        ListView mainListView = (ListView) findViewById(R.id.places_list);
        mainListView.setAdapter(mainAdapter);

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog dialog = new Dialog(context);

                dialog.setContentView(R.layout.dialog_popup);
                dialog.setTitle(places.get(position).getPlaceName());

                TextView headingView = (TextView) dialog.findViewById(R.id.heading_view);
                headingView.setText(places.get(position).getPlaceName());

                TextView addressView = (TextView) dialog.findViewById(R.id.dialog_address);
                addressView.setText(places.get(position).getAddress());

                TextView phoneView = (TextView) dialog.findViewById(R.id.dialog_contact_tel);
                final String contact = places.get(position).getContactNumber();
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
