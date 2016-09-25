package xyz.cybersapien.chandigarh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ogcybersapien on 25/9/16.
 * Adapter Class for Custom Object Places with option to display different types of data via the Overridden
 * getView Method.
 */

public class PlacesAdapter extends ArrayAdapter<Place> {

    public PlacesAdapter(Context context, List<Place> places){
        super(context, R.layout.list_item, places);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;

        //Inflate listView if listView is un-inflated
        if(listView==null){
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false
            );
        }

        //Get current Place from the given ArrayList
        Place currentPlace = getItem(position);

        //Initialize TextViews from the list layout
        TextView placeNameView = (TextView) listView.findViewById(R.id.placeName);
        TextView placeAddressView = (TextView) listView.findViewById(R.id.placeAddress);
        TextView placeContactView = (TextView) listView.findViewById(R.id.contactNumber);

        //Initialize the ImageView from the list Item Layout
        ImageView placeImageView = (ImageView) listView.findViewById(R.id.placeImage);

        //Set the texts to the value for current Place
        placeNameView.setText(currentPlace.getPlaceName());
        placeAddressView.setText(currentPlace.getAddress());
        placeImageView.setImageResource(currentPlace.getImageID());

        if (currentPlace.hasContactNumber()){
            placeContactView.setText(currentPlace.getContactNumber());
            placeContactView.setVisibility(View.VISIBLE);
        } else {
            placeContactView.setVisibility(View.GONE);
        }

        return listView;
    }
}
