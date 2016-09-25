package xyz.cybersapien.chandigarh;

import java.util.Objects;

/**
 * Created by Cybersapien on 25/9/16.
 * This is the Object file for the places Objects for my app.
 * The Places will be divided into 4 categories,
 * 1. Tourist Attractions
 * 2. Best Hotels and Restaurants
 * 3. Malls
 * 4. Divine Temples
 *
 * For now, each object is limited to a picture, the name and address, a phone number(in case of Hotels and Restaurants)
 * Clicking on the Object will set off an Intent to the available maps apps for showing the exact location of the place.
 */

public class Place {

    private String placeName;
    private String address;
    private int imageID;
    private String contactNumber = NO_CONTACT_INFO;
    final static public String NO_CONTACT_INFO = "NO INFO";

    public Place(String placeName, String address, int imageID) {
        this.placeName = placeName;
        this.address = address;
        this.imageID = imageID;
        this.contactNumber = NO_CONTACT_INFO;
    }

    public Place(String placeName, String address, int imageID, String contactNumber) {
        this.placeName = placeName;
        this.address = address;
        this.imageID = imageID;
        this.contactNumber = contactNumber;
    }


    public String getPlaceName() {
        return placeName;
    }

    public String getAddress() {
        return address;
    }

    public int getImageID() {
        return imageID;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public boolean hasContactNumber(){
        return (!this.contactNumber.equals(NO_CONTACT_INFO));
    }
}
